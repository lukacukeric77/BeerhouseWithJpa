package be.vdab.beerhousewithjpa.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class BestelbonlijnTest {

    private Bestelbonlijn bestelbonlijn1, bestelbonlijn2, againBestelbonlijn1;
    private Bier bier1;
    private Bier bier2;
    private Soort soort1;
    private Soort soort2;
    private Brouwer brouwer;

    @BeforeEach
    void setUp() {
        soort1 = new Soort("testSoort1");
        soort2 = new Soort("testSoort2");
        brouwer = new Brouwer("testBrouwer", new Adres("test", "test", 1000, "test"), BigDecimal.TEN);
        bier1 = new Bier("testBier1", brouwer, soort1, BigDecimal.ONE, BigDecimal.ONE, 1);
        bier2 = new Bier("testBier2", brouwer, soort2, BigDecimal.ONE, BigDecimal.ONE, 1);
        bestelbonlijn1 = new Bestelbonlijn(bier1, 1, BigDecimal.ONE);
        againBestelbonlijn1 = new Bestelbonlijn(bier1, 1, BigDecimal.ONE);
        bestelbonlijn2 = new Bestelbonlijn(bier2, 1, BigDecimal.ONE);
    }

    @Test
    void testForEqualsInBestelbonlijn() {
        assertThat(bestelbonlijn1).isEqualTo(againBestelbonlijn1);
    }

    @Test
    void testForNotEqualInBestelbonlijn() {
        assertThat(bestelbonlijn1).isNotEqualTo(bestelbonlijn2);
    }

    @Test
    void notEqualToNull() {
        assertThat(bestelbonlijn1).isNotEqualTo(null);
    }

    @Test
    void notEqualToOtherObject() {
        assertThat(bestelbonlijn1).isNotEqualTo("");
    }

    @Test
    void hashCodeEqualsBetweenSameObjects() {
        assertThat(bestelbonlijn1).hasSameHashCodeAs(againBestelbonlijn1);
    }
}