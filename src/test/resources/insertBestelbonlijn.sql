insert into bestelbonlijnen(bestelbonid, bierid, aantal, prijs) VALUES (
                                                                        (select id from bestelbonnen where naam='bestelbonTest'),
                                                                        (select id from bieren where naam='test'),
                                                                        1, 10);