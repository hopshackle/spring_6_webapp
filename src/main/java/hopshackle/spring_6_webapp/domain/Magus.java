package hopshackle.spring_6_webapp.domain;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
public class Magus {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private House house;
    private int birthYear;
    private int deathYear;

    @OneToMany(mappedBy = "author")
    private Set<Book> booksWritten = new HashSet<>();
    @OneToMany(mappedBy = "owner")
    private Set<Book> booksOwned = new HashSet<>();

    public Set<Book> getBooksWritten() {
        return booksWritten;
    }

    public void setBooksWritten(Set<Book> booksWritten) {
        this.booksWritten = booksWritten;
    }

    public Set<Book> getBooksOwned() {
        return booksOwned;
    }

    public void setBooksOwned(Set<Book> booksOwned) {
        this.booksOwned = booksOwned;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getDeathYear() {
        return deathYear;
    }

    public void setDeathYear(int deathYear) {
        this.deathYear = deathYear;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Magus magus = (Magus) o;
        return Objects.equals(id, magus.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Magus{" +
                "name='" + name + '\'' +
                ", house=" + house +
                ", birthYear=" + birthYear +
                '}';
    }
}
