package ftc.shift.sample.api;


import ftc.shift.sample.models.Book;
import ftc.shift.sample.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class BooksController {
    private static final String BOOKS_PATH = "/api/v001/books";
    private BookService service;

    @Autowired
    public BooksController(BookService service) {
        this.service = service;
    }

    /**
     * Добавление новой книги
     *
     * @param userId - Идентификатор пользователя
     * @param book   - Данные для новой книги (Название, автор, количество страниц, жанры)
     * @return Сохранённая книга с установленным {@link Book#getId()}
     */
    @PostMapping(BOOKS_PATH)
    public ResponseEntity<Book> createBook(
            @RequestHeader("userId") String userId,
            @RequestBody Book book) {
        Book result = service.createBook(userId, book);
        return ResponseEntity.ok(result);
    }

    /**
     * Получение книги с указанным идентификатором
     *
     * @param userId - Идентификатор пользователя
     * @param bookId - Идентификатор книги
     */
    @GetMapping(BOOKS_PATH + "/{bookId}")
    public ResponseEntity<Book> readBook(
            @RequestHeader("userId") String userId,
            @PathVariable String bookId) {
        Book book = service.provideBook(userId, bookId);
        return ResponseEntity.ok(book);
    }

    /**
     * Обновление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param bookId - Идентификатор книги, которую необходимо обновить
     * @param book   - Новые данные для книги (Название, автор, количество страниц, жанры)
     */
    @PatchMapping(BOOKS_PATH + "/{bookId}")
    public ResponseEntity<Book> updateBook(
            @RequestHeader("userId") String userId,
            @PathVariable String bookId,
            @RequestBody Book book) {
        Book updatedBook = service.updateBook(userId, bookId, book);
        return ResponseEntity.ok(updatedBook);
    }

    /**
     * Удаление существующей книги
     *
     * @param userId - Идентификатор пользователя
     * @param bookId - Идентификатор книги, которую необходимо удалить
     */
    @DeleteMapping(BOOKS_PATH + "/{bookId}")
    public ResponseEntity<?> deleteBook(
            @RequestHeader("userId") String userId,
            @PathVariable String bookId) {
        service.deleteBook(userId, bookId);
        return ResponseEntity.ok().build();
    }

    /**
     * Получение всех книг пользователя
     *
     * @param userId - Идентификатор пользователя
     */
    @GetMapping(BOOKS_PATH)
    public ResponseEntity<Collection<Book>> listBooks(
            @RequestHeader("userId") String userId) {
        Collection<Book> books = service.provideBooks(userId);
        return ResponseEntity.ok(books);
    }
}