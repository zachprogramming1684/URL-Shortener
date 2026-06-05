package com.zachprogramming.urlshortener.Repository;

import com.zachprogramming.urlshortener.Model.URLRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface URLShortenerRepository extends JpaRepository<URLRequest, Long>
{
    boolean existsByShortCode(String shortCode);
    Optional<URLRequest> findByShortCode(String shortCode);
}
