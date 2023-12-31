package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import retryAnalyzer.retryAnalyzer;
public class AuthRoutesTest extends BasicTest{

    @Test(priority = 1, retryAnalyzer = retryAnalyzer.class)
    public void visitsHomePage() throws InterruptedException {

        driver.get(baseUrl + "/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }

    @Test(priority = 2, retryAnalyzer = retryAnalyzer.class)
    public void visitsProfilePage() throws InterruptedException {
        driver.get(baseUrl + "/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }

    @Test(priority = 3, retryAnalyzer = retryAnalyzer.class)
    public void forbidVisitsToAdminCitiesUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
    @Test(priority = 4, retryAnalyzer = retryAnalyzer.class)
    public void forbidVisitsToAdminUsersUrlIfNotAuthenticated() throws InterruptedException {
        driver.get(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login", "Current url should be " + baseUrl + "/login");
    }
}

