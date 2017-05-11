package com.sarad.shinyapp.ad;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AdService {

    @Autowired
    private AdRepository adRepository;

    public AdDTO create(AdDTO adDTO) {

        if(null != validate(adDTO)) {
            throw new RuntimeException("validation error occured");
        }
        Ad ad = toModel(adDTO);
        ad = adRepository.save(ad);
        return toDTO(ad);
    }

    public AdDTO findActiveByPartnerId(String partnerId) {
        AdDTO adDto = null;
        Optional<Ad> adOptional = adRepository.findOneByPartnerIdAndCampaignExpirationTimeAfter(partnerId, ZonedDateTime.now());
        if(adOptional.isPresent()) {
            adDto = toDTO(adOptional.get());
        }
        return adDto;

    }

    public List<AdDTO> findAll() {
        List<Ad> ads = adRepository.findAll();
        List<AdDTO> adDTOs = new ArrayList<>();
        if(!CollectionUtils.isEmpty(ads)) {
           adDTOs = ads.stream().map(ad -> toDTO(ad)).collect(Collectors.toList());
        }
        return adDTOs;
    }

    public Object validate(AdDTO adDTO) {
        Object error = null;
        Long adCountByPartnerId = adRepository.countAdsByPartnerId(adDTO.getPartnerId());
        if(adCountByPartnerId >= 1) {
            error = "Ad already exists for partner " + adDTO.getPartnerId();
        }
        return error;
    }

    public Long count() {
        return adRepository.count();
    }

    private Ad toModel(AdDTO adDTO) {
        Ad ad = new Ad();
        ZonedDateTime expiration = ZonedDateTime.now().plusSeconds(adDTO.getCampaignDurationSeconds());
        ad.setId(adRepository.count()+1);
        ad.setCampaignDurationSeconds(adDTO.getCampaignDurationSeconds());
        ad.setCampaignExpirationTime(expiration);
        ad.setContent(adDTO.getContent());
        ad.setPartnerId(adDTO.getPartnerId());
        return ad;
    }

    private AdDTO toDTO(Ad ad) {
        AdDTO adDTO = new AdDTO();
        adDTO.setId(ad.getId());
        adDTO.setCampaignDurationSeconds(ad.getCampaignDurationSeconds());
        adDTO.setCampaignExpirationTime(ad.getCampaignExpirationTime());
        adDTO.setContent(ad.getContent());
        adDTO.setPartnerId(ad.getPartnerId());
        return adDTO;
    }

}
