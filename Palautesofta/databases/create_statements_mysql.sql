CREATE TABLE kysymys (
kysymys_id integer NOT NULL auto_increment
,kysymys_nimi varchar(255) NOT NULL
,PRIMARY KEY(kysymys_id)
);

CREATE TABLE vastaus (
vastaus_id integer NOT NULL auto_increment
,vastaus_nimi varchar(255) NOT NULL
,kysymys_id int NOT NULL
,PRIMARY KEY(vastaus_id)
,FOREIGN KEY (kysymys_id) REFERENCES kysymys (kysymys_id)
);

INSERT INTO kysymys
(kysymys_nimi)
VALUES
('Onko kivaa?');

INSERT INTO vastaus
(vastaus_nimi,
kysymys_id)
VALUES
('On hienoa.',
1);

INSERT INTO vastaus
(vastaus_nimi,
kysymys_id)
VALUES
('Ei kyllä.',
1);

INSERT INTO kysymys
(kysymys_nimi)
VALUES
('Miten menee?');

INSERT INTO vastaus
(vastaus_nimi,
kysymys_id)
VALUES
('Aivan upeasti.',
2);

INSERT INTO vastaus
(vastaus_nimi,
kysymys_id)
VALUES
('On helvetinmoinen nälkä.',
2);
