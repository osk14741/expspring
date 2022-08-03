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
        )