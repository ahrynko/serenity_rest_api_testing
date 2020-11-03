package com.github.web_services.weltrade.conditions;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

import java.util.List;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Instruments {

    public Instruments() { }

    private Data data;

    public Data getData() {
        return data;
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class Data {

        private levelOne levelOne;

        public levelOne getLevelOne() {
            return levelOne;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class levelOne {

        private Standard standard ;

        public Standard getStandard() {
            return standard;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class Standard {

        private List<Micro> micro;

        public List<Micro> getMicro() {
            return micro;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class Micro {  //ref

        @JsonProperty("EURUSD")
        private EurUsd eurUsd;

        public EurUsd getEurUsd() {
            return eurUsd;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class EurUsd {

        @JsonProperty("mtp")
        private String mtp;

        @JsonProperty("spread")
        private String spread;

        public String getMtp() {
            return mtp;
        }

        public String getSpread() {
            return spread;
        }
    }

}
