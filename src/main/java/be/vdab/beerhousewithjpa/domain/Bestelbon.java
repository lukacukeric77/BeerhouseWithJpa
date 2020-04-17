package be.vdab.beerhousewithjpa.domain;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "bestelbonnen")
public class Bestelbon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String naam;

    @Embedded @Valid
    private Adres adres;

//    @Embedded
//    private Bestelbonlijn bestelbonlijn;

    @ElementCollection @CollectionTable(name = "bestelbonlijnen", joinColumns = @JoinColumn(name = "bestelbonid"))
    @OrderBy("aantal, prijs")
    private Set<Bestelbonlijn> bestelbonlijnSet;

    protected Bestelbon() {
    }

    public Bestelbon(@NotBlank String naam, @NotBlank @Valid Adres adres) {
        this.naam = naam;
        this.adres = adres;
        bestelbonlijnSet = new LinkedHashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Adres getAdres() {
        return adres;
    }

    public Set<Bestelbonlijn> getBestelbonlijnSet() {
        return Collections.unmodifiableSet(bestelbonlijnSet);
    }

    public boolean addBestelbonlijn(Bestelbonlijn bestelbonlijn){
        if (bestelbonlijn==null){
            throw new NullPointerException();
        }
        return bestelbonlijnSet.add(bestelbonlijn);
    }

}
