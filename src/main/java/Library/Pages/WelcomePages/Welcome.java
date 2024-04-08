package Library.Pages.WelcomePages;

import Library.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class Welcome extends BasePage {


  //PageObjects for tests
  public WebElement getStartedButton() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary"));

  }


  public Welcome(AndroidDriver driver) {
    super(driver);
  }


  public ChooseLeague clickGetStarted() {
    ChooseLeague chooseLeaguePage = new ChooseLeague(driver);
    getStartedButton().click();
    return chooseLeaguePage;
  }

}
