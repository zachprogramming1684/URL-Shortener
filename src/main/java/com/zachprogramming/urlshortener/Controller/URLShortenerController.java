package com.zachprogramming.urlshortener.Controller;

import com.zachprogramming.urlshortener.Service.URLShortenerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class URLShortenerController
{
    private URLShortenerService urlShortenerService;

    public URLShortenerController(URLShortenerService urlShortenerService)
    {
        this.urlShortenerService = urlShortenerService;
    }
}
