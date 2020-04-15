package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Bier;

import java.util.List;
import java.util.Optional;

public interface BierRepository {
    long findAantalBieren();
    List<Bier> findAllBierByBrouwerId(long id);
    Optional<Bier> findById(long id);

}
