package Library.Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import io.appium.java_client.touch.offset.PointOption;

/**
 * This class represents a detail page that most team, leauge, etc pages have common features with
 * like the different tabs. Provides methods to interact with some of those overarching features.
 *
 * Author: Rebecca Hilburn
 **/
public class DetailPage extends MainPageFeatures{

  // tab layout (contains things like player stats, info, chat, etc)
  public WebElement tabLayout() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/tabLayout"));
  }

  public DetailPage(AndroidDriver driver) {
    super(driver);
  }

  /**
   * Swipes left on the tab layout to navigate to the next tab.
   */
  public void swipeLeftOnTabLayout() {
    // Find the tab layout
    WebElement tabLayout = this.tabLayout();

    // Calculate start and end points for swipe action
    int startX = tabLayout.getLocation().getX() + tabLayout.getSize().getWidth() * 3 / 4;
    int startY = tabLayout.getLocation().getY() + tabLayout.getSize().getHeight() / 2;
    int endX = tabLayout.getLocation().getX() + tabLayout.getSize().getWidth() / 4;
    int endY = tabLayout.getLocation().getY() + tabLayout.getSize().getHeight() / 2;

    // Perform swipe action
    TouchAction touchAction = new TouchAction(driver);
    touchAction.longPress(PointOption.point(startX, startY))
        .moveTo(PointOption.point(endX, endY))
        .release()
        .perform();
  }
}
