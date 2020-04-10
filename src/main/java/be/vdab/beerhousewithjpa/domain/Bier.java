package be.vdab.beerhousewithjpa.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "bieren")
public class Bier {

    @Id
    private long id;

    private String naam;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "brouwerid")
    private Brouwer brouwer;

    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    @JoinColumn(name = "soortid")
    private Soort soort;

    private BigDecimal alcohol;

    private BigDecimal prijs;

    private long besteld;

    protected Bier() {
    }

    public Bier(String naam, BigDecimal prijs, BigDecimal alcohol, long besteld, Soort soort, Brouwer brouwer) {
        this.naam = naam;
        this.prijs = prijs;
        this.besteld = besteld;
        this.alcohol = alcohol;
        setSoort(soort);
        setBrouwer(brouwer);
    }

    public void setSoort(Soort soort) {
        if (!soort.getBierSet().contains(this)){
            soort.add(this);
        }
        this.soort = soort;
    }

    public void setBrouwer(Brouwer brouwer) {
        if (!brouwer.getBiers().contains(this)){
            brouwer.add(this);
        }
        this.brouwer = brouwer;
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Brouwer getBrouwer() {
        return brouwer;
    }

    public Soort getSoort() {
        return soort;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    public long getBesteld() {
        return besteld;
    }

    public BigDecimal getAlcohol() {
        return alcohol;
    }
}
