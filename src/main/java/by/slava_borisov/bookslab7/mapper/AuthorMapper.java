package by.slava_borisov.bookslab7.mapper;

import by.slava_borisov.bookslab7.dto.Author;
import by.slava_borisov.bookslab7.model.AuthorEntity;
import org.springframework.stereotype.Component;

@Component
public class AuthorMapper {

    public Author toDto(
            AuthorEntity authorEntity
    ) {
        return new Author(
                authorEntity.getId(),
                authorEntity.getFirstName(),
                authorEntity.getMiddleName(),
                authorEntity.getLastName()
        );
    }

    public AuthorEntity toEntity(
            Author authorDto
    ) {
        return  new AuthorEntity(
                authorDto.id(),
                authorDto.firstName(),
                authorDto.middleName(),
                authorDto.lastName()
        );
    }
}
