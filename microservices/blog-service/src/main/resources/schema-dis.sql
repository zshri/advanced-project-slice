create table post
(
    id          bigserial
        primary key,
    author      varchar(255),
    content     varchar(255),
    create_at   timestamp,
    post_status integer,
    title       varchar(255),
    update_at   timestamp
);