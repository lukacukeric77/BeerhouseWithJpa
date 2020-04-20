package be.vdab.beerhousewithjpa.domain;

import org.hibernate.validator.constraints.Range;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Embeddable
@Access(AccessType.FIELD)
public class Adres {
    @NotBlank
    private String straat;
    @NotBlank
    private String huisNr;
    @NotNull @Positive @Range(min = 1000, max = 9999)
    private Integer postcode;
    @NotBlank
    private String gemeente;

    protected Adres() {
    }

    public Adres(String straat, String huisNr, Integer postcode, String gemeente) {
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

    public Integer getPostcode() {
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
