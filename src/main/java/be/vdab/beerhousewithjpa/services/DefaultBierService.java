package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Bier;
import be.vdab.beerhousewithjpa.repositories.BierRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    @Override
    public List<Bier> findAllBierByBrouwerId(long id) {
        return repository.findAllBierByBrouwerId(id);
    }
}
