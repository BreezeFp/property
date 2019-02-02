CREATE TABLE PUBLIC.SYS_USER
(
  id SERIAL PRIMARY KEY,
  username VARCHAR(32) NOT NULL,
  password VARCHAR(128) NOT NULL,
  nickname VARCHAR(128),
  last_password_reset_date TIMESTAMP,
  locked BOOLEAN DEFAULT FALSE,
  remover INTEGER,
  removed TIMESTAMP
);
INSERT INTO public.sys_user (id, username, password, nickname, last_password_reset_date, locked, remover, removed) VALUES (1, 'admin', '$2a$10$mJV7cDVP.Z.HUMrBq9Nb7u6bBEhVA.nmuJ1/SYvkC9JxzIK7U103e', null, '2019-02-03 03:49:56.362000', false, null, null);

CREATE TABLE PUBLIC.SYS_ROLE
(
  ID     SERIAL PRIMARY KEY,
  CODE   VARCHAR(32) NOT NULL,
  NAME   VARCHAR(64) NOT NULL,
  REMARK VARCHAR(512)
);
INSERT INTO PUBLIC.SYS_ROLE(id, CODE, NAME, REMARK) VALUES (1, 'admin', '超级管理员', '');

CREATE TABLE PUBLIC.SYS_USER_ROLE
(
  ID      SERIAL PRIMARY KEY,
  USER_ID INTEGER NOT NULL,
  ROLE_ID INTEGER NOT NULL
);
INSERT INTO PUBLIC.SYS_USER_ROLE(user_id, role_id) VALUES (1,1);