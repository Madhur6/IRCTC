import java.util.*;

class Train {
    private String trainNumber;
    private String source;
    private String destination;
    private String departureTime;
    private List<Coach> coaches; 

    public Train(String trainNumber, String source, String destination, String departureTime, List<Coach> coaches) {
        this.trainNumber = trainNumber;
        this.source = source;
        this.destination = destination;
        this.departureTime = departureTime;
        this.coaches = coaches;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public String getDepartureTime() {
        return departureTime;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void bookSeat(String coachType) {
        for (Coach coach : coaches) {
            if (coach.getCoachType().equalsIgnoreCase(coachType)) {
                coach.bookSeat();
                break;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Train Number: ").append(trainNumber)
          .append(", Source: ").append(source)
          .append(", Destination: ").append(destination)
          .append(", Departure Time: ").append(departureTime)
          .append(", Coaches: \n");
        
        for (Coach coach : coaches) {
            sb.append("  ").append(coach).append("\n");
        }
        
        return sb.toString();
    }
}
