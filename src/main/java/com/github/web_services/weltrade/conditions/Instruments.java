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

        private LevelOne levelOne;

        public LevelOne getLevelOne() {
            return levelOne;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class LevelOne {

        private Standard standard;

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
    public static class Micro {

        @JsonProperty("EURUSD")  //EURUSD object
        private EurUsd eurusd;

        @JsonProperty("GBPUSD")  //GBPUSD object
        private GbpUsd gbpusd;

    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class EurUsd {

        @JsonProperty("mtp")
        private String mtp;

        @JsonProperty("spread")
        private String spread;

        private Level1 level1;

        public String getMtp() {
            return mtp;
        }

        public String getSpread() {
            return spread;
        }

        public Level1 getLevel1() {
            return level1;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class GbpUsd {

        @JsonProperty("mtp")
        private String mtp;

        @JsonProperty("spread")
        private String spread;

        private Level1 level1;

        public String getMtp() {
            return mtp;
        }

        public String getSpread() {
            return spread;
        }

        public Level1 getLevel1() {
            return level1;
        }
    }

    @Getter
    @JsonIgnoreProperties( ignoreUnknown = true )
    public static class Level1 {

        @JsonProperty("usd")
        private String usd;

        @JsonProperty("volume")
        private String volume;

        public String getUsd() {
            return usd;
        }

        public String getVolume() {
            return volume;
        }
    }

}
