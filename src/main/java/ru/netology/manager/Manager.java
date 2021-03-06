package ru.netology.manager;

import ru.netology.tickets.Ticket;
import ru.netology.repository.Repository;

import java.util.Arrays;

public class Manager {

    private Repository repository;

    public Manager(Repository repository) {
        this.repository = repository;
    }

    public void add(Ticket ticket) {
        repository.add(ticket);
    }

    public Ticket[] findAll(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repository.getAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                System.arraycopy(result, 0, tmp, 0, result.length);
                tmp[tmp.length - 1] = ticket;
                result = tmp;
                Arrays.sort(result);
            }

        }
        return result;
    }

    public boolean matches(Ticket ticket, String searchFrom, String searchTo) {
        if (ticket.getFrom().contains(searchFrom) && ticket.getTo().contains(searchTo)) {
            return true;
        }
        return false;
    }

}