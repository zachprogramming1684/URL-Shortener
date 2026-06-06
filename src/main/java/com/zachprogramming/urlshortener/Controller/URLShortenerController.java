package com.zachprogramming.urlshortener.Controller;

import com.zachprogramming.urlshortener.Model.URLRequest;
import com.zachprogramming.urlshortener.Service.URLShortenerService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.URL;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
public class URLShortenerController
{
    private URLShortenerService urlShortenerService;

    public URLShortenerController(URLShortenerService urlShortenerService)
    {
        this.urlShortenerService = urlShortenerService;
    }

    // this is for making the passed in url from the browser part of a json
    public record UrlRequest(
            @NotBlank(message = "URL cannot be empty")
            @URL(message = "Must be a valid web address (eg. https://www.google.com)")
            String originalUrl
    ) {}

    @PostMapping("/shorten")
    public ResponseEntity<URLRequest> shortenURL(@Valid @RequestBody UrlRequest request)
    {
        URLRequest newURLRequest = urlShortenerService.generateURLCode(request.originalUrl);
        return new ResponseEntity<>(newURLRequest, HttpStatus.CREATED);
    }

    @GetMapping("/{code:[a-zA-Z0-9]+}")
    public ResponseEntity<Void> getURLRedirect(@PathVariable String code)
    {
        String url = urlShortenerService.getURLByCode(code);
        return ResponseEntity.status(HttpStatus.FOUND)
                .location(URI.create(url))
                .build();
    }

    @GetMapping("/all")
    public ResponseEntity<List<URLRequest>> getAllURLs()
    {
        return ResponseEntity.ok(urlShortenerService.getAllURLs());
    }
}
