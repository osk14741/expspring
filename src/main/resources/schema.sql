drop table if exists security_member;

create table security_member(
    memberIdx integer primary key auto_increment,
    username varchar(50) not null,
    password varchar(50) not null,
    realName varchar(50) not null,
    phoneNumber varchar(50) not null,
    email varchar(50) not null,
    age integer not null
);