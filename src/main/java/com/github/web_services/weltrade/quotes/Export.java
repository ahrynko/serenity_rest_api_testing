package com.github.web_services.weltrade.quotes;

public class Export {

    public Export() {
    }

    public Export(String symbol) {
    }

    private String symbol;
    private String currency_pair;
    private String quotes_buy;
    private String quotes_sell;

    public String getSymbol() {
        return symbol;
    }

    public String getCurrency_pair() {
        return currency_pair;
    }

    public String getQuotes_buy() {
        return quotes_buy;
    }

    public String getQuotes_sell() {
        return quotes_sell;
    }

}
