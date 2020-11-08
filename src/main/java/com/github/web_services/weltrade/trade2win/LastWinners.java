package com.github.web_services.weltrade.trade2win;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LastWinners {
    public LastWinners() { }

    private Data data;

    public Data getData() {
        return data;
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class Data {

        private List<History> history;

        public List<History> getHistory() {
            return history;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class History {

        private List<Winners> winners;

        public List<Winners> getWinners() {
            return winners;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class Winners {

        @JsonProperty("place")
        private String place;

        @JsonProperty("country")
        private String country;

        @JsonProperty("userId")
        private String profileID;

        @JsonProperty("amount")
        private String sumPrize;

    }
}
