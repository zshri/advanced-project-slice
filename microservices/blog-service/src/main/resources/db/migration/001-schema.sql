
create sequence my_sequence
    start with 1000
    increment by 10;

create table post
(
    id          bigserial
        primary key,
    author      varchar(255),
    content     varchar(15940),
    create_at   timestamp,
    post_status varchar,
    title       varchar(255),
    update_at   timestamp
);


INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (1, 'Principal', 'content', '2023-05-12 19:50:09.038517', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (3, 'Principal', 'content', '2023-05-12 19:50:10.868810', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (4, 'Principal', 'content', '2023-05-12 19:51:02.617594', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (2, 'Principal', 'upade', '2023-05-12 19:50:09.965042', 'PUBLISH', 'update', '2023-05-12 20:20:17.285308');
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (5, 'Principal', 'content', '2023-05-16 12:55:57.440681', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (7, 'Principal', 'content', '2023-05-16 12:56:35.519683', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (8, 'Principal', 'content', '2023-05-16 12:59:51.361013', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (9, 'Principal', 'content', '2023-05-16 12:59:52.913147', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (10, 'Principal', 'content', '2023-05-16 12:59:53.908221', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (11, 'Principal', 'content', '2023-05-16 13:04:34.934581', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (12, 'Principal', 'content', '2023-05-16 13:04:36.040124', 'PUBLISH', '1111', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (6, 'Principal', 'upade3', '2023-05-16 12:56:04.747676', 'PUBLISH', 'update3', '2023-05-16 13:20:05.588611');
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (13, 'Principal', 'content', '2023-05-16 13:48:51.309443', 'PUBLISH', 'NEW POST', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (15, 'Principal', 'content', '2023-05-16 13:56:48.021399', 'PUBLISH', '15', null);
INSERT INTO public.post (id, author, content, create_at, post_status, title, update_at) VALUES (14, 'new', 'cont', '2023-05-16 13:55:31.000000', 'PUBLISH', 'new user', null);
