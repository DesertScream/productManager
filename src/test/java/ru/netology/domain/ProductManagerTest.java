package ru.netology.domain;

import org.junit.jupiter.api.Test;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class ProductManagerTest {

    private ProductRepository repository = new ProductRepository();
    private Manager manager = new Manager(repository);

    Product first = new Product(1, "11", 111);
    Product second = new Product(2, "22", 222);
    Product third = new Product(3, "33", 333);
    Product sixth = new Book(6, "QA", 666, "QA", "QAA");
    Product seventh = new Book(7, "QA1", 777, "QA1", "QAA1");
    Product eighth = new Smartphone(8, "Honor", 888, "Honor", "China");
    Product ninth = new Smartphone(9, "Huawei", 999, "Huawei", "China");

    @Test
    public void emptyRepository() {

        manager.add(first);
        manager.add(second);
        manager.add(third);
        manager.removeById(2);

        Product[] expected = {third, first};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void oneProductInRepository() {

        manager.add(first);

        manager.add(second);
        manager.add(third);
        manager.removeById(1);

        Product[] expected = {third, second};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void twoProductInRepository() {

        manager.add(first);
        manager.add(second);

        manager.add(third);
        manager.removeById(3);

        Product[] expected = {second, first};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void threeProductInRepository() {

        manager.add(first);
        manager.add(second);
        manager.add(third);

        manager.add(eighth);
        manager.removeById(8);

        Product[] expected = {third, second, first};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bookAndSmartphoneInRepository() {

        manager.add(ninth);
        manager.add(eighth);
        manager.add(seventh);
        manager.add(sixth);
        manager.removeById(9);

        Product[] expected = {sixth, seventh, eighth};
        Product[] actual = manager.getAll();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void searchBy() {
        manager.add(second);
        manager.add(ninth);

        Product[] products = manager.searchBy("22");
        manager.removeById(9);
        Product[] actual = manager.getAll();
        assertArrayEquals(products, actual);
    }
}
