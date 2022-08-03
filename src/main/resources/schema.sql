drop table if exists security_member;
drop table if exists logging_table;

create table if not exists security_member(
    memberIdx integer primary key auto_increment,
    username varchar(50) not null,
    password varchar(255) not null,
    realName varchar(50) not null,
    phoneNumber varchar(50) not null,
    email varchar(50) not null,
    age integer not null,
    userRole integer not null
);

create table if not exists logging_table(
    loggingIdx integer primary key auto_increment,
    loggingType varchar(255) not null,
    loggingText varchar(255)
);