CREATE TABLE kysymys (
kysymys_id
,nimi
PRIMARY KEY(kysymys_id)
);

CREATE TABLE vastaus (
vastaus_id
,nimi
PRIMARY KEY(vastaus_id)
REFERENCES kysymys (kysymys_id)
);
