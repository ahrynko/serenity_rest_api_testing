package com.github.page_object.model.weltrade;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class InstrumentsDTO {

    public InstrumentsDTO() { }

    private String instrument;
    private String spread;
    private String points;
    private String usd;
    private String mtp;

}
