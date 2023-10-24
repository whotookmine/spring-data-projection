package time.self.dataprojection.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import time.self.dataprojection.dto.BookWithAuthorDto;
import time.self.dataprojection.dto.InterfaceProjection;
import time.self.dataprojection.repository.AuthorRepository;
import time.self.dataprojection.repository.BookRepository;
import time.self.dataprojection.repository.BookRepositoryImpl;

import java.util.List;

@RestController
public class Controller {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private BookRepositoryImpl bookRepositoryImpl;

    public Controller(BookRepository bookRepository, AuthorRepository authorRepository, BookRepositoryImpl bookRepositoryImpl) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.bookRepositoryImpl = bookRepositoryImpl;
    }

    @GetMapping("/getByPojo")
    public List<BookWithAuthorDto> getByPojo(){
        return bookRepository.dtoBookAuthor();
    }

    @GetMapping("/getByInterface")
    public List<InterfaceProjection> getByInterface() {
        return bookRepository.interfaceBookAuthor();
    }

    @GetMapping("/getByNativeQueryImpl")
    public List<BookWithAuthorDto> getByNativeQueryImpl() {
        return this.bookRepositoryImpl.resultSetMapping();
    }

}
