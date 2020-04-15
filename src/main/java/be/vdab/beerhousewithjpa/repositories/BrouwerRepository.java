package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Brouwer;

import java.util.List;

public interface BrouwerRepository {
    List<Brouwer> findAllBrouwers();
}
