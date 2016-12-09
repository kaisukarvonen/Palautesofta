INSERT INTO admin
(username
 ,password_encrypted
 ,enabled)
VALUES
('satan'
 ,'ef9c11d676409608641a05617db400ce1584d6c382f4007a9cc42d4a458d7343bfb9767030cdbaa4'
 ,1);
 
INSERT INTO admin_authority
(admin_id
 ,authority_id)
VALUES
(1
 ,1);

INSERT INTO authority
(role)
VALUES
(ROLE_ADMIN);

INSERT INTO kysely
(kysely_nimi
 ,admin_id)
 VALUES
('Testikysely'
 ,1);

INSERT INTO kysymys_tyyppi
VALUES
(1
 ,'avoin kysymys');

INSERT INTO kysymys_tyyppi
VALUES
(2
 ,'radiobutton');
 
INSERT INTO kysymys_tyyppi
VALUES
(3
 ,'skaala');

INSERT INTO kysymys
(kysely_id
 ,kysymys_nimi
 ,tyyppi_id
 ,vaihtoehdot)
VALUES
(3
 ,'Minkä arvosanan antaisit kurssista?'
 ,2
 ,'hyvä,keskiverto,huono');

INSERT INTO vastaus
(kysymys_id
,vastaus_nimi)
VALUES
(6
,'keskiverto');
