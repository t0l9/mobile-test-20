package config;

import org.aeonbits.owner.Config;

@Config.Sources({"classpath:config/mobile.properties"})
public interface MobileConfig extends Config {
    @Key("browserstack.user")
    String user();

    @Key("browserstack.key")
    String key();

    @Key("browserstack.url")
    String hubUrl();

    @Key("app.android")
    String androidApp();

    @Key("app.ios")
    String iosApp();

    @Key("device.android")
    String androidDevice();

    @Key("os.android")
    String androidOS();

    @Key("device.ios")
    String iosDevice();

    @Key("os.ios")
    String iosOS();

    @Key("platform")
    String platform(); // android или ios
}
