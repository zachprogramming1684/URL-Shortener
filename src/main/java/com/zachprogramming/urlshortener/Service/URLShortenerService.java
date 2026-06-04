package com.zachprogramming.urlshortener.Service;

import com.zachprogramming.urlshortener.Repository.URLShortenerRepository;
import org.springframework.stereotype.Service;

@Service
public class URLShortenerService
{
    private URLShortenerRepository urlShortenerRepository;

    public URLShortenerService(URLShortenerRepository urlShortenerRepository)
    {
        this.urlShortenerRepository = urlShortenerRepository;
    }

}
