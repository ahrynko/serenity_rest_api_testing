package com.github.web_services.weltrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.page_object.model.weltrade.ArticleDTO;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class WeltradeApiResults {

    public WeltradeApiResults(List<ArticleDTO> results) {
        this.results = results;
    }

    public WeltradeApiResults() {
    }

    @JsonProperty("section_articles_array")  // with JSON - REST
    private List<ArticleDTO> results;

    public List<ArticleDTO> getResults() {
        return results;
    }
}
