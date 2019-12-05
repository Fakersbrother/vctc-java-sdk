package io.vastchain.sdk.util;

import io.vastchain.sdk.param.ApiRequestParam;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * 计算上链接口所需要的签名。
 */
public class Signature {

    /**
     *  对一个宇链云 API 调用进行签名，返回签名字符串。此方法中 query 必须包含 _appId 和 _t，不能包含 _
     * @param api 接口请求相关参数
     * @param httpMethod
     * @param body
     * @return
     */
    public static String sign(ApiRequestParam api, String httpMethod, String body) {
        String query = api.getQuery();
        String appId = api.getAppId();
        String appSecret = api.getAppSecret();
        String hostUrl = api.getHostUrl();
        String path = api.getPath();
        if (query == null) {
            query = "";
        }
        // 在 Query 中拼接 _appid 和 时间戳 _t
        String appendedQuery = "_appid=" + appId + "&_t=" + new Date().getTime();

        if (query.equals("")) {
            query = appendedQuery;
        } else {
            query = query + "&" + appendedQuery;
        }

        // 解析 query 并进行字典序排序
        TreeMap<String, List<String>> queryList = null;
        try {
            queryList = new TreeMap<>(splitQuery(new URL(hostUrl + path + "?" + query)));
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null;
        }

        // 使用排序后的结果拼接 query
        String sortedQuery = "", sortedEncodedQuery = "";

        for (Map.Entry<String, List<String>> entry : queryList.entrySet()) {
            if (entry.getKey().equals("_s")) break;
            if (entry.getKey().equals("_appid") && entry.getValue().size() != 1)
                throw new IllegalArgumentException("query could not contain _appid");
            if (entry.getKey().equals("_t") && entry.getValue().size() != 1)
                throw new IllegalArgumentException("query could not contain _t");

            String item = entry.getKey() + "=" + String.join("&" + entry.getKey() + "=", entry.getValue());

            for (int i = 0; i < entry.getValue().size(); ++i) {
                try {
                    entry.getValue().set(i, URLEncoder.encode(entry.getValue().get(i), "UTF-8"));
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
            }

            String itemEncoded = entry.getKey() + "=" + String.join("&" + entry.getKey() + "=", entry.getValue());

            if (sortedQuery.equals("")) {
                sortedQuery = item;
                sortedEncodedQuery = itemEncoded;

            } else {
                sortedQuery += "&" + item;
                sortedEncodedQuery += "&" + itemEncoded;
            }
        }

        String toBeSignatured;
        httpMethod = httpMethod.toUpperCase();

        if (httpMethod.equals("POST") && body != null && !body.equals("")) {
            toBeSignatured = httpMethod + " " + path + "\n" + sortedQuery + "\n" + body;
        } else {
            toBeSignatured = httpMethod + " " + path + "\n" + sortedQuery;
        }

        String signature = HMACSHA256(toBeSignatured, appSecret);

        String url = hostUrl + path + "?" + sortedEncodedQuery + "&_s=" + signature;
        return url;
    }

    private static Map<String, List<String>> splitQuery(URL url) {
        try {
            final Map<String, List<String>> query_pairs = new LinkedHashMap<String, List<String>>();
            final String[] pairs = url.getQuery().split("&");
            for (String pair : pairs) {
                final int idx = pair.indexOf("=");
                final String key = idx > 0 ? URLDecoder.decode(pair.substring(0, idx), "UTF-8") : pair;
                if (!query_pairs.containsKey(key)) {
                    query_pairs.put(key, new LinkedList<String>());
                }
                final String value = idx > 0 && pair.length() > idx + 1 ? URLDecoder.decode(pair.substring(idx + 1), "UTF-8") : null;
                query_pairs.get(key).add(value);
            }
            return query_pairs;
        } catch (UnsupportedEncodingException ex) {
            return null;
        }
    }

    /**
     * 生成 HMAC-SHA256 签名。
     *
     * @param data 待签名字符串
     * @param key  密钥
     * @return
     */
    private static String HMACSHA256(String data, String key) {
        try {
            Mac sha256_HMAC = Mac.getInstance("HmacSHA256");

            SecretKeySpec secret_key = new SecretKeySpec(key.getBytes("UTF-8"), "HmacSHA256");
            sha256_HMAC.init(secret_key);
            byte[] array = sha256_HMAC.doFinal(data.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder();
            for (byte item : array) {
                sb.append(Integer.toHexString((item & 0xFF) | 0x100).substring(1, 3));
            }

            return sb.toString().toLowerCase();
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException | InvalidKeyException e) {
            e.printStackTrace();

            return null;
        }
    }
}
