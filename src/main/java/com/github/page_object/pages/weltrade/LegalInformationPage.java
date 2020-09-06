package com.github.page_object.pages.weltrade;

import com.github.page_object.model.weltrade.ArticleDTO;
import com.github.page_object.pages.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.stream.Collectors;

public class LegalInformationPage extends AbstractPage {

    private static final String LIST_SEARCH_RESULT = "//div[@class='wt-legal-middle-content-bl']//div//div[@ng-if='section.content.length > 1']";
    private static final String TITLE_ARTICLE = ".//h3[@class='ng-binding ng-scope']";
    private static final String BODY_ARTICLE = ".//div[@class='ng-binding']";

    public LegalInformationPage(final WebDriver webDriver) {
        super(webDriver);
    }

    public List<ArticleDTO> getArticleItemsUsingStreamApi(){
        return findAll(LIST_SEARCH_RESULT)
                .stream()
                .map(article -> {  // преобраз. одного сосотояния в другое
                    String title = article.find(By.xpath(TITLE_ARTICLE)).getText();
                    String body = article.find(By.xpath(BODY_ARTICLE)).getText();

                    return new ArticleDTO(title, body);
                }).collect(Collectors.toList());
    }
}
