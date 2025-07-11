package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    static MobileConfig config = ConfigFactory.create(MobileConfig.class);

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull org.openqa.selenium.Capabilities ignoredCapabilities) {
        String platform = config.platform().toLowerCase();

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserstack.user", config.user());
        caps.setCapability("browserstack.key", config.key());

        if (platform.equals("android")) {
            caps.setCapability("app", config.androidApp());
            caps.setCapability("device", config.androidDevice());
            caps.setCapability("os_version", config.androidOS());
        } else if (platform.equals("ios")) {
            caps.setCapability("app", config.iosApp());
            caps.setCapability("device", config.iosDevice());
            caps.setCapability("os_version", config.iosOS());
        } else {
            throw new IllegalArgumentException("Платформа не найдена: " + platform);
        }

        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "browserstack-build-1");
        caps.setCapability("name", "test_on_" + platform);

        try {
            return new RemoteWebDriver(new URL(config.hubUrl()), caps);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
