package time.self.dataprojection.dto;

import lombok.Data;

@Data
public class BookWithAuthorDto
{
    Long bookId;
    String title;
    String authorName;
    public BookWithAuthorDto(Long bookId, String title, String authorName) {
        this.bookId = bookId;
        this.title = title;
        this.authorName = authorName;
    }
}
