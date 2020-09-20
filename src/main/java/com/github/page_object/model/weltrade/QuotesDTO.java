package com.github.page_object.model.weltrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true) // скипать все поля кроме
public class QuotesDTO {

    public QuotesDTO() {
    }

    //    @JsonIgnore()               // @JsonIgnore - только в GET
    private String currency_pair;
    private Double quotes_buy;
    private Double quotes_sell;

 /*   public String getCurrencyPair() {
        return currency_pair;
    }

    public Double getQuotesBuy() {
        return quotes_buy;
    }

    public Double getQuotesSell() {
        return quotes_sell;
    }*/
}
