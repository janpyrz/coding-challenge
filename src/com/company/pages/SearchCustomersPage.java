package com.company.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SearchCustomersPage {
    WebDriver driver;
    By searchInput = By.id("search-input");
    By searchSelect = By.id("search-column");
    By table = By.tagName("tbody");
    By matchCase = By.id("match-case");

    public SearchCustomersPage(WebDriver driver) {
        this.driver = driver;
    }

    public void searchFor(String text) {
        WebElement searchElement = driver.findElement(searchInput);
        searchElement.clear();
        searchElement.sendKeys(text);
    }

    public void selectAttributeByValue(String value) {
        Select dropdown = new Select(driver.findElement(searchSelect));
        dropdown.selectByValue(value);
    }

    public int getTableRowCount() {
        WebElement tableElement = driver.findElement(table);
        return tableElement.findElements(By.tagName("tr")).size();
    }

    public String getTableText() {
        return driver.findElement(table).getText();
    }

    public void checkMatchCaseBox() {
        driver.findElement(matchCase).click();
    }

    public String getTitle() {
        return driver.getTitle();
    }
}
