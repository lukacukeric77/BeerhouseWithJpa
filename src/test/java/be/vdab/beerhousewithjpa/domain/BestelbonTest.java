package be.vdab.beerhousewithjpa.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatNullPointerException;

class BestelbonTest {

    private Bestelbonlijn bestelbonlijn1, bestelbonlijn2, againBestelbonlijn1;
    private Bier bier1;
    private Bier bier2;
    private Soort soort1;
    private Soort soort2;
    private Brouwer brouwer;
    private Bestelbon bestelbon;

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
        bestelbon = new Bestelbon("testBestelbon", new Adres("testA", "test", 1500, "test"));
    }

    @Test
    void newBestelbonHasNoBestelbonlijnen() {
        assertThat(bestelbon.getBestelbonlijnSet()).isEmpty();
    }

    @Test
    void addBestelbonlijn() {
        assertThat(bestelbon.addBestelbonlijn(bestelbonlijn1)).isTrue();
        assertThat(bestelbon.getBestelbonlijnSet()).containsOnly(bestelbonlijn1);
    }

    @Test
    void twoTimesBestelbonlijn() {
        assertThat(bestelbon.addBestelbonlijn(bestelbonlijn1)).isTrue();
        assertThat(bestelbon.addBestelbonlijn(againBestelbonlijn1)).isFalse();
        assertThat(bestelbon.getBestelbonlijnSet()).containsOnly(bestelbonlijn1);
    }

    @Test
    void nullAsAddedFails() {
        assertThatNullPointerException().isThrownBy( ()-> bestelbon.addBestelbonlijn(null));
    }
}