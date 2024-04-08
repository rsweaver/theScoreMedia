package Library.Pages;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;

public class FavoritesPage extends MainPageFeatures {

  public FavoritesPage(AndroidDriver driver) {
    super(driver);
  }


  //search bar
  public WebElement searchBar() {
    return getElement(MobileBy.id("com.fivemobile.thescore:id/search_bar_text_view"));

  }

}
