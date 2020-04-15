package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Brouwer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(JpaBrouwerRepository.class)
class JpaBrouwerRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JpaBrouwerRepository repository;
    private final static String BROUWERS = "brouwers";

    public JpaBrouwerRepositoryTest(JpaBrouwerRepository repository) {
        this.repository = repository;
    }

    @Test
    void findAllBrouwers() {
        assertThat(repository.findAllBrouwers()).hasSize(super.countRowsInTable(BROUWERS)).extracting(Brouwer::getNaam).isSorted();
    }
}