package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.netology.repository.Repository;
import ru.netology.tickets.Ticket;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ManagerTestSamePrice {

    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);
    Ticket one = new Ticket(1, 11_934, "SVO", "MXP", 385);
    Ticket two = new Ticket(2, 11_934, "SVO", "MXP", 1885);
    Ticket three = new Ticket(3, 10_000, "DME", "BGY", 1395);
    Ticket four = new Ticket(4, 9_000, "DME", "MXP", 1320);
    Ticket five = new Ticket(5, 13_590, "SVO", "MXP", 400);
    Ticket six = new Ticket(7, 14_034, "VKO", "MXP", 1290);
    Ticket seven = new Ticket(8, 11_934, "SVO", "MXP", 390);


    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);

    }

    @Test
    void shouldFindAll() {

        Ticket[] expected = new Ticket[]{one, two, seven, five};
        Ticket[] actual = manager.findAll("SVO", "MXP");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }
}
