package by.slava_borisov.bookslab7.mapper;

import by.slava_borisov.bookslab7.dto.Genre;
import by.slava_borisov.bookslab7.model.GenreEntity;
import org.springframework.stereotype.Component;

@Component
public class GenreMapper {

    public Genre toDto(
            GenreEntity genreEntity
    ) {
        return new Genre(
                genreEntity.getId(),
                genreEntity.getName()
        );
    }

    public GenreEntity toEntity(
            Genre genreDto
    ) {
        return new GenreEntity(
                genreDto.id(),
                genreDto.name()
        );
    }
}
