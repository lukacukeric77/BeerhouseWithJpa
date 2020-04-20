package be.vdab.beerhousewithjpa.services;

import be.vdab.beerhousewithjpa.domain.Adres;
import be.vdab.beerhousewithjpa.domain.Bier;
import be.vdab.beerhousewithjpa.domain.Brouwer;
import be.vdab.beerhousewithjpa.domain.Soort;
import be.vdab.beerhousewithjpa.exceptions.BierNotFoundException;
import be.vdab.beerhousewithjpa.repositories.BierRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.assertj.core.api.Assertions.*;

import java.math.BigDecimal;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class DefaultBierServiceTest {

    private DefaultBierService service;
    @Mock
    private BierRepository repository;
    private Brouwer brouwer1;
    private Soort soort1;
    private Bier bier1;

    @BeforeEach
    void setUp() {
        brouwer1 = new Brouwer("testBrouwer", new Adres("street", "number", 1000, "community"), BigDecimal.TEN);
        soort1 = new Soort("soortTest");
        bier1 = new Bier("testBier", brouwer1, soort1, BigDecimal.ONE, BigDecimal.ONE, 10);
        service = new DefaultBierService(repository);
    }

    @Test
    void addToBesteld() {
        when(repository.findById(1)).thenReturn(Optional.of(bier1));
        service.addToBesteld(1, 10L);
        assertThat(bier1.getBesteld()).isEqualByComparingTo(20L);
        verify(repository).findById(1);
    }

    @Test
    void bierNotFoundException() {
        assertThatExceptionOfType(BierNotFoundException.class).isThrownBy(() -> service.addToBesteld(-1, 10));
        verify(repository).findById(-1);
    }
}