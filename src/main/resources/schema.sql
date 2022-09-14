drop table if exists security_member;
drop table if exists logging_table;

create table if not exists security_member(
    memberIdx integer primary key auto_increment,
    username varchar(50) not null unique,
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

create table if not exists board_table(
    boardIdx integer primary key auto_increment,
    title varchar(255) not null,
    content varchar(500) not null,
    regDate date default current_timestamp
);

create table if not exists chat_room(
    chatIndex integer primary key auto_increment,
    title varchar(255) not null,
    description varchar(500),
    owner integer not null,
    regDate date default current_timestamp
);

create table if not exists chat_room_member(
    chatIndex integer not null,
    memberIdx integer not null
);

create table if not exists chat_room_message(
    chatIndex integer not null,
    memberIdx integer not null,
    message varchar(500) not null,
    regDate date default current_timestamp
);