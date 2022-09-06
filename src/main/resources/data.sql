delete from security_member;

INSERT INTO security_member
(
    username, password, realName, phoneNumber, email, age, userRole
) values (
             'admin', '$2a$12$swxyGPzwcKCZryurW9gI3.hOYyZscJOpvrZ452aFroYMNUecB.wNi', '어드민', '010-0000-0000', 'example@dot.com', 20, 0
         );

INSERT INTO security_member
(
    username, password, realName, phoneNumber, email, age, userRole
) values(
         'member', '$2a$12$swxyGPzwcKCZryurW9gI3.hOYyZscJOpvrZ452aFroYMNUecB.wNi', '멤버', '010-0000-0000', 'example@dot.com', 20, 1
        );

delete from board_table;

INSERT INTO board_table
(
    title, content
) values (
    '안녕0', '본문'
    );

INSERT INTO board_table
(
    title, content, regDate
) values (
    '안녕1', '본문', CURRENT_DATE()
    );

INSERT INTO board_table
(
    title, content, regDate
) values (
    '안녕2', '본문', CURRENT_DATE()
    );

INSERT INTO board_table
(
    title, content, regDate
) values (
    '안녕3', '본문', CURRENT_DATE()
    );

INSERT INTO board_table
(
    title, content, regDate
) values (
    '안녕4', '본문', CURRENT_DATE()
    );
