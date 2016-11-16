INSERT INTO kysely
(kysely_nimi)
VALUES
('Elämä');

INSERT INTO kysely
(kysely_nimi
,kysely_kuvaus)
VALUES
('Elämäkö'
,'Eksistentiaalinen kriisi');

INSERT INTO kysymys_tyyppi
VALUES
(1
,'avoin kysymys');

INSERT INTO kysymys_tyyppi
VALUES
(2
,'radiobutton');

INSERT INTO kysymys
(kysely_id
,kysymys_nimi
,tyyppi_id)
VALUES
(1
,'Onko?'
,1);

INSERT INTO kysymys
(kysely_id
,kysymys_nimi
,tyyppi_id)
VALUES
(2
,'Vaiko eikö?'
,1);

INSERT INTO vastaus
(kysymys_id
,vastaus_nimi)
VALUES
(1
,'Ei ole.');

INSERT INTO vastaus
(kysymys_id
,vastaus_nimi)
VALUES
(2
,'Noh.');

INSERT INTO kysymys
(kysely_id
,kysymys_nimi
,tyyppi_id)
VALUES
(2
,'Onko kivaa?'
,2);

INSERT INTO vastaus
(kysymys_id
,vastaus_nimi)
VALUES
(3
,'1');
