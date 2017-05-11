package com.sarad.shinyapp.ad;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.ZonedDateTime;
import java.util.Optional;

@Repository
public interface AdRepository extends JpaRepository <Ad, Long>{

    Long countAdsByPartnerId(String partnerId);

    Optional<Ad> findOneByPartnerIdAndCampaignExpirationTimeAfter(String partnerId, ZonedDateTime now);

}
