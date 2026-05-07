package entities;

public class Event {
    private String name;
    private Integer availableSeats;
    private Integer maxTicketsPerUser;

    public Event(String name, Integer availableSeats, Integer maxTicketsPerUser) {
        this.name = name;
        this.availableSeats = availableSeats;
        this.maxTicketsPerUser = maxTicketsPerUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(Integer availableSeats) {
        this.availableSeats = availableSeats;
    }

    public Integer getMaxTicketsPerUser() {
        return maxTicketsPerUser;
    }

    public void setMaxTicketsPerUser(Integer maxTicketsPerUser) {
        this.maxTicketsPerUser = maxTicketsPerUser;
    }
    public void sellTickets ( Integer quantity){
        if (quantity <= 0 ){
            throw new DomainException("Tickets quantity must be higher than 0");
        }
        if (quantity > maxTicketsPerUser){
            throw new DomainException("Quantity exceeds the limit allowed per person");
        }
        if (quantity > availableSeats){
            throw new DomainException("Quantity exceeds the limit of remaining tickets");
        }
        this.availableSeats -= quantity;


    }

}
