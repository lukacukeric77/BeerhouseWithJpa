package be.vdab.beerhousewithjpa.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;

class BierTest {

    private Bier bier1;
    private Bier bier2;
    private Bier againBier1;
    private Brouwer brouwer1;
    private Soort soort1;
    private Soort soort2;


    @BeforeEach
    void setUp() {
        brouwer1 = new Brouwer("testBrouwer", new Adres("street", "number", 1000, "community"), BigDecimal.TEN);
        soort1 = new Soort("soortTest");
        soort2 = new Soort("soortTest2");
        bier1 = new Bier("testBier", brouwer1, soort1, BigDecimal.ONE, BigDecimal.ONE, 10);
        bier2 = new Bier("testBier2", brouwer1, soort2, BigDecimal.ONE, BigDecimal.ONE, 10);
        againBier1 = new Bier("testBier", brouwer1, soort1, BigDecimal.ONE, BigDecimal.ONE, 10);
    }

    @Test
    void oneBrouwerCanHaveManyBeers() {
        assertThat(brouwer1.getBiers()).containsOnly(bier1, bier2);
    }

    @Test
    void checkingForEquals() {
        assertThat(bier1).isNotEqualTo(bier2);
    }

    @Test
    void checkIfBier1AndBier2AreSame() {
        assertThat(bier1).isEqualTo(againBier1);
    }

    @Test
    void twoSameObjectsHaveSameHashCode() {
        assertThat(bier1).hasSameHashCodeAs(againBier1);
    }

    @Test
    void addToBesteld() {
        bier1.addToBesteld(10);
        assertThat(bier1.getBesteld()).isEqualByComparingTo(20L);
    }

    @Test
    void addToBesteldZeroThrowsExcept() {
        assertThatIllegalArgumentException().isThrownBy( ()-> bier1.addToBesteld(0));
    }

    @Test
    void addToBesteldWithNegativeNumbersThrowsExcept() {
        assertThatIllegalArgumentException().isThrownBy( ()-> bier1.addToBesteld(-1));
    }
}
