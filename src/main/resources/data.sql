INSERT INTO users (username, password, enabled)
VALUES ('developer', 'dev', true);

INSERT INTO users (username, password, enabled)
VALUES ('admin', 'admin', true);

INSERT INTO authorities (username, authority)
VALUES ('developer', 'ROLE_DEVELOPER');

INSERT INTO authorities (username, authority)
VALUES ('admin ', 'ROLE_ADMIN');
