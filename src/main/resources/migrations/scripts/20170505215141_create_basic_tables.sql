-- // create_basic_tables
-- Migration SQL that makes the change goes here.
CREATE TABLE monuments (
  id          SERIAL        NOT NULL,
  name        VARCHAR(100)  NOT NULL,
  description VARCHAR(250)  NOT NULL,
  history     VARCHAR(500)  NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE photo_set (
  id          SERIAL  NOT NULL,
  description VARCHAR(250),
  monument_id INTEGER NOT NULL,
  PRIMARY KEY (id)
);

CREATE TABLE photos (
  id           SERIAL       NOT NULL,
  name         VARCHAR(100),
  path         VARCHAR(250) NOT NULL,
  photo_set_id INTEGER      NOT NULL,
  PRIMARY KEY (id)
);

-- //@UNDO
-- SQL to undo the change goes here.
DROP TABLE monuments;
DROP TABLE photo_set;
DROP TABLE photos;
