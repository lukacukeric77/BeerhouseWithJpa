package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Bestelbon;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Repository
public class JpaBestelbonRepository implements BestelbonRepository {

    private final EntityManager manager;

    public JpaBestelbonRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public void create(Bestelbon bestelbon) {
        manager.persist(bestelbon);
    }
}
