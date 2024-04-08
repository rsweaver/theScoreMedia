import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.net.URL;
import java.util.logging.Logger;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeClass;

public class TestBase {

  protected static AndroidDriver driver;

  @BeforeClass
  public static void setupAppium() throws Exception {
    // Location of the app
    File app = new File(".//APKs", "theScore.apk");

    // Create an object of Desired Capabilities
    DesiredCapabilities capability = new DesiredCapabilities();
    // OS Name
    capability.setCapability("device", "Android");
    // Mobile OS version. In My case it's running on Android 12
    capability.setCapability(CapabilityType.VERSION, System.getProperty("android.version"));
    capability.setCapability("app", app.getAbsolutePath());
    // Setup the device name
    capability.setCapability("deviceName", System.getProperty("device.name"));
    capability.setCapability("platformName", "Android");
    // Create the driver object with new URL and Capabilities
    driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capability);
  }

  public static AndroidDriver getDriver() {
    return driver;
  }

  public static Logger getLogger(Class<?> clazz) {
    return Logger.getLogger(clazz.getName());
  }
}


