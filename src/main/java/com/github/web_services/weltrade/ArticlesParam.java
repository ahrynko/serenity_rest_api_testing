package com.github.web_services.weltrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
@JsonIgnoreProperties( ignoreUnknown = true ) // скипать все поля кроме (title/content)
public class ArticlesParam extends Document{

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    private String content;

         /*public String code;
         public String sort_order;
         public String section_id;*/

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}
