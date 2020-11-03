package com.github.page_object.pages.weltrade;

import com.github.common.data.PartialUrl;
import com.github.page_object.model.weltrade.InstrumentsDTO;
import com.github.page_object.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "partners/conditions/")
public class PartnerRemunerationPage extends AbstractPage {

    private static final String LIST_SEARCH_INSTRUMENTS_RESULT = "(//tbody)[1]/tr[position() > 2]";
    private static final String INSTRUMENT_LOCATOR = ".//td[1]/div";
    private static final String SPREAD_LOCATOR = ".//td[2]/div[1]";
    private static final String POINTS_LOCATOR = ".//td[3]/div/div[1]";  //standard
    private static final String USD_LOCATOR = ".//td[4]/div/div[1]";  //standard
    private static final String MTP_LOCATOR = ".//td[5]/div";

    public PartnerRemunerationPage(final WebDriver webDriver) {
        super(webDriver);
    }


    public List<InstrumentsDTO> getInstrumentsUsingStreamApi() {
        return findAll(LIST_SEARCH_INSTRUMENTS_RESULT)
                .stream()
                .map(instruments -> {
                    String instrument = instruments.find(By.xpath(INSTRUMENT_LOCATOR)).getText();
                    String spread = instruments.find(By.xpath(SPREAD_LOCATOR)).getText();
                    String points = instruments.find(By.xpath(POINTS_LOCATOR)).getText();
                    String usd = instruments.find(By.xpath(USD_LOCATOR)).getText();
                    String mtp = instruments.find(By.xpath(MTP_LOCATOR)).getText();

                    return new InstrumentsDTO(instrument, spread, points, usd, mtp);
                }).collect(Collectors.toList());
    }
}
