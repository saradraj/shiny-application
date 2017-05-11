package com.sarad.shinyapp.ad;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;
import java.time.ZonedDateTime;

@Entity
@Table(indexes = {@Index(name="ad_partner_id", columnList = "partnerId", unique = true)})
public class Ad {

    @Id
    private Long id;

    private Integer campaignDurationSeconds;

    private ZonedDateTime campaignExpirationTime;

    private String content;

    private String partnerId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCampaignDurationSeconds() {
        return campaignDurationSeconds;
    }

    public void setCampaignDurationSeconds(Integer campaignDurationSeconds) {
        this.campaignDurationSeconds = campaignDurationSeconds;
    }

    public ZonedDateTime getCampaignExpirationTime() {
        return campaignExpirationTime;
    }

    public void setCampaignExpirationTime(ZonedDateTime campaignExpirationTime) {
        this.campaignExpirationTime = campaignExpirationTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }
}
