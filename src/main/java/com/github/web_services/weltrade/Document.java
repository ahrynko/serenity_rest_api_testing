package com.github.web_services.weltrade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {

    public Document() {
    }

    /*public String action;
    public Integer code;*/
    private List<DataType> data;

    public List<DataType> getData() {
        return data;
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class DataType {

        /*public String section_title;
        public String section_code;*/
        private List<ArticlesParam> section_articles_array;

        public List<ArticlesParam> getSection_articles_array() {
            return section_articles_array;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true ) // скипать все поля кроме (title/content)
    public static class ArticlesParam {

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

}
