class Booking {
    private String trainNumber;
    private String date;
    private String source;
    private String destination;

    public Booking(String trainNumber, String date, String source, String destination) {
        this.trainNumber = trainNumber;
        this.date = date;
        this.source = source;
        this.destination = destination;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getDate() {
        return date;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    @Override
    public String toString() {
        return "Train Number: " + trainNumber + ", Date: " + date + ", Source: " + source + ", Destination: " + destination;
    }
}


