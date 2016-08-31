CREATE TABLE config_reloadable (
  module VARCHAR(20) not null,
  usage VARCHAR(20) not null,
  key VARCHAR(50) PRIMARY key,
  value VARCHAR(255) not null,
  type VARCHAR(50),
  enable char(1) NOT NULL DEFAULT  0 ,
  remark VARCHAR(255)
);

CREATE TABLE config_param (
  key VARCHAR(50) NOT null,
  name VARCHAR(50) not null,
  value VARCHAR(255),
  enable char(1) NOT NULL DEFAULT 0,
  remark VARCHAR(255)
);
