package com.github.serenity.steps.api.weltrade;

import com.github.common.data.EnvironmentProperties;
import com.github.web_services.weltrade.conditions.Instruments;
import com.github.web_services.weltrade.legal.Document;
import com.github.web_services.weltrade.seminars.Seminars;
import com.github.web_services.weltrade.trade2win.LastWinners;
import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;

import java.util.Arrays;
import java.util.List;

public class ApiFunctionaityWeltradeSteps {

    private static final String SEARCH_ENDPOINT = "/api/v1/";

    public ApiFunctionaityWeltradeSteps() {
        RestAssured.baseURI = EnvironmentProperties.WELTRADE_BASE_URL.readProperty();
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter()); //logging to concole
    }

    public String getCalcProfitInfoFromApi() {

        return RestAssured.given()
                .contentType(ContentType.JSON)      //work with json
                .body("[{\"action\":\"partner.getCalcProfitInfo\",\"data\":[]}]")
                .post(SEARCH_ENDPOINT).asString();
    }

    public List<Seminars> getMeetUpList() {
        return Arrays.asList (RestAssured.given()
                .contentType(ContentType.JSON)
                .body("[{\"action\":\"events.meetUpList\",\"data\":{\"region\":\"ru\"}}]")
                .post(SEARCH_ENDPOINT)
                .as(Seminars[].class));
    }

    public List<Document> retrieveArticlesFromApi() {
         return Arrays.asList (RestAssured.given()
                .contentType(ContentType.JSON)
                .body("[{\"action\":\"tools.getLegalInfo\",\"data\":{\"region\":\"ru\"}}]")
                .post(SEARCH_ENDPOINT)
                .as(Document[].class));
    }

    public List<Instruments> retrieveInstrumentsFromApi() {
        return Arrays.asList (RestAssured.given()
                .contentType(ContentType.JSON)
                .body("[{\"action\":\"partner.getCalcProfitInfo\",\"data\":[]}]")
                .post(SEARCH_ENDPOINT)
                .as(Instruments[].class));
    }

    public List<LastWinners> retrieveLastWinnersFromApi() {
        return Arrays.asList (RestAssured.given()
                .contentType(ContentType.JSON)
                .body("[{\"action\":\"events.currentTrade2Win\",\"data\":[]}]")
                .post(SEARCH_ENDPOINT)
                .as(LastWinners[].class));
    }

//    public List<String> retrieveQuotesFromApi() { //refactor
//        return Arrays.asList (RestAssured.given()
//                .relaxedHTTPSValidation()
//                .contentType(ContentType.JSON)
//                .get(SEARCH_ENDPOINT).asString());       //refactor
////                .as(Export[].class));
//    }
}

