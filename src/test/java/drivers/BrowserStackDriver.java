package drivers;

import com.codeborne.selenide.WebDriverProvider;
import helpers.MobileConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import javax.annotation.Nonnull;
import java.net.URL;

public class BrowserStackDriver implements WebDriverProvider {

    @Nonnull
    @Override
    public WebDriver createDriver(@Nonnull org.openqa.selenium.Capabilities capabilities) {
        MobileConfig config = ConfigFactory.create(MobileConfig.class);

        MutableCapabilities caps = new MutableCapabilities();
        caps.setCapability("browserstack.user", System.getProperty("bs_user"));
        caps.setCapability("browserstack.key", System.getProperty("bs_key"));

        caps.setCapability("app", config.app());
        caps.setCapability("device", config.device());
        caps.setCapability("os_version", config.osVersion());

        caps.setCapability("project", "Mobile Tests");
        caps.setCapability("build", "browserstack-build");
        caps.setCapability("name", config.platformName() + " test");

        try {
            return new RemoteWebDriver(new URL("https://hub.browserstack.com/wd/hub"), caps);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
