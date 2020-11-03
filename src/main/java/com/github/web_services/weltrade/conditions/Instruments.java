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

        @JsonProperty("AUDCAD")  //AUDCAD
        private AudCad audcad;

        @JsonProperty("AUDCHF")  //AUDCHF
        private AudChf audchf;

        @JsonProperty("AUDJPY")  //AUDJPY
        private AudJpy audjpy;

        @JsonProperty("AUDNZD")  //AUDNZD
        private AudNzd audnzd;

        @JsonProperty("AUDUSD")  //AUDUSD
        private AudUsd audusd;

        @JsonProperty("CADCHF")  //CADCHF
        private CadChf cadchf;

        @JsonProperty("CADJPY")  //CADJPY
        private CadJpy cadjpy;

        @JsonProperty("CHFJPY")  //CHFJPY
        private ChfJpy chfjpy;

        @JsonProperty("EURAUD")  //EURAUD
        private EurAud euraud;

        @JsonProperty("EURCAD")  //EURCAD
        private EurCad eurcad;

        @JsonProperty("EURCHF")  //EURCHF
        private EurChf eurchf;

        /*@JsonProperty("EURDKK")  //EURDKK
        private EurDkk eurdkk;

        @JsonProperty("EURGBP")  //EURGBP
        private EurGbp eurgbp;

        @JsonProperty("EURHUF")  //EURHUF
        private EurHuf eurhuf;

        @JsonProperty("EURJPY")  //EURJPY
        private EurJpy eurjpy;

        @JsonProperty("EURMXN")  //EURMXN
        private EurMxn eurmxn;

        @JsonProperty("EURNOK")  //EURNOK
        private EurNok eurnok;

        @JsonProperty("EURNZD")  //EURNZD
        private EurNzd eurnzd;

        @JsonProperty("EURRUB")  //EURRUB
        private EurRub eurrub;

        @JsonProperty("EURSEK")  //EURSEK
        private EurSek eursek;

        @JsonProperty("EURUSD")  //EURUSD
        private EurUsd eurusd;

        @JsonProperty("GBPAUD")  //GBPAUD
        private GbpAud gbpaud;

        @JsonProperty("GBPCAD")  //GBPCAD
        private GbpCad gbpcad;

        @JsonProperty("GBPCHF")  //GBPCHF
        private GbpChf gbpchf;

        @JsonProperty("GBPJPY")  //GBPJPY
        private GbpJpy gbpjpy;*/

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
    public static class AudCad {

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
    public static class AudChf {

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
    public static class AudJpy {

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
    public static class AudNzd {

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
    public static class AudUsd {

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
    public static class CadChf {

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
    public static class CadJpy {

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
    public static class ChfJpy {

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
    public static class EurAud {

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
    public static class EurCad {

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
    public static class EurChf {

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
