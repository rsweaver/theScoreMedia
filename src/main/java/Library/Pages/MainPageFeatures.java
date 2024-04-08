package Library.Pages;

import Library.BasePage;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebElement;

/**
 * This class represents a main page that most pages have common features with like searching.
 * Provides methods to interact with some of those overarching features.
 * <p>
 * Author: Rebecca Hilburn
 **/
public class MainPageFeatures extends BasePage {


  //search bar
  public WebElement searchBar() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/search_bar_text_view"));

  }

  //search bar text input
  public WebElement searchBarTextField() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/search_src_text"));

  }

  //search result containers
  public List<WebElement> searchResults() {
    return getElements(
        MobileBy.xpath("//androidx.recyclerview.widget.RecyclerView/android.widget.LinearLayout"));

  }

  //the element that holds the search result text
  public List<WebElement> searchResultsText() {
    return getElements(MobileBy.xpath(
        "//androidx.recyclerview.widget.RecyclerView[@resource-id='com.fivemobile.thescore:id/recyclerView']//android.widget.TextView[@resource-id='com.fivemobile.thescore:id/txt_name']"));

  }

  //favorites navigation item
  public WebElement favoritesIcon() {
    return getElement(MobileBy.AccessibilityId("Favorites"));

  }

  //back navigation item
  public WebElement backButton() {
    return getElement(MobileBy.AccessibilityId("Navigate up"));

  }

  // class constructor
  public MainPageFeatures(AndroidDriver driver) {
    super(driver);
  }


  /**
   * Given a string search term, clicks into the search bar and enters the term.  Returns a list of
   * webelements corresponding to the clickable items and a list of the text associated with each
   * item
   *
   * @param searchTerm - String search term
   * @return A list of the search results items (list) and the search result items text(list) , note
   * this list should be ordered (search result item list, search result item text list)
   **/
  public List<List<WebElement>> enterTermInSearch(String searchTerm) {
    List<List<WebElement>> searchItemListAndText = new ArrayList<>();
    this.searchBar().click();
    this.searchBarTextField().sendKeys(searchTerm);

    List<WebElement> items = searchResults();
    List<WebElement> itemText = searchResultsText();
    searchItemListAndText.add(items);
    searchItemListAndText.add(itemText);

    return searchItemListAndText;
  }

  /**
   * Takes a list of search result items list and text list and adds all the text to a list
   *
   * @param searchResults List<List<WebElement>> a list of the search results from before, note this
   *                      list should be ordered (search result item list, search result item text
   *                      list)
   * @return A list of the search result items text
   **/
  public List<String> getResultTextList(List<List<WebElement>> searchResults) {
    List<String> searchItemsText = new ArrayList<>();

    List<WebElement> itemTextList = searchResults.get(1);
    for (WebElement itemText : itemTextList) {
      searchItemsText.add(itemText.getText());

    }
    return searchItemsText;
  }

  /**
   * Given a string search term, checks the provided search results.  If there is a match in the
   * results, returns the matching interactable webelement, otherwise returns null.
   *
   * @param searchResults List<List<WebElement>> a list of the search results from before, note this
   *                      list should be ordered (search result item list, search result item text
   *                      list)
   * @param searchTerm    - String search term
   * @return WebElement matching the term
   **/
  public WebElement findMatchingSearchResult(String searchTerm,
      List<List<WebElement>> searchResults) {
    WebElement webElementToReturn = null;
    List<WebElement> searchResultItems = searchResults.get(0);
    List<WebElement> searchResultsText = searchResults.get(1);

    for (int i = 0; i <= searchResultsText.size() - 1; i++) {
      if (searchResultsText.get(i).getText().equals(searchTerm)) {
        webElementToReturn = searchResultItems.get(i);
        break;
      }
    }

    return webElementToReturn;
  }

  /**
   * Given a string Team Name, clicks into the search bar and enters the term.  If there is an exact
   * match in the results, returns the matching webelement and clicks it to return the appropriate
   * details page.
   *
   * @param teamName - String team name
   * @return DetailsPage detail page of the matching webelemnt
   **/

  public TeamDetails searchForTeamAndClick(String teamName) {
    TeamDetails teamDetailsPage = new TeamDetails(driver);
    List<List<WebElement>> searchItems = enterTermInSearch(teamName);
    WebElement searchItem = findMatchingSearchResult(teamName, searchItems);
    if (searchItem != null) {
      searchItem.click();
    }
    return teamDetailsPage;
  }

  /**
   * Clicks the webelement from the search results to return the TeamDetails page object
   *
   * @return TeamDetails page object
   **/

  public TeamDetails clickTeamResult(WebElement webElement) {
    TeamDetails teamDetailsPage = new TeamDetails(driver);
    webElement.click();
    return teamDetailsPage;
  }


  /**
   * Clicks the back button to return to the previous page
   **/

  public void goBack() {
    backButton().click();
  }

  /**
   * Validates that you are on the search results page and that the search results from before are
   * still present
   *
   * @param previousSearchText List<String> a list of the search results text from before
   * @return true if so, false if not
   **/

  public boolean areSearchResultsTheSame(List<String> previousSearchText) {
    boolean areTheSearchResultsSame = false;

    List<WebElement> listOfCurrentSearchResults = searchResultsText();
    if (searchBarTextField().isDisplayed()
        && previousSearchText.size() <= listOfCurrentSearchResults.size()) {
      for (int i = 0; i <= previousSearchText.size() - 1; i++) {
        if (!listOfCurrentSearchResults.get(i).getText()
            .equals(previousSearchText.get(i))) {
          areTheSearchResultsSame = false;
          break;
        }
        areTheSearchResultsSame = true;
      }

    }
    return areTheSearchResultsSame;
  }

}
