package com.github.page_object.pages.weltrade;

import com.github.common.data.PartialUrl;
import com.github.page_object.model.weltrade.QuotesDTO;
import com.github.page_object.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

@PartialUrl(value = "tools/quotes/")
public class WeltradeCurrencyQuotesPage extends AbstractPage {

    private static final String LIST_CURRENCY_QUOTES_RESULT = "//div[@class='wt-white-block-bg quotes-block-wrap']/div [not(@class='wt_quotes_header')]";
    private static final String QUOTES_PAIR = ".//div[@class='wt_quotes_table__pair']";
    private static final String QUOTES_BUY = ".//div[@class='wt-quotes-merge wt-quotes-bid']";
    private static final String QUOTES_SELL= ".//div[@class='wt-quotes-merge wt-quotes-ask']";

    public WeltradeCurrencyQuotesPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public List<QuotesDTO> getArticleItemsUsingStreamApi() {
        return findAll(LIST_CURRENCY_QUOTES_RESULT)
                .stream()
                .map(quotes -> {
                    String currency_pair = quotes.find(By.xpath(QUOTES_PAIR)).getText();
                    Double quotes_buy = Double.parseDouble(quotes.find(By.xpath(QUOTES_BUY)).getText());
                    Double quotes_sell = Double.parseDouble(quotes.find(By.xpath(QUOTES_SELL)).getText());

                    return new QuotesDTO(currency_pair, quotes_buy, quotes_sell);
                }).collect(Collectors.toList());
    }
}
