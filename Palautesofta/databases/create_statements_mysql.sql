CREATE TABLE kysymys (
kysymys_id integer NOT NULL auto_increment
,nimi varchar(255) NOT NULL
PRIMARY KEY(kysymys_id)
);

CREATE TABLE vastaus (
vastaus_id integer NOT NULL auto_increment
,nimi varchar(255) NOT NULL
,kysymys_id int NOT NULL
PRIMARY KEY(vastaus_id)
FOREIGN KEY (kysymys_id) REFERENCES kysymys (kysymys_id)
); 
