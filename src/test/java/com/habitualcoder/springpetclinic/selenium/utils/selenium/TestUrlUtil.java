package com.habitualcoder.springpetclinic.selenium.utils.selenium;

import java.net.MalformedURLException;
import java.net.URL;

import static java.lang.String.format;

public class TestUrlUtil {
    private String port;
    private String context;

    public TestUrlUtil(String port, String context) {
        this.port = port;
        this.context = context;
    }

    public URL toUrl(String path) {
        try {
            return new URL(format("%s%s", baseUrl(), path));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public String baseUrl() {
        return format("http://localhost:%s/%s", port, context);
    }
}
