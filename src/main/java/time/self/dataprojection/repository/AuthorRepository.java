package time.self.dataprojection.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import time.self.dataprojection.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {
}
