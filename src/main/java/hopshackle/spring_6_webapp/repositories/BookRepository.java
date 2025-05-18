package hopshackle.spring_6_webapp.repositories;

import hopshackle.spring_6_webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book,Long> {
}
