CREATE TABLE ad (
  id INTEGER PRIMARY KEY,
  campaign_duration_seconds INTEGER,
  campaign_expiration_time TIMESTAMP,
  content VARCHAR(200),
  partner_id VARCHAR(200) NOT NULL UNIQUE
);