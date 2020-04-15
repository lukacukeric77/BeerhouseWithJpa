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

    @OneToMany(mappedBy = "brouwer")
    @OrderBy("naam, prijs")
    private Set<Bier> biers;

    protected Brouwer() {
    }

    public Brouwer(String naam, Adres adres, BigDecimal omzet) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Brouwer)) return false;

        Brouwer brouwer = (Brouwer) o;

        return naam != null ? naam.equals(brouwer.naam) : brouwer.naam == null;
    }

    @Override
    public int hashCode() {
        return naam != null ? naam.hashCode() : 0;
    }
}
