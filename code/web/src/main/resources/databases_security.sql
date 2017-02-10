CREATE TABLE web_users (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  username VARCHAR(255) NOT NULL ,
  password VARCHAR(255) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE web_roles (
  id INT NOT NULL AUTO_INCREMENT PRIMARY KEY ,
  name VARCHAR(100) NOT NULL
) ENGINE = InnoDB;

CREATE TABLE web_user_roles(
  user_id INT NOT NULL  ,
  role_id INT NOT NULL  ,

  FOREIGN KEY (user_id) REFERENCES web_users(id),
  FOREIGN KEY (role_id) REFERENCES web_roles(id),

  UNIQUE (user_id,role_id)
) ENGINE = InnoDB;


INSERT INTO web_users VALUES(1,'admin','');
INSERT INTO web_users VALUES(2,'administrator','');
INSERT INTO web_users VALUES(3,'operator','');
INSERT INTO web_users VALUES(4,'user','');

INSERT INTO web_roles VALUES(1,'ROLE_ADMIN');
INSERT INTO web_roles VALUES(2,'ROLE_USER');

INSERT INTO web_user_roles VALUES(1,1);
INSERT INTO web_user_roles VALUES(1,1);
INSERT INTO web_user_roles VALUES(2,1);
INSERT INTO web_user_roles VALUES(3,1);
INSERT INTO web_user_roles VALUES(4,2);

