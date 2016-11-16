CREATE TABLE kysely (
kysely_id integer NOT NULL auto_increment
,kysely_nimi varchar(255) NOT NULL
,kysely_kuvaus varchar(255)
,PRIMARY KEY(kysely_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysymys (
kysymys_id integer NOT NULL auto_increment
,kysely_id integer NOT NULL
,kysymys_nimi varchar(255) NOT NULLprojekti
,tyyppi_id integer NOT NULL
,PRIMARY KEY(kysymys_id)
,FOREIGN KEY (kysely_id) REFERENCES kysely (kysely_id)
,FOREIGN KEY (tyyppi_id) REFERENCES kysymys_tyyppi (tyyppi_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE kysymys_tyyppi (
tyyppi_id integer NOT NULL
,tyyppi_nimi varchar(255) NOT NULL
,PRIMARY KEY(tyyppi_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE vastaus (
vastaus_id integer NOT NULL auto_increment
,kysymys_id integer NOT NULL
,vastaus_nimi varchar(255)
,PRIMARY KEY(vastaus_id)
,FOREIGN KEY (kysymys_id) REFERENCES kysymys (kysymys_id)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

