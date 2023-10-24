package time.self.dataprojection.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import time.self.dataprojection.dto.BookWithAuthorDto;

@Entity
@Data
@SqlResultSetMapping(
        name="BookWithAuthorDto",
        classes={
                @ConstructorResult(
                        targetClass= BookWithAuthorDto.class,
                        columns={
                                @ColumnResult(name="aa"),
                                @ColumnResult(name="bb"),
                                @ColumnResult(name="cc")
                                }
                                )
                }
)
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
}
