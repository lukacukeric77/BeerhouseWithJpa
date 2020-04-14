package be.vdab.beerhousewithjpa.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(JpaBierRepository.class)
class JpaBierRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JpaBierRepository repository;
    private final static String BIEREN = "bieren";

    public JpaBierRepositoryTest(JpaBierRepository repository) {
        this.repository = repository;
    }

    @Test
    void findAantalBieren() {
        assertThat(repository.findAantalBieren()).isEqualTo(super.countRowsInTable(BIEREN));
    }
}