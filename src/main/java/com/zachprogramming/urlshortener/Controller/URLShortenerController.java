package com.zachprogramming.urlshortener.Controller;

import com.zachprogramming.urlshortener.Model.URL;
import com.zachprogramming.urlshortener.Service.URLShortenerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
public class URLShortenerController
{
    private URLShortenerService urlShortenerService;

    public URLShortenerController(URLShortenerService urlShortenerService)
    {
        this.urlShortenerService = urlShortenerService;
    }

    // this is for making the passed in url from the browser part of a json
    public record UrlRequest(String originalUrl) {}

    @PostMapping("/shorten")
    public ResponseEntity<URL> shortenURL(@RequestBody UrlRequest request)
    {
        URL newURL = urlShortenerService.generateURLCode(request.originalUrl);
        return new ResponseEntity<>(newURL, HttpStatus.CREATED);
    }

    @GetMapping("/{code}")
    public ResponseEntity<Void> getURLRedirect(@PathVariable String code)
    {
        String url = urlShortenerService.getURLByCode(code);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }
}
