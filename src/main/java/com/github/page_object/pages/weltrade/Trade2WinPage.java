package com.github.page_object.pages.weltrade;

import com.github.common.data.PartialUrl;
import com.github.page_object.model.weltrade.WinnersDrawDTO;
import com.github.page_object.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "promotions/trade2win/")
public class Trade2WinPage extends AbstractPage {

    private static final String HISTORY_LAST_WINNERS_MODAL = "(//div[@class='history-slide ng-scope'])[1]";
    private static final String LAST_WINNERS_RESULT = "//div[@class='main-body-item ng-scope']";
    private static final String PLACE_NUMBER_LOCATOR = ".//div[@class='main-body-place ng-binding']";
    private static final String COUNTRY_LOCATOR = ".//div[@class='main-body-account ng-binding']/div";
    private static final String PROFILE_ID_LOCATOR = ".//div[@class='main-body-account ng-binding']";
    private static final String PRIZE_LOCATOR = ".//div[@class='main-body-prize ng-binding']";

    public Trade2WinPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public void openModalLastWinners() {
        Actions builder = new Actions(getDriver());
        builder.moveToElement(findBy(HISTORY_LAST_WINNERS_MODAL)).build().perform();

        find(By.xpath(HISTORY_LAST_WINNERS_MODAL)).waitUntilClickable().click();
    }

    public List<WinnersDrawDTO> getCurrentWinnersUsingStreamApi() {
        return findAll(LAST_WINNERS_RESULT)
                .stream()
                .map(instruments -> {
                    String place = instruments.find(By.xpath(PLACE_NUMBER_LOCATOR)).getText();
                    String country = instruments.find(By.xpath(COUNTRY_LOCATOR)).getAttribute("property");
                    String userId = instruments.find(By.xpath(PROFILE_ID_LOCATOR)).getText().trim();
                    String amount = instruments.find(By.xpath(PRIZE_LOCATOR)).getText()
                            .replaceAll("[$, ]","");

                    return new WinnersDrawDTO(place, country, userId, amount);
                }).collect(Collectors.toList());
    }
}
