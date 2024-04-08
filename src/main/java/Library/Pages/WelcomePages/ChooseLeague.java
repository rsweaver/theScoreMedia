package Library.Pages.WelcomePages;

import Library.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ChooseLeague extends BasePage {


  //PageObjects for tests
  //Continue button
  public WebElement continueButton() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary"));

  }

  //league list option
  public List<WebElement> leagueOptions() {
    return getElements(
        MobileBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout"));

  }

  //League options text
  public WebElement optionText() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/txt_name"));

  }


  public ChooseLeague(AndroidDriver driver) {
    super(driver);
  }

  /**
   * Clicks continue which leads to the tailored content modal
   *
   * @return TailoredContentModal modal for location services
   */
  public TailoredContentModal clickContinue() {
    TailoredContentModal tailoredContentModal = new TailoredContentModal(driver);
    continueButton().click();
    return tailoredContentModal;
  }


  /**
   * Chooses the first league option on the team list page
   */
  public void chooseFirstLeague() {
    List<WebElement> leagueOptionsList = leagueOptions();
    leagueOptionsList.get(0).click();
  }

  /**
   * Chooses the first league option on the team list page and then hits continue.
   *
   * @return TailoredContentModal modal for location services
   */

  public TailoredContentModal chooseFirstLeagueAndContinue() {
    this.chooseFirstLeague();
    TailoredContentModal tailoredContentModal = clickContinue();
    return tailoredContentModal;

  }
}
