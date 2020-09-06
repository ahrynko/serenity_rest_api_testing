package com.github.serenity.steps.weltrade;

import com.github.page_object.model.weltrade.ArticleDTO;
import com.github.page_object.pages.weltrade.LegalInformationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class LegalInformationSteps extends ScenarioSteps {

    private LegalInformationPage legalInformationPage;

    public LegalInformationSteps(final Pages pages) { //create page object
        this.legalInformationPage = pages.getPage(LegalInformationPage.class); //pages - initialized page object
    }

    @Step
    public void openPageByUrl(final String commonUrl) {
        legalInformationPage.openUrl(commonUrl);
    }

    @Step
    public List<ArticleDTO> getAllArticles() {
        return legalInformationPage.getArticleItemsUsingStreamApi();
    }

}
