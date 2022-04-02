package ru.netology.repository;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductRepositoryTest {

    private ProductRepository repository = new ProductRepository();

    Product first = new Product(1, "11", 111);
    Product second = new Product(2, "22", 222);
    Product third = new Product(3, "33", 333);
    Product sixth = new Book(6, "QA", 666, "QA", "QAA");
    Product seventh = new Book(7, "QA1", 777, "QA1", "QAA1");
    Product eighth = new Smartphone(8, "Honor", 888, "Honor", "China");
    Product ninth = new Smartphone(9, "Huawei", 999, "Huawei", "China");

    @Test
    public void emptyRepository() {

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.removeById(2);

        Product[] expected = {first, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneProductInRepository() {

        repository.add(first);
        repository.add(second);
        repository.add(third);
        repository.removeById(1);

        Product[] expected = {second, third};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoProductInRepository() {

        repository.add(first);
        repository.add(second);

        repository.add(third);
        repository.removeById(3);

        Product[] expected = {first, second};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeProductInRepository() {

        repository.add(first);
        repository.add(second);
        repository.add(third);

        repository.add(eighth);
        repository.removeById(8);

        Product[] expected = {first, second, third,};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bookAndSmartphoneInRepository() {
        repository.add(ninth);
        repository.add(eighth);
        repository.add(seventh);
        repository.add(sixth);

        repository.removeById(9);

        Product[] expected = {eighth, seventh, sixth};
        Product[] actual = repository.findAll();
        assertArrayEquals(expected, actual);


    }
}