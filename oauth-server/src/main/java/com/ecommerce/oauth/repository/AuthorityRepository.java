package com.ecommerce.oauth.repository;

import com.ecommerce.oauth.model.Authority;
import com.ecommerce.oauth.model.AuthorityName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorityRepository extends JpaRepository<Authority, Integer> {

    Authority getByName(AuthorityName name);
}
