package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Brouwer;
import be.vdab.beerhousewithjpa.repositories.BrouwerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DefaultBreuwerService implements BrouwerService {

    private final BrouwerRepository repository;

    public DefaultBreuwerService(BrouwerRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Brouwer> findAllBrouwers() {
        return repository.findAllBrouwers();
    }
}
