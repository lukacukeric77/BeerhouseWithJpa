package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Bier;

import java.util.List;
import java.util.Optional;

public interface BierService {
    long findAantalBieren();
    List<Bier> findAllBierByBrouwerId(long id);
    Optional<Bier> findById(long id);
    void addToBesteld(long id, long ammount);
}
