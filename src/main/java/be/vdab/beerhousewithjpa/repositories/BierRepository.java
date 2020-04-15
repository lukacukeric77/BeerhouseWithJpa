package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Bier;

import java.util.List;

public interface BierRepository {
    long findAantalBieren();
    List<Bier> findAllBierByBrouwerId(long id);

}
