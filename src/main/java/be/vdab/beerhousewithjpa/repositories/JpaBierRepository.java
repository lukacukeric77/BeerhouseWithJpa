package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Bier;
import be.vdab.beerhousewithjpa.domain.Brouwer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<Bier> findAllBierByBrouwerId(long id) {
        return manager.createNamedQuery("Bier.findAllBierByBrouwerId",Bier.class)
                .setParameter("id", id)
                .getResultList();
    }

    @Override
    public Optional<Bier> findById(long id) {
        return Optional.ofNullable(manager.find(Bier.class, id));
    }
}
