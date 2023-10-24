package time.self.dataprojection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import time.self.dataprojection.dto.BookWithAuthorDto;
import time.self.dataprojection.dto.InterfaceProjection;
import time.self.dataprojection.model.Book;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Long> {
   @Query("""
    select new time.self.dataprojection.dto.BookWithAuthorDto(b.id
    , b.title
    ,a.name)
    from Book b
    join b.author a
    """)
   List<BookWithAuthorDto> dtoBookAuthor();

   @Query("""
    select
    b.id as bookId
    ,b.title as title
    ,a.name as authorName
    from Book b
    join b.author a
    """)
   List<InterfaceProjection> interfaceBookAuthor();


}
