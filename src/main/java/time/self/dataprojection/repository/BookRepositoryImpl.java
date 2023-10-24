package time.self.dataprojection.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import time.self.dataprojection.dto.BookWithAuthorDto;

import java.util.List;
@Repository
public class BookRepositoryImpl {
    @PersistenceContext
    private EntityManager entityManager;

    String sql = """
            SELECT 
            b.id AS aa
            , b.title AS bb
            , a.name AS cc
            FROM book b
            INNER JOIN author a ON a.id = b.author_id
            WHERE b.id = :bookId
            """;

    public List<BookWithAuthorDto> resultSetMapping() {
        List<BookWithAuthorDto> resultList = this.entityManager.createNativeQuery(sql, "BookWithAuthorDto")
                .setParameter("bookId",1)
                .getResultList();
        return resultList;
    }
}
