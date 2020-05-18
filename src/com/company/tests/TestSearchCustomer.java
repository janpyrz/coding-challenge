package com.company.tests;

import com.company.pages.SearchCustomersPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestSearchCustomer {
    String driverPath = "C:\\Program Files\\Java\\geckodriver.exe";
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.gecko.driver", driverPath);

        driver = new FirefoxDriver();
        driver.get("file:///C:/Users/Janek/IdeaProjects/Automation/ui/index.html");
        driver.manage().window().maximize();
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void testPageTitle() {
        SearchCustomersPage searchCustomersPage = new SearchCustomersPage(driver);

        Assert.assertEquals("Customers", searchCustomersPage.getTitle());
    }

    @Test
    public void testSearchByEmail() {
        SearchCustomersPage searchCustomersPage = new SearchCustomersPage(driver);

        String email = "conatact@postimex.pl";

        searchCustomersPage.searchFor(email);
        searchCustomersPage.selectAttributeByValue("Email");

        Assert.assertTrue(searchCustomersPage.getTableText().contains(email));
        Assert.assertEquals(1, searchCustomersPage.getTableRowCount());
    }

    @Test
    public void testMatchCase() {
        SearchCustomersPage searchCustomersPage = new SearchCustomersPage(driver);

        searchCustomersPage.searchFor("alabaster");
        Assert.assertEquals(1, searchCustomersPage.getTableRowCount());

        searchCustomersPage.checkMatchCaseBox();
        Assert.assertEquals(0, searchCustomersPage.getTableRowCount());

        searchCustomersPage.searchFor("Alabaster");
        Assert.assertEquals(1, searchCustomersPage.getTableRowCount());
    }
}
