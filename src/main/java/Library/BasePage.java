package Library;

import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.logging.Logger;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

  static Logger logger = Logger.getLogger(BasePage.class.getName());


  public AndroidDriver driver;
  public WebDriverWait webDriverWait;
  public Actions actions;
  public JavascriptExecutor js;

  public final int STANDARD_TIMEOUT = 60;


  public BasePage(AndroidDriver driver) {
    this.driver = driver;
    webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(STANDARD_TIMEOUT).getSeconds());
    actions = new Actions(driver);
    PageFactory.initElements(driver, this);
    js = (JavascriptExecutor) this.driver;
  }


  public void takeScreenShot(String fileDestinationPath, String fileName)
      throws Exception {

    String fileWithDestinationPath = fileDestinationPath + fileName;

    try {
      TakesScreenshot screenshot = ((TakesScreenshot) driver);
      File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
      File savedFile = new File(fileWithDestinationPath + ".png");

      FileUtils.copyFile(sourceFile, savedFile);

      logger.info("Screenshot " + fileWithDestinationPath + " saved successfully");
    } catch (IOException ioException) {
      ioException.printStackTrace();
    }

  }

  // Generic method to get a WebElement by locator
  protected WebElement getElement(By locator) {
    return webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  // Generic method to get a WebElement by locator
  protected List<WebElement> getElements(By locator) {
    return webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
  }

  public void click(WebElement webElement) {
    webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    webElement.click();
  }

  public boolean isDisplayed(WebElement webElement) {
    webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
    return webElement.isDisplayed();
  }

  public void waitPageLoad(WebElement webElement) {
    webDriverWait.until(ExpectedConditions.visibilityOf(webElement));
  }


}
