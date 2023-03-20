INSERT INTO STATUS (TYPE) VALUES
    ('AWAITING_ASSIGNMENT'),
    ('ASSIGNED'),
    ('BLOCKED'),
    ('INCOMPLETE'),
    ('COMPLETED');

INSERT INTO PRIORITY (TYPE) VALUES
    ('MINOR_LOW'),
    ('MEDIUM'),
    ('MAJOR_HIGH'),
    ('CRITICAL_SEVERE');

INSERT INTO ROLE (NAME) VALUES
    ('ROLE_MODERATE'),
    ('ROLE_ADMIN'),
    ('ROLE_USER');

--test emails
INSERT INTO EMAIL_ADDRESS (ADDRESS) VALUES
    ('user@gmail.com'),
    ('admin@gmail.com');

--security user account
INSERT INTO SECURE_ACCOUNT (IS_ENABLED, IS_ACCOUNT_EXPIRED, IS_CREDENTIALS_EXPIRED, IS_ACCOUNT_LOCKED) VALUES
    (1, 1, 1, 1),
    (1, 1, 1, 1),
    (1, 0, 0, 0);

--test users
INSERT INTO USERS (FIRST_NAME, LAST_NAME, PASSWORD, EMAIL_ID, SECURE_ACCOUNT_ID) VALUES
    ('Pholo', 'Li', '$2a$12$3pJtHTI.AnSQO7MSuif96eFyWnMyPDqrklba1b3wPBFU0vVjYIiye', 2, 1),
	('Nto', 'Gogo', '$2a$12$Wu3wazXtx.jByhfH5BojY.OsKvPQ6aqYxIKB6pe5nvMkNsYGOi8OC', 1, 2);

--  test user and role mapping
INSERT INTO USER_ROLE (USER_ID, ROLE_ID) VALUES
    (1, 2),
    (2, 3);