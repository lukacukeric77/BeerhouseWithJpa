package be.vdab.beerhousewithjpa.domain;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;

@Embeddable
@Access(AccessType.FIELD)
public class Adres {
    private String straat;
    private String huisNr;
    private int postcode;
    private String gemeente;

    protected Adres() {
    }

    public Adres(String straat, String huisNr, int postcode, String gemeente) {
        this.straat = straat;
        this.huisNr = huisNr;
        this.postcode = postcode;
        this.gemeente = gemeente;
    }

    public String getStraat() {
        return straat;
    }

    public String getHuisNr() {
        return huisNr;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getGemeente() {
        return gemeente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Adres)) return false;

        Adres adres = (Adres) o;

        if (postcode != adres.postcode) return false;
        if (straat != null ? !straat.equals(adres.straat) : adres.straat != null) return false;
        if (huisNr != null ? !huisNr.equals(adres.huisNr) : adres.huisNr != null) return false;
        return gemeente != null ? gemeente.equals(adres.gemeente) : adres.gemeente == null;
    }

    @Override
    public int hashCode() {
        int result = straat != null ? straat.hashCode() : 0;
        result = 31 * result + (huisNr != null ? huisNr.hashCode() : 0);
        result = 31 * result + postcode;
        result = 31 * result + (gemeente != null ? gemeente.hashCode() : 0);
        return result;
    }
}
