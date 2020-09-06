package com.github.page_object.model.weltrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)  // скипать все поля кроме (title/content)
public class ArticleDTO {

    public ArticleDTO() {
    }

    @JsonProperty("title")  // with JSON - REST
    private String title;

    @JsonProperty("content")
    private String body;

}
