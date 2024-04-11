import Library.Pages.MainPageFeatures;
import Library.Pages.TeamDetails;
import Library.Pages.WelcomePages.*;
import Library.Utilities.InfoTabLables;
import Library.Utilities.NFLTeams;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.logging.Logger;

public class TeamDetailsInfoTabTest extends TestBase {

    private static final Logger logger = getLogger(TeamDetailsInfoTabTest.class);
    String screenshotPath = "./src/test/java/Screenshots/TeamDetailsInfoTabTest/";
    public static Welcome welcomePage;
    public static MainPageFeatures mainPage;

    @BeforeClass
    public static void prepare() {
        AndroidDriver driver = getDriver();
        welcomePage = new Welcome(driver);

        //Navigate through the welcome pages
        // Click 'Get Started' on the welcome page
        ChooseLeague chooseLeaguePage = welcomePage.clickGetStarted();

        //Choose the first listed league and click next
        TailoredContentModal tailoredContentModal = chooseLeaguePage.chooseFirstLeagueAndContinue();

        // Choose maybe later for location services
        ChooseTeam chooseTeamPage = tailoredContentModal.clickMaybeLater();

        // Choose the first team and click continue
        NotificationSettings notificationSettingsPage = chooseTeamPage.chooseFirstTeamAndContinue();

        // Click done on notifications page
        MessagingPage messagingPage = notificationSettingsPage.clickDone();

        //Click maybe later on messaging page
        mainPage = messagingPage.clickMaybeLater();


    }


    @Test
    public void teamDetailsInfoTabTest() throws Exception {
        /**
         * This test case covers the following:
         * Step 1. Open a league, team, or player page of your choice
         *
         * 2.Verify that the expected page opens correctly.
         *
         * 3. Tap on a sub-tab of your choice, eg: league table / standings / leaders, or
         * stats tab of the league, team, or player.
         *
         * 4. Verify that you are on the correct tab and that the data is displayed
         * correctly and corresponds to the league, team, or player from step 1.
         *
         * 5.Verify that back navigation returns you to the previous page correctly.
         */

        logger.info("Step 1: navigate to team page of a team using the search functionality");
        List<List<WebElement>> searchResults = mainPage.enterTermInSearch(NFLTeams._49ERS.getName());
        List<String> allResultsText = mainPage.getResultTextList(searchResults);
        WebElement matchingResult = mainPage.findMatchingSearchResult(NFLTeams._49ERS.getName(),
                searchResults);
        try {
            mainPage
                    .takeScreenShot(screenshotPath,
                            "teamDetailsInfoTabTest_step1_" + System.currentTimeMillis());
        } catch (Exception e) {
            logger.severe("Couldn't get screenshot of step 1");
            e.printStackTrace();
        }
        TeamDetails teamDetailsPage = mainPage.clickTeamResult(matchingResult);

        logger.info("Step 2: Verify that the expected page opens correctly.");
        assert teamDetailsPage.teamName().isDisplayed();
        assert teamDetailsPage.teamRecordValue().isDisplayed();
        assert teamDetailsPage.teamRecordLabel().isDisplayed();
        assert teamDetailsPage.teamStreakValue().isDisplayed();
        assert teamDetailsPage.teamStreakLabel().isDisplayed();
        assert teamDetailsPage.teamLogo().isDisplayed();
        assert teamDetailsPage.teamDescription().isDisplayed();
        assert teamDetailsPage.isTeamNameCorrect(NFLTeams._49ERS.getName());
        try {
            mainPage
                    .takeScreenShot(screenshotPath,
                            "teamDetailsInfoTabTest_step2_" + System.currentTimeMillis());
        } catch (Exception e) {
            logger.severe("Couldn't get screenshot of step 2");
            e.printStackTrace();
        }

        logger.info(
                "Step 3: Tap on a sub-tab of your choice, eg: league table / standings / leaders, or stats tab of the league, team, or player..");
        teamDetailsPage.swipeToTabVisible("Info");
        teamDetailsPage.clickTab("Info");
        try {
            teamDetailsPage
                    .takeScreenShot(screenshotPath,
                            "teamDetailsInfoTabTest_step3_" + System.currentTimeMillis());
        } catch (Exception e) {
            logger.severe("Couldn't get screenshot of step 3");
            e.printStackTrace();
        }

        logger.info(
                "Step 4: Verify that you are on the correct tab and that the data is displayed correctly and corresponds to the league, team, or player from step 1.");
        assert teamDetailsPage.infoTab().isSelected();
        assert teamDetailsPage.isTitleValueMatch(InfoTabLables.HEAD_COACH.toString(),
                NFLTeams._49ERS.getHeadCoach());
        assert teamDetailsPage.isTitleValueMatch(InfoTabLables.STADIUM.toString(),
                NFLTeams._49ERS.getStadium());
        assert teamDetailsPage.isTitleValueMatch(InfoTabLables.LOCATION.toString(),
                NFLTeams._49ERS.getLocation());
        try {
            teamDetailsPage
                    .takeScreenShot(screenshotPath,
                            "teamDetailsInfoTabTest_step4_" + System.currentTimeMillis());
        } catch (Exception e) {
            logger.severe("Couldn't get screenshot of step 4");
            e.printStackTrace();
        }

        logger.info(
                "Verify that back navigation returns you to the previous page correctly.");
        teamDetailsPage.goBack();
        assert mainPage.areSearchResultsTheSame(allResultsText);
        try {
            mainPage
                    .takeScreenShot(screenshotPath,
                            "teamDetailsInfoTabTest_step5_" + System.currentTimeMillis());
        } catch (Exception e) {
            logger.severe("Couldn't get screenshot of step 5");
            e.printStackTrace();
        }


    }

}
