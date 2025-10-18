package by.slava_borisov.bookslab7.controllers;

import by.slava_borisov.bookslab7.dto.Book;
import by.slava_borisov.bookslab7.service.BookService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/books")
public class MainController {
    private final BookService bookService;
    private static final Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/add")
    public String showAddBookForm() {
        log.info("Called method showAddBookForm");
        return "add-book";
    }

    @PostMapping
    public String addBook(
            @RequestParam String title,
            @RequestParam String authorFirstName,
            @RequestParam String authorSecondName,
            @RequestParam String authorLastName,
            @RequestParam String genreType,
            @RequestParam int year,
            @RequestParam String location
    ) {
        log.info("Called method addBook");

        bookService.createBook(title, authorFirstName, authorSecondName, authorLastName, genreType, year, location);

        return "redirect:/books";
    }

    @GetMapping
    public String getAllBooks(
            Model model
    ) {
        log.info("Called method getAllBooks");

        List<Book> allBooks = bookService.getAllBooks();
        model.addAttribute("allBooks", allBooks);

        return "books";
    }

    @PostMapping("/delete/{id}")
    public String removeBook(
            @PathVariable Long id
    ) {
        log.info("Called method removeBook");

        bookService.deleteBookById(id);

        return "redirect:/books";
    }

}
