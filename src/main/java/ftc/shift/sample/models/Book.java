package ftc.shift.sample.models;

import java.util.List;

public class Book {
    /**
     * Уникальный идентификатор книги
     */
    private String id;

    /**
     * Название книги
     */
    private String name;

    /**
     * Автор
     */
    private String author;

    /**
     * Количество страниц
     */
    private Integer pages;

    /**
     * Список жанров
     */
    private List<String> genre;

    public Book() {
    }

    public Book(String id, String name, String author, Integer pages, List<String> genre) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.pages = pages;
        this.genre = genre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public List<String> getGenre() {
        return genre;
    }

    public void setGenre(List<String> genre) {
        this.genre = genre;
    }
}
