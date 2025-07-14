package helpers;

import org.aeonbits.owner.Config;

@Config.Sources({
        "file:src/test/resources/${platform}.properties"
})

public interface MobileConfig extends Config {
    @Key("platformName") String platformName();
    @Key("device") String device();
    @Key("os_version") String osVersion();
    @Key("app") String app();
}
