CREATE TABLE authority (
authority_id integer NOT NULL auto_increment
,role varchar(255) NOT NULL UNIQUE
,PRIMARY KEY(authority_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
CREATE TABLE admin (
admin_id integer NOT NULL auto_increment
,username varchar(255) NOT NULL UNIQUE
,password_encrypted varchar(255) NOT NULL
,enabled tinyint NOT NULL
,PRIMARY KEY(admin_id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE admin_authority (
admin_authority_id integer NOT NULL auto_increment
,admin_id integer NOT NULL
,authority_id integer NOT NULL
,PRIMARY KEY(admin_authority_id)
,FOREIGN KEY (admin_id) REFERENCES admin(admin_id) ON DELETE NO ACTION ON UPDATE NO ACTION
,FOREIGN KEY (authority_id) REFERENCES authority(authority_id) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysely (
kysely_id integer NOT NULL auto_increment
,admin_id integer NOT NULL
,kysely_nimi varchar(255) NOT NULL
,kysely_kuvaus varchar(255)
,PRIMARY KEY(kysely_id)
,FOREIGN KEY(admin_id) REFERENCES admin (admin_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysymys_tyyppi (
tyyppi_id integer NOT NULL
,tyyppi_nimi varchar(255) NOT NULL
,PRIMARY KEY(tyyppi_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysymys (
kysymys_id integer NOT NULL auto_increment
,kysely_id integer NOT NULL
,kysymys_nimi varchar(255) NOT NULLprojekti
,tyyppi_id integer NOT NULL
,PRIMARY KEY(kysymys_id)
,FOREIGN KEY (kysely_id) REFERENCES kysely (kysely_id) ON DELETE CASCADE
,FOREIGN KEY (tyyppi_id) REFERENCES kysymys_tyyppi (tyyppi_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE vastaus (
vastaus_id integer NOT NULL auto_increment
,kysymys_id integer NOT NULL
,vastaus_nimi varchar(255)
,PRIMARY KEY(vastaus_id)
,FOREIGN KEY (kysymys_id) REFERENCES kysymys (kysymys_id) ON DELETE CASCADE
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

