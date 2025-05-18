package hopshackle.spring_6_webapp.bootstrap;

import hopshackle.spring_6_webapp.domain.Book;
import hopshackle.spring_6_webapp.domain.House;
import hopshackle.spring_6_webapp.domain.Magus;
import hopshackle.spring_6_webapp.repositories.BookRepository;
import hopshackle.spring_6_webapp.repositories.MagusRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import java.util.Set;

@Component
public class BootstrapData implements CommandLineRunner {

    private final MagusRepository magusRepository;
    private final BookRepository bookRepository;

    public BootstrapData(MagusRepository magusRepository, BookRepository bookRepository) {
        this.magusRepository = magusRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Magus bonisagus = new Magus();
        bonisagus.setName("Bonisagus");
        bonisagus.setHouse(House.BONISAGUS);
        bonisagus.setBirthYear(780);
        bonisagus.setDeathYear(-1);

        Magus tremere = new Magus();
        tremere.setName("Tremere");
        tremere.setHouse(House.TREMERE);
        tremere.setBirthYear(800);
        tremere.setDeathYear(-1);
        magusRepository.save(tremere);

        Book book1 = new Book();
        book1.setTitle("The Elements of Magic");
        book1.setAuthor(bonisagus);
        book1.setLevel(5);
        book1.setQuality(15);

        bonisagus.setBooksWritten(Set.of(book1));

        Magus magusSaved = magusRepository.save(bonisagus);
        Book bookSaved = bookRepository.save(book1);

        magusSaved.getBooksOwned().add(bookSaved);
        bookSaved.setOwner(magusSaved);

        magusRepository.save(magusSaved);
        bookRepository.save(bookSaved);

        System.out.println("Initial Data Loaded");
        System.out.println("Magus count: " + magusRepository.count());
        System.out.println("Book count: " + bookRepository.count());
    }
}
