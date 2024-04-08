package Library.Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This class represents a Team Detail page that will have distinct details specifically for teams
 * <p>
 * Author: Rebecca Hilburn
 **/
public class TeamDetails extends DetailPage {

  //Page Objects

  // Team name
  public WebElement teamName() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/team_name"));
  }

  // Team description
  public WebElement teamDescription() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/team_description"));
  }

  // Team logo
  public WebElement teamLogo() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/team_logo"));
  }

  // Team record value
  public WebElement teamRecordValue() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/team_form_value"));
  }

  // Team record value
  public WebElement teamRecordLabel() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/team_form_label"));
  }

  // Team streak value
  public WebElement teamStreakLabel() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/streak_label"));
  }

  // Team streak value
  public WebElement teamStreakValue() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/streak_value"));
  }

  // Info tab
  public WebElement infoTab() {
    return getElement(MobileBy.AccessibilityId("Info"));
  }

  // Info tab details label
  public List<WebElement> infoTabDetailsLabel() {
    return driver.findElements(MobileBy.id("com.fivemobile.thescore:id/title"));
  }

  // Info tab value under label
  public List<WebElement> infoTabLabelValue() {
    return driver.findElements(MobileBy.id("com.fivemobile.thescore:id/value"));
  }

  public TeamDetails(AndroidDriver driver) {
    super(driver);
  }

  /**
   * Swipes on the tab layout and clicks on the desired provided tab
   *
   * @param tab The tab to click.
   */
  public void swipeToTabVisible(String tab) {
    boolean isTabClickable = false;
    int tryCount = 0;
    int maxTries = 10;
    while (!isTabClickable && tryCount < maxTries) {
      swipeLeftOnTabLayout();
      try {
        if (tab.equals("Info")) {
          WebDriverWait wait = new WebDriverWait(driver, 5);
          wait.until(ExpectedConditions.elementToBeClickable(infoTab()));
          isTabClickable = true;
        }
      } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
        // Tab is not visible yet, continue swiping
      }
      tryCount++;
    }
  }

  /**
   * Clicks on the tab if it is present
   *
   * @param tab The tab to click.
   */
  public void clickTab(String tab) {
    try {
      if (tab.equals("Info")) {
        infoTab().click();
      }
    } catch (NoSuchElementException | org.openqa.selenium.TimeoutException e) {
    }
  }

  /**
   * Checks if the provided label and label value match the details label and its corresponding
   * value on the page.
   *
   * @param title The label to be matched.
   * @param value The value corresponding to the label.
   * @return {@code true} if the label and its value match the expected details label and value,
   * {@code false} otherwise.
   */
  public boolean isTitleValueMatch(String title, String value) {
    List<WebElement> infoTabDetails = infoTabDetailsLabel();
    List<WebElement> infoTabLabelValues = infoTabLabelValue();
    for (int i = 0; i < infoTabDetails.size(); i++) {
      String titleLabel = infoTabDetails.get(i).getText();
      String valueLabel = infoTabLabelValues.get(i).getText();

      if (titleLabel.equals(title) && valueLabel.equals(value)) {
        return true;
      }
    }
    return false;
  }


  /**
   * Checks if the provided team name matches the team name on the page
   *
   * @param name name to be matched.
   * @return {@code true} if the team name is the expected value, {@code false} otherwise.
   */
  public boolean isTeamNameCorrect(String name) {

    if (teamName().getText().equals(name)) {
      return true;

    }
    return false;
  }


}
