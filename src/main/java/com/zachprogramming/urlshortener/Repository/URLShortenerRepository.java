package com.zachprogramming.urlshortener.Repository;

import com.zachprogramming.urlshortener.Model.URL;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface URLShortenerRepository extends JpaRepository<URL, Long>
{
    boolean existsByShortCode(String shortCode);
}
