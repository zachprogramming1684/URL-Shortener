package com.zachprogramming.urlshortener.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class URL
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String urlText;
    private String shortCode;

    public URL()
    {
    }
    public URL(String urlText, String shortCode)
    {
        this.urlText = urlText;
        this.shortCode = shortCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUrlText() {
        return urlText;
    }

    public void setUrlText(String urlText) {
        this.urlText = urlText;
    }

    public String getShortCode() {
        return shortCode;
    }

    public void setShortCode(String shortCode) {
        this.shortCode = shortCode;
    }
}
