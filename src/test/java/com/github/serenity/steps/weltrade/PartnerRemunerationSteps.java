package com.github.serenity.steps.weltrade;

import com.github.common.data.UrlBuilder;
import com.github.page_object.model.weltrade.InstrumentsDTO;
import com.github.page_object.pages.weltrade.PartnerRemunerationPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.Pages;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.List;

public class PartnerRemunerationSteps extends ScenarioSteps {

    private PartnerRemunerationPage partnerRemunerationPage;

    public PartnerRemunerationSteps(final Pages pages) { //create page object
        this.partnerRemunerationPage = pages.getPage(PartnerRemunerationPage.class); //pages - initialized page object
    }

    @Step
    public void openPageByPartialUrl(final String commonUrl) {
        final String fullNavUrl = UrlBuilder.buildFullUrl(commonUrl, PartnerRemunerationPage.class);
        partnerRemunerationPage.openUrl(fullNavUrl);
    }

    @Step
    public List<InstrumentsDTO> getInstruments() {
        return partnerRemunerationPage.getInstrumentsUsingStreamApi();
    }
}
