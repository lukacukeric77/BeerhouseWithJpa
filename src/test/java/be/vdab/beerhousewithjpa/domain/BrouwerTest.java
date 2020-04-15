package be.vdab.beerhousewithjpa.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;

class BrouwerTest {

    private Brouwer brouwer;
    private Bier bier;
    private Soort soort;

    @BeforeEach
    void setUp() {
        brouwer = new Brouwer("testBrouwer", new Adres("street", "housenr", 1000, "comunity"), BigDecimal.TEN);
        soort = new Soort("testSoort");
        bier = new Bier("testBier", BigDecimal.ONE, BigDecimal.ONE, 10, soort, brouwer);
    }

    @Test
    void breuwerHasBier() {
        assertThat(bier.getBrouwer()).isEqualTo(brouwer);
        assertThat(brouwer.getBiers()).containsOnly(bier);
    }

    @Test
    void bierHasSoortAndViceVersa() {
        assertThat(bier.getSoort()).isEqualTo(soort);
        assertThat(soort.getBierSet()).containsOnly(bier);
    }

}
