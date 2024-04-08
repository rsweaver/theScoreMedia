package Library.Pages.WelcomePages;

import Library.BasePage;
import Library.Pages.MainPageFeatures;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class MessagingPage extends BasePage {


  //PageObjects for tests
  //maybe later button
  public WebElement maybeLaterButton() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/btn_secondary"));

  }

  public MessagingPage(AndroidDriver driver) {
    super(driver);
  }


  public MainPageFeatures clickMaybeLater() {
    MainPageFeatures mainPageFeatures = new MainPageFeatures(driver);
    this.maybeLaterButton().click();
    return mainPageFeatures;

  }


}


