-- 使用本系统前，先运行此文件
-- 运行此文件前，先创建好并使用(use)用于本系统的数据库
-- 删除视图
drop view if exists v_order;
drop view if exists v_arrange;
-- 删除表
drop table if exists t_order;
drop table if exists t_pay;
drop table if exists t_arrange;
drop table if exists t_movie;
drop table if exists t_cinema_hall;
drop table if exists t_cinema;
drop table if exists t_user;
drop table if exists t_admin;
-- 平台
create table t_admin
(
    admin_id         int primary key auto_increment,
    admin_name       varchar(30) unique not null,
    admin_password   varchar(30) not null
);
-- 用户（观众）
create table t_user
(
    user_id         int primary key auto_increment,
    user_name       varchar(30) unique not null,
    user_password   varchar(30) not null,
    user_state      bit not null default 1 comment '0：封禁，1：正常'
);
-- 影院
create table t_cinema
(
    cinema_id       int primary key auto_increment,
    cinema_name     varchar(30) unique not null,
    cinema_password varchar(30) not null,
    cinema_address  varchar(50),
    cinema_state    bit not null default 1 comment '0：停用，1：正常'
);
-- 影厅
create table t_cinema_hall
(
    cinema_hall_id         int primary key auto_increment,
    cinema_hall_name       varchar(30) not null,
    cinema_hall_seat       text not null,
    cinema_hall_cinema_id  int not null,
    cinema_hall_state      bit not null default 1 comment '0：停用，1：正常',
    foreign key(cinema_hall_cinema_id) references t_cinema(cinema_id)
);
-- 电影
create table t_movie
(
    movie_id        int primary key auto_increment,
    movie_name      varchar(30) not null,
    movie_duration  int not null,
    movie_state     bit not null default 1 comment '0：停用，1：正常',
    movie_img_url   varchar(200)
);
-- 排片
create table t_arrange
(
    arrange_id                  int primary key auto_increment,
    arrange_cinema_hall_id      int not null,
    arrange_movie_id            int not null,
    arrange_movie_start_time    datetime not null,
    arrange_price               decimal(16, 2) not null,
    arrange_state               bit not null default 1 comment '0：取消，1：正常',
    foreign key(arrange_cinema_hall_id) references t_cinema_hall(cinema_hall_id),
    foreign key(arrange_movie_id) references t_movie(movie_id)
);
-- 支付
create table t_pay
(
    pay_id          int primary key auto_increment,
    pay_num         varchar(32),
    pay_time        datetime not null default current_timestamp,
    pay_refund_info text,
    pay_notify_info text
);
-- 订单
create table t_order
(
    order_id            int primary key auto_increment,
    order_num           varchar(32),
    order_user_id       int not null,
    order_arrange_id    int not null,
    order_seat_row      tinyint not null,
    order_seat_col      tinyint not null,
    order_time          datetime not null default current_timestamp,
    order_amount        decimal(16, 2) not null,
    order_state         int not null default 0 comment '0：未支付，1：已支付，2：已退款',
    order_pay_id        int,
    foreign key(order_user_id) references t_user(user_id),
    foreign key(order_arrange_id) references t_arrange(arrange_id),
    foreign key(order_pay_id) references t_pay(pay_id)
);
-- 排片视图
create view v_arrange as
select
    a.arrange_id as arrange_id,
    c.cinema_id as cinema_id,
    h.cinema_hall_id as cinema_hall_id,
    m.movie_id as movie_id,
    c.cinema_name as cinema_name,
    h.cinema_hall_name as cinema_hall_name,
    m.movie_name as movie_name,
    a.arrange_movie_start_time as movie_start_time,
    a.arrange_movie_start_time + interval m.movie_duration minute as movie_end_time,
    m.movie_duration as movie_duration,
    h.cinema_hall_seat as cinema_hall_seat,
    a.arrange_price as arrange_price,
    a.arrange_state as arrange_state
from
    t_arrange a
    join t_cinema_hall h on a.arrange_cinema_hall_id = h.cinema_hall_id
    join t_cinema c on h.cinema_hall_cinema_id = c.cinema_id
    join t_movie m on a.arrange_movie_id = m.movie_id;
-- 订单视图
create view v_order as
select
    o.order_id as order_id,
    u.user_id as user_id,
    a.arrange_id as arrange_id,
    c.cinema_id as cinema_id,
    h.cinema_hall_id as cinema_hall_id,
    m.movie_id as movie_id,
    p.pay_id as pay_id,
    o.order_num as order_num,
    c.cinema_name as cinema_name,
    h.cinema_hall_name as cinema_hall_name,
    m.movie_name as movie_name,
    a.arrange_movie_start_time as movie_start_time,
    a.arrange_movie_start_time + interval m.movie_duration minute as movie_end_time,
    m.movie_duration as movie_duration,
    m.movie_img_url as movie_img_url,
    o.order_seat_row as order_seat_row,
    o.order_seat_col as order_seat_col,
    o.order_time as order_time,
    o.order_amount as order_amount,
    o.order_state as order_state
from
    t_order o
    join t_user u on o.order_user_id = u.user_id
    join t_arrange a on o.order_arrange_id = a.arrange_id
    join t_cinema_hall h on a.arrange_cinema_hall_id = h.cinema_hall_id
    join t_cinema c on h.cinema_hall_cinema_id = c.cinema_id
    join t_movie m on a.arrange_movie_id = m.movie_id
    left join t_pay p on o.order_pay_id = p.pay_id;
