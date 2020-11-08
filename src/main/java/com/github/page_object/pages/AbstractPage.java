package com.github.page_object.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.util.EnvironmentVariables;
import net.thucydides.core.util.SystemEnvironmentVariables;
import org.openqa.selenium.WebDriver;

public abstract class AbstractPage extends PageObject {

    public AbstractPage(final WebDriver webDriver){  //dependency injection
        super(webDriver);
        getDriver().manage().window().maximize();
        waitForAngularRequestsToFinish();
        scrollToTop();
    }

    public void scrollToTop() {
        final String scrollScript = "window.scrollTo(0, -100);"; //js code which has scroll
        getJavascriptExecutorFacade().executeScript(scrollScript); //метод который умеет выполнять /js code
    }

    public String getSerenityPropertiesValues(){
        EnvironmentVariables variables = SystemEnvironmentVariables.createEnvironmentVariables();
        String baseurl  = variables.getProperty("webdriver.base.url");
        System.out.println(baseurl);
        return baseurl;
    }

    public void reloadPage() {
        getDriver().navigate().refresh();
    }

    public String getCurrentUrl() {
        return getDriver().getCurrentUrl();
    }

}
