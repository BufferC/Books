create table `book` (
    `bid`    int(11) primary key auto_increment comment '图书id',
    `bname`  varchar(255) comment '图书名',
    `bprice` decimal(10, 2) comment '图书价格',
    `bimg`   varchar(255) comment '图书封面',
    `btext`  text comment '图书描述',
    `bstock` int(11) comment '图书库存'
);

create table `bookorder` (
    `oid`   int(11) primary key auto_increment comment '订单编号',
    `bid`   int(11) comment '图书编号',
    `onum`  int(11) comment '订单数量',
    `uid`   int(11) comment '用户编号',
    `otime` datetime default current_timestamp on update current_timestamp comment '下单时间'
);

create table `cart` (
    `cid`  int(11) primary key auto_increment comment '购物车编号',
    `bid`  int(11) comment '图书编号',
    `uid`  int(11) comment '用户编号',
    `cnum` int(11) comment '图书数量'
);

create table `user` (
    `uid`   int(11) primary key auto_increment comment '用户id',
    `uname` varchar(20) unique comment '用户名',
    `upwd`  varchar(20) comment '用户密码'
);