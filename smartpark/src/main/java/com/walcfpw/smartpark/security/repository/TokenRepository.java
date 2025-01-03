package com.walcfpw.smartpark.security.repository;

import com.walcfpw.smartpark.security.data.entity.TokenEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TokenRepository extends JpaRepository<TokenEntity, Integer> {

    @Query(value = """
      select t.* from token_entity t inner join user_entity u\s
      on t.user_entity_id = u.id\s
      where u.id = :id and (t.expired = false or t.revoked = false)\s
      """, nativeQuery = true)
    List<TokenEntity> findAllValidTokenByUser(Integer id);

    Optional<TokenEntity> findByToken(String token);
}
