insert into bieren(naam, brouwerid, soortid, alcohol, prijs, besteld)
VALUES ('test',
        (select id from brouwers where brouwers.naam='ime'),
        (select id from soorten where soorten.naam='testSoort'),
        10, 10, 10);