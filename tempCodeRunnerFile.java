// class Train {
//     private String trainNumber;
//     private String source;
//     private String destination;
//     private String departureTime;
//     private int availableSeats;

//     public Train(String trainNumber, String source, String destination, String departureTime, int availableSeats) {
//         this.trainNumber = trainNumber;
//         this.source = source;
//         this.destination = destination;
//         this.departureTime = departureTime;
//         this.availableSeats = availableSeats;
//     }

//     public String getTrainNumber() {
//         return trainNumber;
//     }

//     public String getSource() {
//         return source;
//     }

//     public String getDestination() {
//         return destination;
//     }

//     public String getDepartureTime() {
//         return departureTime;
//     }

//     public int getAvailableSeats() {
//         return availableSeats;
//     }

//     public void bookSeat() {
//         if (availableSeats > 0) {
//             availableSeats--;
//         }
//     }

//     @Override
//     public String toString() {
//         return "Train Number: " + trainNumber + ", Source: " + source + ", Destination: " + destination +
//                ", Departure Time: " + departureTime + ", Available Seats: " + availableSeats;
//     }
// }
