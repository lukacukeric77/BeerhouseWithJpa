package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.repositories.BierRepository;
import org.springframework.stereotype.Service;

@Service
public class DefaultBierService implements BierService {

    private final BierRepository repository;

    public DefaultBierService(BierRepository repository) {
        this.repository = repository;
    }

    @Override
    public long findAantalBieren() {
        return repository.findAantalBieren();
    }
}
