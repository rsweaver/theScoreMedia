package Library.Pages.WelcomePages;

import Library.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.WebElement;

public class ChooseTeam extends BasePage {


  //PageObjects for tests
  //Continue button
  public WebElement continueButton() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary"));
  }


  //team list options
  public List<WebElement> teamOption() {
    return getElements(
        MobileBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout"));

  }

  //favorite button
  public WebElement favoriteButton() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/btn_primary"));
  }


  public ChooseTeam(AndroidDriver driver) {
    super(driver);
  }

  public NotificationSettings clickContinue() {
    NotificationSettings notificationsSettings = new NotificationSettings(driver);
    continueButton().click();
    return notificationsSettings;
  }


  /**
   * Chooses the first team option on the team list page
   */

  public void chooseFirstTeam() {
    List<WebElement> teamOption = teamOption();
    teamOption.get(0).click();

  }

  /**
   * Chooses the first league option on the team list page and then hits continue.
   *
   * @return TailoredContentModal modal for location services
   */

  public NotificationSettings chooseFirstTeamAndContinue() {
    chooseFirstTeam();
    NotificationSettings notificationsSettings = clickContinue();
    return notificationsSettings;

  }

}
