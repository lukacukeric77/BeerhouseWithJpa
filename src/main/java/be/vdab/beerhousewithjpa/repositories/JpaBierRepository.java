package be.vdab.beerhousewithjpa.repositories;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;

@Repository
public class JpaBierRepository implements BierRepository {

    private EntityManager entityManager;


    @Override
    public long findAantalBieren() {
        return 0;
    }
}
