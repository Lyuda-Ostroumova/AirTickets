package ru.netology.manager;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import ru.netology.repository.Repository;
import ru.netology.tickets.Ticket;

import static org.junit.jupiter.api.Assertions.*;

class ManagerTest {

    private Repository repository = new Repository();
    private Manager manager = new Manager(repository);
    Ticket one = new Ticket(1, 11_934, "SVO", "BGY", 385);
    Ticket two = new Ticket(2, 9_179, "DME", "BGY", 1885);
    Ticket three = new Ticket(3, 10_000, "DME", "BGY", 1395);
    Ticket four = new Ticket(4, 9_000, "DME", "MXP", 1320);
    Ticket five = new Ticket(5, 29_596, "SVO", "MXP", 400);
    Ticket six = new Ticket(6, 12_923, "VKO", "BGY", 1005);
    Ticket seven = new Ticket(7, 14_034, "VKO", "MXP", 1290);
    Ticket eight = new Ticket(8, 13_590, "SVO", "MXP", 390);
    Ticket nine = new Ticket(9, 37_000, "SVO", "MXP", 230);


    @BeforeEach
    public void setUp() {
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);
        manager.add(six);
        manager.add(seven);
        manager.add(eight);
        manager.add(nine);
    }

    @Test
    void shouldFindAll() {

        Ticket[] expected = new Ticket[]{two, three};
        Ticket[] actual = manager.findAll("DME", "BGY");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAllDifferentAirport() {

        Ticket[] expected = new Ticket[]{eight, five, nine};
        Ticket[] actual = manager.findAll("SVO", "MXP");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAllNoSuchFrom() {

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("EGO", "BGY");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAllNoSuchTo() {

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("SVO", "LED");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAllNoSuchToAndFrom() {

        Ticket[] expected = new Ticket[0];
        Ticket[] actual = manager.findAll("MOW", "LED");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAllWithoutFrom() {

        Ticket[] expected = new Ticket[] {four, eight, seven, five, nine};
        Ticket[] actual = manager.findAll("","MXP");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAllWithoutTo() {

        Ticket[] expected = new Ticket[] {one, eight, five, nine};
        Ticket[] actual = manager.findAll("SVO","");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

    @Test
    void shouldFindAllWithoutToWithoutFrom() {

        Ticket[] expected = new Ticket[] {four, two, three, one, six, eight, seven, five, nine};
        Ticket[] actual = manager.findAll("","");

        Arrays.sort(actual);

        assertArrayEquals(expected, actual);

    }

}