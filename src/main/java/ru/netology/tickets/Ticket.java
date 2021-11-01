package ru.netology.tickets;

public class Ticket implements Comparable<Ticket> {

    private int id;
    private int price;
    private String from;
    private String to;
    private int travelTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public int getTravelTime() {
        return travelTime;
    }

    public void setTravelTime(int travelTime) {
        this.travelTime = travelTime;
    }

    public Ticket() {
    }

    public Ticket(int id, int price, String from, String to, int travelTime) {
        this.id = id;
        this.price = price;
        this.from = from;
        this.to = to;
        this.travelTime = travelTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", price=" + price +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", travelTime=" + travelTime +
                '}';
    }

    @Override
    public int compareTo(Ticket o) {
        Ticket p = (Ticket) o;
        return this.price - p.price;
    }
}
