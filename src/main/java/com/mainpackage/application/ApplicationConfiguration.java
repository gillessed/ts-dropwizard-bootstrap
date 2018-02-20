package com.mainpackage.application;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class ApplicationConfiguration extends Configuration {
    @Valid
    @NotNull
    private String foo;

    @JsonProperty("foo")
    public String getFoo() {
        return foo;
    }

    @JsonProperty("foo")
    public void setFoo(String foo) {
        this.foo = foo;
    }
}
