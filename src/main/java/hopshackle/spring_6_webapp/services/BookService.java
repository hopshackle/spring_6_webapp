package hopshackle.spring_6_webapp.services;

import hopshackle.spring_6_webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();

    Book getBook(Long id);
}
