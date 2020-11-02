package com.github.web_services.weltrade.seminars;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Seminars {

    public Seminars() { }

    private Data data;  //without List

    public Data getData() {
        return data;
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class Data {

        private List<MeetUps> meetUps;

        public List<MeetUps> getMeetUps() {
            return meetUps;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class MeetUps {

        @JsonProperty("title")
        private String title;

        public String getTitle() {
            return title;
        }
    }

}
