package itd.vastchain.sdk.core;

import itd.vastchain.sdk.exception.VctcException;

public interface VctcApi {

    <T> T request() throws VctcException;
}
