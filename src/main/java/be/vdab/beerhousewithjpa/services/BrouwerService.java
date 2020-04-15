package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Brouwer;

import java.util.List;

public interface BrouwerService {
    List<Brouwer> findAllBrouwers();
}
