package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Bier;

import java.util.List;

public interface BierService {
    long findAantalBieren();
    List<Bier> findAllBierByBrouwerId(long id);
}
