package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import javax.persistence.EntityManager;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(JpaBestelbonRepository.class)
@Sql("/insertSoort.sql")
@Sql("/insertBrouwer.sql")
@Sql("/insertBier.sql")
@Sql("/insertBestelbon.sql")
@Sql("/insertBestelbonlijn.sql")
class JpaBestelbonRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JpaBestelbonRepository repository;
    private final EntityManager manager;
    private static final String BESTELBONNEN = "bestelbonnen";
    private Bestelbon bestelbon;
    private Bestelbonlijn bestelbonlijn;
    private Bier bier;
    private Soort soort;
    private Brouwer brouwer;

    public JpaBestelbonRepositoryTest(JpaBestelbonRepository repository, EntityManager manager) {
        this.repository = repository;
        this.manager = manager;
    }

    @BeforeEach
    void setUp() {
        soort = new Soort("sortTest");
        brouwer = new Brouwer("brouwerTest", new Adres("test", "test", 1000, "test"), BigDecimal.TEN);
        bier = new Bier("testBeer", brouwer, soort, BigDecimal.ONE, BigDecimal.ONE, 1);
        bestelbon = new Bestelbon("bestelTest", new Adres("test2", "test2", 2000, "test2"));
        bestelbonlijn = new Bestelbonlijn(bier, 1, BigDecimal.ONE);
    }

    @Test
    void createBestelBon() {
        manager.persist(soort);
        manager.persist(brouwer);
        manager.persist(bier);
        repository.create(bestelbon);
        manager.flush();
        assertThat(bestelbon.getId()).isPositive();
        assertThat(super.countRowsInTableWhere(BESTELBONNEN, "id="+bestelbon.getId())).isOne();


    }
}