package be.vdab.beerhousewithjpa.repositories;

import be.vdab.beerhousewithjpa.domain.Adres;
import be.vdab.beerhousewithjpa.domain.Bier;
import be.vdab.beerhousewithjpa.domain.Brouwer;
import be.vdab.beerhousewithjpa.domain.Soort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.*;

@DataJpaTest
@Import(JpaBierRepository.class)
@Sql("/insertBrouwer.sql")
@Sql("/insertSoort.sql")
@Sql("/insertBier.sql")
class JpaBierRepositoryTest extends AbstractTransactionalJUnit4SpringContextTests {

    private final JpaBierRepository repository;
    private final static String BIEREN = "bieren";
    private Brouwer brouwer;
    private Soort soort;
    private Bier bier;

    public JpaBierRepositoryTest(JpaBierRepository repository) {
        this.repository = repository;
    }

    @BeforeEach
    void setUp() {
        brouwer = new Brouwer("brouwerTest",
                new Adres("straat", "huisNr", 1000, "gemeente"),
                BigDecimal.TEN);
        soort = new Soort("soortTest");
        bier = new Bier("bierTest", BigDecimal.ONE, BigDecimal.ONE, 10, soort, brouwer);
    }

    private long idFromTheTestBier() {
        return super.jdbcTemplate.queryForObject("select id from bieren where naam='test'", Long.class);
    }

    @Test
    void findAantalBieren() {
        assertThat(repository.findAantalBieren()).isEqualTo(super.countRowsInTable(BIEREN));
    }

    @Test
    void findAllBierByBrouwerId() {
        long id = idFromTheTestBier();
//        assertThat(repository.findAllBierByBrouwerId(id)).extracting(bier1 -> bier1.getNaam()).isEqualTo("test");
        assertThat(repository.findAllBierByBrouwerId(id)).hasSize(super.countRowsInTableWhere(BIEREN, "brouwerid="+id));
    }
}