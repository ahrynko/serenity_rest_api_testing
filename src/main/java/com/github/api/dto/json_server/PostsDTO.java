package com.github.api.dto.json_server;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostsDTO {

    @JsonProperty("id")
    @JsonInclude(JsonInclude.Include.NON_NULL)  //NON_EMPTY
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("author")
    private String author;

    @JsonIgnore()
    @JsonProperty("age")  // @JsonIgnore - только в GET
    private String age;

}
