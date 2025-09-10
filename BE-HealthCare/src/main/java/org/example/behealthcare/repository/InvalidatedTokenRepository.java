package org.example.behealthcare.repository;

import org.example.behealthcare.entity.InvalidatedToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvalidatedTokenRepository extends JpaRepository<InvalidatedToken, String> {
}
