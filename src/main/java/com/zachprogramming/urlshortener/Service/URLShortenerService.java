package com.zachprogramming.urlshortener.Service;

import com.zachprogramming.urlshortener.Model.URL;
import com.zachprogramming.urlshortener.Repository.URLShortenerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class URLShortenerService
{
    private URLShortenerRepository urlShortenerRepository;

    public URLShortenerService(URLShortenerRepository urlShortenerRepository)
    {
        this.urlShortenerRepository = urlShortenerRepository;
    }

    public URL generateURLCode(String url)
    {
        String code;

        do {
            UUID uuid = UUID.randomUUID();
            code = uuid.toString().substring(0, 8);
        }
        while(urlShortenerRepository.existsByShortCode(code));

        URL newURL = new URL(url, code, LocalDateTime.now());
        urlShortenerRepository.save(newURL);
        return newURL;
    }

    public String getURLByCode(String code)
    {
        Optional<URL> urlOptional = urlShortenerRepository.findByShortCode(code);

        if(urlOptional.isEmpty())
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Short link not found");

        return urlOptional.get().getUrlText();
    }
}
