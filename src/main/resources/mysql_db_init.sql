DROP TABLE IF EXISTS `t_msg_kefu`;
create table `t_msg_kefu`
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    msg_type      int(11),
    msg_name      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    kefu_msg_type varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    content       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    title         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    img_url       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    describe      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    url           varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key (`id`), unique key `t_msg_kefu_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

------
DROP TABLE IF EXISTS `t_msg_kefu_priority`;
create table `t_msg_kefu_priority`
(
    id            int(11),
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    template_id   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    url           varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ma_appid      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ma_page_path  varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    kefu_msg_type varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    content       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    title         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    img_url       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    describe      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    kefu_url      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key (`id`), unique key `t_msg_kefu_priority_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);
----------
DROP TABLE IF EXISTS `t_msg_ma_template`;
create table t_msg_ma_template
(
    id               int(11),
    msg_type         int(11),
    msg_name         varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    template_id      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    page             varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    emphasis_keyword varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time      datetime DEFAULT NULL,
    modified_time    datetime DEFAULT NULL,
    primary key (`id`), unique key `t_msg_ma_template_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

create unique index if not exists t_msg_ma_template_msg_type_msg_name_uindex
    on t_msg_ma_template (msg_type, msg_name);

---
DROP TABLE IF EXISTS `t_msg_mp_template`;
create table t_msg_mp_template
(
    id            int(11),
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    template_id   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    url           varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ma_appid      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ma_page_path  varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key (`id`), unique key `t_msg_mp_template_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

 ----
DROP TABLE IF EXISTS `t_msg_sms`;
create table t_msg_sms
(
    id            int(11),
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    template_id   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    content       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key (`id`), unique key `t_msg_sms_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

----
DROP TABLE IF EXISTS `t_push_history`;
create table t_push_history
(
    id            int(11),
    msg_id        int(11),
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    result        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    csv_file      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key (`id`)
);

----
DROP TABLE IF EXISTS `t_template_data`;
create table t_template_data
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    msg_type      int(11),
    msg_id        int(11),
    name          varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    value         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    color         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key (`id`)
);


----
DROP TABLE IF EXISTS `t_wx_mp_user`;
create table t_wx_mp_user
(
    open_id         varchar (255),
    nickname        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    sex_desc        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    sex             int(11),
    language        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    city            varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    province        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    country         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    head_img_url    varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    subscribe_time  varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    union_id        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    remark          varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    group_id        int(11),
    subscribe_scene varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    qr_scene        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    qr_scene_str    varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time     varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    modified_time   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    primary key(`open_id`)
);

---------

create table t_wx_account
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    account_type  varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    account_name  varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    app_id        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    app_secret    varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    token         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    aes_key       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`)
);

---------------
DROP TABLE IF EXISTS `t_msg_mail`;
create table t_msg_mail
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    title         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    Cc            varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    files         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    content       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`), unique key `t_msg_mail_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);


create unique index if not exists t_msg_mail_msg_type_msg_name_uindex
    on t_msg_mail (msg_type, msg_name);
-----
create table t_wx_cp_app
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    corpId        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    app_name      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    agent_id      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    secret        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    token         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    aes_key       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`)
);


----
DROP TABLE IF EXISTS `t_msg_wx_cp`;
create table t_msg_wx_cp
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    cp_msg_type   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    agent_id      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    content       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    title         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    img_url       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    describe      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    url           varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    btn_txt       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`), unique key `t_msg_wx_cp_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

create unique index if not exists t_msg_wx_cp_msg_type_msg_name_uindex
    on t_msg_wx_cp (msg_type, msg_name);

----
DROP TABLE IF EXISTS `t_msg_http`;
create table if not exists t_msg_http
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    method        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    url           varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    params        varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    headers       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    cookies       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    body          varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    body_type     varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`), unique key `t_msg_http_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

create unique index if not exists t_msg_http_msg_type_msg_name_uindex
    on t_msg_http (msg_type, msg_name);
-----
DROP TABLE IF EXISTS `t_msg_ding`;
create table if not exists t_msg_ding
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    radio_type    varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ding_msg_type varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    agent_id      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    web_hook      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    content       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`), unique key `t_msg_ding_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

create unique index if not exists t_msg_ding_msg_type_msg_name_uindex
    on t_msg_ding (msg_type, msg_name);

----
DROP TABLE IF EXISTS `t_ding_app`;
create table if not exists t_ding_app
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    app_name      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    agent_id      varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    app_key       varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    app_secret    varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`)
);

---
DROP TABLE IF EXISTS `t_msg_wx_uniform`;
create table t_msg_wx_uniform
(
    id               int(11) NOT NULL AUTO_INCREMENT,
    msg_type         int(11),
    msg_name         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    mp_template_id   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ma_template_id   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    mp_url           varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ma_appid         varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    ma_page_path     varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    page             varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    emphasis_keyword varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time      datetime DEFAULT NULL,
    modified_time    datetime DEFAULT NULL,
    primary key(`id`), unique key `t_msg_wx_uniform_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

create unique index if not exists t_msg_wx_uniform_msg_type_msg_name_uindex
    on t_msg_wx_uniform (msg_type, msg_name);


-----

DROP TABLE IF EXISTS `t_msg_ma_subscribe`;
create table t_msg_ma_subscribe
(
    id            int(11) NOT NULL AUTO_INCREMENT,
    msg_type      int(11),
    msg_name      varchar (64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    template_id   varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    page          varchar (255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    create_time   datetime DEFAULT NULL,
    modified_time datetime DEFAULT NULL,
    primary key(`id`), unique key `t_msg_ma_subscribe_msg_type_msg_name_uindex` (`msg_type`,`msg_name`)
);

create unique index if not exists t_msg_ma_subscribe_msg_type_msg_name_uindex
    on t_msg_ma_subscribe (msg_type, msg_name);

