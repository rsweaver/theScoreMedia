package Library.Pages.WelcomePages;

import Library.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class TailoredContentModal extends BasePage {

  //PageObjects for tests
  //Maybe Later option
  public WebElement maybeLaterButton() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/btn_disallow"));

  }

  public TailoredContentModal(AndroidDriver driver) {
    super(driver);
  }

  /**
   * Clicks the maybe later button on the tailored content modal and returns the ChooseTeam page
   * object
   *
   * @returns ChooseTeam page object
   */

  public ChooseTeam clickMaybeLater() {
    ChooseTeam chooseTeamPage = new ChooseTeam(driver);
    maybeLaterButton().click();
    return chooseTeamPage;

  }
}
