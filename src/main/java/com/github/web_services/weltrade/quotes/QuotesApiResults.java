package com.github.web_services.weltrade.quotes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class QuotesApiResults {

    public QuotesApiResults() {
    }

    private ArrayList<ArrayList<String>> results;

    public ArrayList<ArrayList<String>> getResults() {
        return results;
    }
//    private List<Export> results;

    /*public List<Export> getResults() {
        return results;
    }*/

   /* @Getter
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Export {

        private String symbol;
        private String currency_pair;
        private String quotes_buy;
        private String quotes_sell;

    }*/

}
