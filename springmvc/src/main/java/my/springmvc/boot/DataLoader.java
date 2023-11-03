package my.springmvc.boot;

import my.springmvc.model.Book;
import my.springmvc.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private BookRepository bookRepository;

    @Autowired
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }
    @Override
    public void run(String... args) throws Exception {

        Book book1 = new Book();
        book1.setTitle("Java 8 in Action");
        book1.setAuthor("Alan Mycroft");
        book1.setIsbn("1617291994");
        book1.setPrice(277.00);
        book1.setType("Technology");
        bookRepository.save(book1);

        Book book2 = new Book();
        book2.setTitle("another book");
        book2.setAuthor("another author");
        book2.setIsbn("1617291995");
        book2.setPrice(77.00);
        book2.setType("Terror");
        bookRepository.save(book2);


    }
}
