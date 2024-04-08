package Library.Pages.WelcomePages;

import Library.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class NotificationSettings extends BasePage {


  //PageObjects for tests
  //done button
  public WebElement doneButton() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary"));

  }

  public NotificationSettings(AndroidDriver driver) {
    super(driver);
  }

  /**
   * Clicks done on the notifications page and brings you to the main features page
   *
   * @return MainPageFeatures page object
   **/

  public MessagingPage clickDone() {
    MessagingPage messagingPage = new MessagingPage(driver);
    doneButton().click();
    return messagingPage;

  }

}
