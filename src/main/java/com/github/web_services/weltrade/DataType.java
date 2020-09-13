package com.github.web_services.weltrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties( ignoreUnknown = true )
public class DataType extends Document {

    /*public String section_title;
    public String section_code;*/
    private List<ArticlesParam> section_articles_array;

    public List<ArticlesParam> getSection_articles_array() {
        return section_articles_array;
    }
}
