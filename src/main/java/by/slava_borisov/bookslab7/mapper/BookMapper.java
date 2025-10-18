package by.slava_borisov.bookslab7.mapper;

import by.slava_borisov.bookslab7.dto.Book;
import by.slava_borisov.bookslab7.model.BookEntity;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class BookMapper {
    private final AuthorMapper authorMapper;
    private final GenreMapper genreMapper;

    public Book toDto(BookEntity bookEntity) {
        return new Book(
                bookEntity.getId(),
                bookEntity.getTitle(),
                authorMapper.toDto(bookEntity.getAuthorEntity()),
                genreMapper.toDto(bookEntity.getGenreEntity()),
                bookEntity.getYear(),
                bookEntity.getLocation()
        );
    }

    public BookEntity toEntity(
            Book bookDto
    ) {
        return new BookEntity(
                bookDto.title(),
                authorMapper.toEntity(bookDto.author()),
                genreMapper.toEntity(bookDto.genre()),
                bookDto.year(),
                bookDto.location()
        );
    }
}
