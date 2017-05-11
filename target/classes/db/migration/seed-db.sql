insert into partner (id, name) values (1, 'kforce');
insert into partner (id, name) values (2, 'liberty');

insert into ad (id,campaign_duration_seconds,campaign_expiration_time,content,partner_id)
values (1, 86400, CURRENT_TIMESTAMP ,'kforce is numero uno', 1);
