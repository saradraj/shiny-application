package com.sarad.shinyapp.ad;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.NotNull;
import java.time.ZonedDateTime;

public class AdDTO {

    private Long id;

    @NotNull
    private Integer campaignDurationSeconds;

    @JsonIgnore
    private ZonedDateTime campaignExpirationTime;

    @NotNull
    private String content;

    @NotNull
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
