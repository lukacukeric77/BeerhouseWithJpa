package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Brouwer;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class JpaBrouwerRepository implements BrouwerRepository {

    private final EntityManager manager;

    public JpaBrouwerRepository(EntityManager manager) {
        this.manager = manager;
    }

    @Override
    public List<Brouwer> findAllBrouwers() {
        return manager.createNamedQuery("Brouwer.findAllBrouwers",Brouwer.class).getResultList();
    }


}
