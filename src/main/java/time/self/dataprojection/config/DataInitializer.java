package time.self.dataprojection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import time.self.dataprojection.model.Author;
import time.self.dataprojection.model.Book;
import time.self.dataprojection.repository.AuthorRepository;
import time.self.dataprojection.repository.BookRepository;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AuthorRepository authorRepository;

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void run(String... args) throws Exception {
        // Add some sample data for Author and Book entities
        Author author1 = new Author();
        author1.setName("John Doe");

        Author author2 = new Author();
        author2.setName("Jane Smith");

        authorRepository.save(author1);
        authorRepository.save(author2);

        Book book1 = new Book();
        book1.setTitle("Book 1");
        book1.setAuthor(author1);

        Book book2 = new Book();
        book2.setTitle("Book 2");
        book2.setAuthor(author2);

        bookRepository.save(book1);
        bookRepository.save(book2);
    }
}