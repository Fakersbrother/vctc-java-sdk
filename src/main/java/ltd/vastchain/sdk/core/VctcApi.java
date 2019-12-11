package ltd.vastchain.sdk.core;

import ltd.vastchain.sdk.exception.VctcException;

public interface VctcApi {

    <T> T request() throws VctcException;
}
