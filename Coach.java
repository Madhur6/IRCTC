class Coach {
    private String coachType;
    private int availableSeats;

    public Coach(String coachType, int availableSeats) {
        this.coachType = coachType;
        this.availableSeats = availableSeats;
    }

    public String getCoachType() {
        return coachType;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
        }
    }

    @Override
    public String toString() {
        return "Coach Type: " + coachType + ", Available Seats: " + availableSeats;
    }
}
