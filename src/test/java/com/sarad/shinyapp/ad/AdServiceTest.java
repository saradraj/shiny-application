package com.sarad.shinyapp.ad;

import com.sarad.shinyapp.ShinyApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ShinyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class AdServiceTest {

    @Autowired
    private AdService adService;

    @Test
    @Transactional
    @Rollback
    public void create() {
        AdDTO adDTO = new AdDTO();
        adDTO.setPartnerId("test-partner");
        adDTO.setCampaignDurationSeconds(120);
        adDTO.setContent("buy me");
        adDTO = adService.create(adDTO);
        Assert.assertTrue(1L == adService.count());
    }

    @Test
    @Rollback
    @Transactional
    public void findActiveByPartnerId() throws InterruptedException {
        AdDTO adDTO = new AdDTO();
        adDTO.setPartnerId("test-partner");
        adDTO.setCampaignDurationSeconds(5);
        adDTO.setContent("buy me");
        adDTO = adService.create(adDTO);
        Assert.assertNotNull(adService.findActiveByPartnerId("test-partner"));
        Thread.sleep(5000);
        Assert.assertNull(adService.findActiveByPartnerId("test-partner"));
    }

    @Test
    @Rollback
    @Transactional
    public void findAll() {
        AdDTO adDTO = new AdDTO();
        adDTO.setPartnerId("test-partner");
        adDTO.setCampaignDurationSeconds(120);
        adDTO.setContent("buy me");
        adDTO = adService.create(adDTO);
        List<AdDTO> allAds = adService.findAll();
        Assert.assertTrue(1 == allAds.size());
    }

}
