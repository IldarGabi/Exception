package ru.netology.repository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryTest {
    ProductRepository repository = new ProductRepository();
    Product book1 = new Book(1, "One", 100, "She", 4, 1911);
    Product book2 = new Book(2, "Two", 100, "He", 4, 1912);
    Product book3 = new Book(3, "Three", 100, "Man", 4, 1913);

    @BeforeEach
    void setUp() {
        repository.save(book1);
        repository.save(book2);
        repository.save(book3);
    }

    @Test
    void removeById() {
        repository.removeById(1);
        Product[] expected = new Product[]{book2, book3};
        Product[] actual = repository.findAll();
        assertArrayEquals(actual, expected);
    }

    @Test
    void NotFoundException(){
        assertThrows(NotFoundException.class, () -> repository.removeById(4));
    }
}