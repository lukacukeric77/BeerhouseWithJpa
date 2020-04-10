package be.vdab.beerhousewithjpa.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "brouwers")
public class Brouwer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    @Embedded
    private Adres adres;

    private BigDecimal omzet;

    @OneToMany(mappedBy = "brouwer", cascade = CascadeType.REMOVE)
    @OrderBy("naam, prijs")
    private Set<Bier> biers;

    protected Brouwer() {
    }

    public Brouwer(long id, String naam, Adres adres, BigDecimal omzet) {
        this.id = id;
        this.naam = naam;
        this.adres = adres;
        this.omzet = omzet;
        this.biers = new LinkedHashSet<>();
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

    public BigDecimal getOmzet() {
        return omzet;
    }

    public Set<Bier> getBiers() {
        return Collections.unmodifiableSet(biers);
    }

    public boolean add(Bier bier){
        boolean toegevoegd = biers.add(bier);
        Brouwer oudeBreuwer = bier.getBrouwer();
        if (oudeBreuwer !=null && oudeBreuwer !=this){
            oudeBreuwer.biers.remove(bier);
        }
        if (this != oudeBreuwer){
            bier.setBrouwer(this);
        }
        return toegevoegd;
    }

}
