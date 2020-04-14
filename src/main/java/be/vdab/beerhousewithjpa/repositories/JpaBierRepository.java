package be.vdab.beerhousewithjpa.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;

@Repository
public class JpaBierRepository implements BierRepository {

    private final EntityManager manager;

    public JpaBierRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public long findAantalBieren() {
        return manager.createNamedQuery("Bier.findAantalBieren", Long.class).getSingleResult();
    }
}
