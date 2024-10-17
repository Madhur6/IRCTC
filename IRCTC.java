import java.util.*;

public class IRCTC {
    private static HashMap<String, String[]> users = new HashMap<>();

    
    public static String defaultSortPreference = "time"; // Default sort by time


    // Predefined admin user
    public static Admin adminUser = new Admin("admin", "admin123");

    public static List<Train> availableTrains = new ArrayList<>();

    private static Scanner scanner = new Scanner(System.in);


    // Predefined set of trains
    // static {
    //     availableTrains.add(new Train("101", "City A", "City B", "10:00 AM", 50));
    //     availableTrains.add(new Train("102", "City A", "City C", "12:00 PM", 30));
    //     availableTrains.add(new Train("103", "City B", "City D", "02:00 PM", 25));
    //     availableTrains.add(new Train("104", "City A", "City B", "04:00 PM", 0)); 
    // }

    static {
        List<Coach> coachesTrain1 = new ArrayList<>();
        coachesTrain1.add(new Coach("Sleeper", 50));
        coachesTrain1.add(new Coach("AC", 30));

        List<Coach> coachesTrain2 = new ArrayList<>();
        coachesTrain2.add(new Coach("Sleeper", 30));
        coachesTrain2.add(new Coach("AC", 20));

        List<Coach> coachesTrain3 = new ArrayList<>();
        coachesTrain3.add(new Coach("Sleeper", 25));
        coachesTrain3.add(new Coach("AC", 10));

        List<Coach> coachesTrain4 = new ArrayList<>();
        coachesTrain4.add(new Coach("Sleeper", 0)); 
        coachesTrain4.add(new Coach("AC", 15));

        availableTrains.add(new Train("101", "City A", "City B", "10:00 AM", coachesTrain1));
        availableTrains.add(new Train("102", "City A", "City C", "12:00 PM", coachesTrain2));
        availableTrains.add(new Train("103", "City B", "City D", "02:00 PM", coachesTrain3));
        availableTrains.add(new Train("104", "City A", "City B", "04:00 PM", coachesTrain4));
    }



    public static List<Booking> bookingHistory = new ArrayList<>();

    // Adding a dummy booking history
    static {
        bookingHistory.add(new Booking("101", "2024-10-17", "City A", "City B"));
        bookingHistory.add(new Booking("102", "2024-10-18", "City A", "City C"));
    }



    public static void main(String[] args) {
        while (true) {
            System.out.println("Welcome to the Train Reservation System");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Please choose an option: ");
            int option = scanner.nextInt();scanner.nextLine();

            switch (option) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting the system. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid option, please try again.");
            }
        }
    }

    

    // CANCELLING THE BOOKING...
    public static void cancelBooking() {
        System.out.print("Enter Train Number to cancel booking: ");
        String trainNumber = scanner.nextLine();
        boolean found = false;

        for (int i = 0; i < bookingHistory.size(); i++) {
            if (bookingHistory.get(i).getTrainNumber().equals(trainNumber)) {
                bookingHistory.remove(i);
                System.out.println("Booking for Train Number " + trainNumber + " has been cancelled.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found with the specified Train Number.");
        }
    }






    // View Booking Details...
    public static void viewBookingDetails() {
        System.out.print("Enter Train Number to view details: ");
        String trainNumber = scanner.nextLine();
        boolean found = false;

        for (Booking booking : bookingHistory) {
            if (booking.getTrainNumber().equals(trainNumber)) {
                System.out.println("Booking Details: " + booking);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("No booking found with the specified Train Number.");
        }
    }




    // VIEW ALL BOOKINGS
    public static void viewAllBookings() {
        System.out.println("All Bookings:");
        for (Booking booking : bookingHistory) {
            System.out.println(booking);
        }
    }




    // ADMIN LOGIN...
    public static boolean adminLogin() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Admin Username: ");
        String username = scanner.nextLine();
        System.out.print("Enter Admin Password: ");
        String password = scanner.nextLine();

        return username.equals(adminUser.getUsername()) && password.equals(adminUser.getPassword());
    }



    // Configure System Setting...
    public static void configureSystemSettings() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Configure System Settings:");
        System.out.println("1. Sort by Train Number");
        System.out.println("2. Sort by Departure Time");
        int option = scanner.nextInt();

        if (option == 1) {
            defaultSortPreference = "number";
            System.out.println("Default sorting set to Train Number.");
        } else if (option == 2) {
            defaultSortPreference = "time";
            System.out.println("Default sorting set to Departure Time.");
        } else {
            System.out.println("Invalid option.");
        }
    }


    // BOOKING TICKETS
    public static void bookTicket() {
        System.out.println("Enter the Train Number to book: ");
        String trainNumber = scanner.nextLine();

        boolean trainFound = false;
        for (Train train : availableTrains) {
            if (train.getTrainNumber().equals(trainNumber)) {
                trainFound = true;
                System.out.print("Enter Coach Type (e.g., Sleeper, AC): ");
                String coachType = scanner.nextLine();

                boolean seatBooked = false;
                for (Coach coach : train.getCoaches()) {
                    if (coach.getCoachType().equalsIgnoreCase(coachType)) {
                        if (coach.getAvailableSeats() > 0) {
                            train.bookSeat(coachType);
                            System.out.println("Booking successful! Your seat has been confirmed on train " + trainNumber);
                            seatBooked = true;
                            break;
                        } else {
                            System.out.println("Sorry, no seats are available in " + coachType + " coach.");
                            seatBooked = true;
                            break;
                        }
                    }
                }
                if (!seatBooked) {
                    System.out.println("Invalid Coach Type.");
                }
                break;
            }
        }

        if (!trainFound) {
            System.out.println("Invalid Train Number.");
        }
    }




    // public static void bookTicket() {
    //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Enter the Train Number to book: ");
    //     String trainNumber = scanner.nextLine();

    //     boolean trainFound = false;
    //     for (Train train : availableTrains) {
    //         if (train.getTrainNumber().equals(trainNumber)) {
    //             trainFound = true;
    //             if (train.getAvailableSeats() > 0) {
    //                 train.bookSeat();
    //                 System.out.println("Booking successful! Your seat has been confirmed on train " + trainNumber);
    //             } else {
    //                 System.out.println("Sorry, no seats are available on this train.");
    //             }
    //             break;
    //         }
    //     }

    //     if (!trainFound) {
    //         System.out.println("Invalid Train Number.");
    //     }
    // }


    // SEARCH BOOKING HISTORY
    public static void searchBookingHistory() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Search Booking History by:");
        System.out.println("1. Date");
        System.out.println("2. Train Number");
        System.out.println("3. Destination");
        int option = scanner.nextInt();scanner.nextLine();

        switch (option) {
            case 1:
                System.out.print("Enter Date (YYYY-MM-DD): ");
                String date = scanner.nextLine();
                for (Booking booking : bookingHistory) {
                    if (booking.getDate().equals(date)) {
                        System.out.println(booking);
                    }
                }
                break;
            case 2:
                System.out.print("Enter Train Number: ");
                String trainNumber = scanner.nextLine();
                for (Booking booking : bookingHistory) {
                    if (booking.getTrainNumber().equals(trainNumber)) {
                        System.out.println(booking);
                    }
                }
                break;
            case 3:
                System.out.print("Enter Destination: ");
                String destination = scanner.nextLine();
                for (Booking booking : bookingHistory) {
                    if (booking.getDestination().equalsIgnoreCase(destination)) {
                        System.out.println(booking);
                    }
                }
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    // METHOD TO HANDLE THE SORTING...
    public static void sortTrainsByDepartureTime() {
        Collections.sort(availableTrains, new Comparator<Train>() {
            @Override
            public int compare(Train t1, Train t2) {
                return t1.getDepartureTime().compareTo(t2.getDepartureTime());
            }
        });

        System.out.println("Trains sorted by departure time:");
        for (Train train : availableTrains) {
            System.out.println(train);
        }
    }



    // SEARCH TRAINS
    public static void searchTrains() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source: ");
        String source = scanner.nextLine();
        System.out.print("Enter destination: ");
        String destination = scanner.nextLine();

        // Display available trains for the specified route
        boolean found = false;
        for (Train train : availableTrains) {
            if (train.getSource().equalsIgnoreCase(source) && train.getDestination().equalsIgnoreCase(destination)) {
                System.out.println(train);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No trains found for the specified route.");
        }
    }


    // Function to handle user registration
    public static void registerUser() {
        System.out.println("Register a New User");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        
        if (users.containsKey(email)) {
            System.out.println("This email is already registered. Please login.");
            return;
        }

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        users.put(email, new String[]{password, name});
        System.out.println("Registration successful! You can now login.");
    }

    // Function to handle user login
    public static void loginUser() {
        System.out.println("Login to Your Account");
        System.out.print("Enter your email: ");
        String email = scanner.nextLine();
        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        if (users.containsKey(email) && users.get(email)[0].equals(password)) {
            String name = users.get(email)[1];
            System.out.println("Login successful! Welcome, " + name);

            showMainMenu();
        } else {
            System.out.println("Invalid email or password. Please try again.");
        }
    }

    // Function to show main menu after login
    public static void showMainMenu() {
        while (true) {
            System.out.println("Main Menu:");
            System.out.println("1. Search for Trains");
            System.out.println("2. Book a Ticket");
            System.out.println("3. View Booking History");
            System.out.println("4. Sort Trains");
            System.out.println("5. Configure System Settings");
            System.out.println("6. Admin Login");
            System.out.println("7. View Booking Details");
            System.out.println("8. Cancel a Booking");
            System.out.println("9. Logout");


            int option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (option) {
                case 1:
                    searchTrains();
                    break;
                case 2:
                    bookTicket();
                    break;
                case 3:
                    searchBookingHistory();
                    break;
                case 4:
                    sortTrainsByDepartureTime();
                    break;
                case 5:
                    configureSystemSettings();
                    break;
                case 6:
                    if (adminLogin()) {
                        viewAllBookings();
                    } else {
                        System.out.println("Invalid Admin Credentials.");
                    }
                    break;
                case 7:
                    viewBookingDetails();
                    break;
                case 8:
                    cancelBooking();
                    break;
                case 9:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option.");
            }
        }
    }
}
