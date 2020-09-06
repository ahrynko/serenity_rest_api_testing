package com.github.common.data;

public enum EnvironmentProperties {  //can store constructor

    LOCAL_API_URL("local.api.url"),
    WELTRADE_BASE_URL("weltrade.base.url");


    private String propertyKey;

    EnvironmentProperties(final String propertyKey) {
        this.propertyKey = propertyKey;
    }

    public String readProperty() {
        final PropertiesReader propertiesReader = new PropertiesReader();
        return propertiesReader.getProperty(propertyKey);
    }

}
