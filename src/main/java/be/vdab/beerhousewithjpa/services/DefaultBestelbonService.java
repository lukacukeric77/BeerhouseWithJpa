package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Bestelbon;
import be.vdab.beerhousewithjpa.repositories.BestelbonRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class DefaultBestelbonService implements BestelbonService{

    private final BestelbonRepository repository;

    public DefaultBestelbonService(BestelbonRepository repository) {
        this.repository = repository;
    }

    @Override @Transactional
    public void create(Bestelbon bestelbon) {
        repository.create(bestelbon);
    }
}
