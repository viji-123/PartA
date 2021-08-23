package tescases;

import config.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.BaseClass;
import pages.SearchPage;
import utility.BrowserUtility;


public class NavigateTest extends BaseClass {

    @Test
    public void navigateUrl()
    {
        SearchPage searchPage = PageFactory.initElements(driver, SearchPage.class);
        PropertiesFile propertiesFile = PageFactory.initElements(driver , PropertiesFile.class);

        searchPage.searchText(propertiesFile.readPropertiesFile().getProperty("text"));
        searchPage.resultsFind();
    }

}
