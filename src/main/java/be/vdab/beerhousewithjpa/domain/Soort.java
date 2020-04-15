package be.vdab.beerhousewithjpa.domain;

import javax.persistence.*;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "soorten")
public class Soort {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String naam;

    @OneToMany(mappedBy = "soort", cascade = CascadeType.REMOVE)
    @OrderBy("naam, prijs")
    private Set<Bier> bierSet;


    protected Soort() {
    }

    public Soort(String naam) {
        this.naam = naam;
        this.bierSet = new LinkedHashSet<>();
    }

    public long getId() {
        return id;
    }

    public String getNaam() {
        return naam;
    }

    public Set<Bier> getBierSet() {
        return Collections.unmodifiableSet(bierSet);
    }

    public boolean add(Bier bier){
        boolean toegevoegd = bierSet.add(bier);
        Soort oudeSoort = bier.getSoort();
        if (oudeSoort !=null && oudeSoort !=this){
            oudeSoort.bierSet.remove(bier);
        }
        if (this != oudeSoort){
            bier.setSoort(this);
        }
        return toegevoegd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Soort)) return false;

        Soort soort = (Soort) o;

        return naam.toLowerCase() != null ? naam.toLowerCase().equals(soort.naam.toLowerCase()) : soort.naam.toLowerCase() == null;
    }

    @Override
    public int hashCode() {
        return naam.toLowerCase() != null ? naam.toLowerCase().hashCode() : 0;
    }
}
