package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Bier;
import be.vdab.beerhousewithjpa.exceptions.BierNotFoundException;
import be.vdab.beerhousewithjpa.repositories.BierRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<Bier> findById(long id) {
        return repository.findById(id);
    }

    @Override
    public void addToBesteld(long id, long ammount) {
        Optional<Bier> optionalBier = repository.findById(id);
        if (optionalBier.isPresent()){
            optionalBier.get().addToBesteld(ammount);
        } else {
            throw new BierNotFoundException();
        }
    }
}
