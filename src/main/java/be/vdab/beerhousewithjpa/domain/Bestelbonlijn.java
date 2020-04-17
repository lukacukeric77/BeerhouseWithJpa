package be.vdab.beerhousewithjpa.domain;

import javax.persistence.*;
import java.math.BigDecimal;

@Embeddable
@Access(AccessType.FIELD)
@Table(name = "bestelbonlijnen")
public class Bestelbonlijn {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "bierid")
    private Bier bier;

    private long aantal;

    private BigDecimal prijs;


    public Bestelbonlijn(Bier bier, long aantal, BigDecimal prijs) {
        this.bier = bier;
        this.aantal = aantal;
        this.prijs = prijs;
    }

    protected Bestelbonlijn() {
    }


    public Bier getBier() {
        return bier;
    }

    public long getAantal() {
        return aantal;
    }

    public BigDecimal getPrijs() {
        return prijs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bestelbonlijn)) return false;

        Bestelbonlijn that = (Bestelbonlijn) o;

        if (aantal != that.aantal) return false;
        if (bier != null ? !bier.equals(that.bier) : that.bier != null) return false;
        return prijs != null ? prijs.equals(that.prijs) : that.prijs == null;
    }

    @Override
    public int hashCode() {
        int result = bier != null ? bier.hashCode() : 0;
        result = 31 * result + (int) (aantal ^ (aantal >>> 32));
        result = 31 * result + (prijs != null ? prijs.hashCode() : 0);
        return result;
    }


    @Override
    public String toString() {
        return "Bestelbonlijn{" +
                "bier=" + bier.getNaam() +
                ", aantal=" + aantal +
                ", prijs=" + prijs +
                '}';
    }
}
