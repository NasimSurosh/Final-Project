package finalProjectMainPackage;

import java.time.LocalDate;
import java.time.Month;
import java.util.Scanner;
import java.util.Set;

interface HotelSystem {
  void runHotelSystem();
}

public class Main {

  public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    HotelSystem hotelManagementSystem = () -> {

      UserDatabase database = new UserDatabase();
      BookingRoom bookRoom = new BookingRoom();
      HotelPayment payment = new HotelPayment(bookRoom);
      HotelItem hotelItem = new HotelItem();
      HotelFood hotelFood = new HotelFood();
      RoomType roomType = new RoomType();
      ExtraItemOrder extraItemOrder = new ExtraItemOrder();

      int choice;

      do {
        System.out.println("Enter your choice from below");
        System.out.println("1. To registeration");
        System.out.println("2. To book room");
        System.out.println("3. To add a room");
        System.out.println("4. To add extra item order");
        System.out.println("5. To set hotel food");
        System.out.println("6. To make payment");
        System.out.println("7. To view booking details ");
        System.out.println("8. To exit");
        choice = scan.nextInt();
        switch (choice) {
        case 1:
          handleUserRegistration(database, scan);
          break;
        case 2:
          handleRoomBooking(bookRoom, database, scan);
          break;
        case 3:
          handleRoomAddition(roomType, scan);
          break;
        case 4:
          handleExtraItemOrder(extraItemOrder, hotelItem, hotelFood, scan);
          break;
        case 5:
          handleHotelFood(hotelFood, scan);
          break;
        case 6:
          System.out.println("Enter your ID");
          extraItemOrder.setCustomerID(scan.nextInt());
          System.out.println("Enter Order ID");
          extraItemOrder.setOrderID(scan.nextInt());
          System.out.println("Enter order quantity");
          extraItemOrder.setOrderQuantity(scan.nextInt());
          extraItemOrder.getOrderItem();
          break;
        case 7:
          System.out.println("Print total bill");
          payment.calculateTotal();
          break;
        case 8:
          System.out.println("Exiting from system");
          System.exit(0);
        default:
          System.out.println("Invalid choice. Please try again.");
          break;
        }
      } while (choice != 8);
      scan.close();
    };

    hotelManagementSystem.runHotelSystem();
  }

  private static void handleUserRegistration(UserDatabase database, Scanner scan) {
    int choice;
    do {
      System.out.println("\nUser Registration System Menu:");
      System.out.println("1. Register a new user");
      System.out.println("2. View user details by username");
      System.out.println("3. View all registered users");
      System.out.println("4. Remove a user account");
      System.out.println("5. Exit");
      System.out.print("Enter your choice: ");
      choice = scan.nextInt();
      scan.nextLine();
      switch (choice) {
      case 1:
        System.out.print("Enter username: ");
        String username = scan.nextLine();
        System.out.print("Enter password: ");
        String password = scan.nextLine();
        System.out.print("Enter email: ");
        String email = scan.nextLine();
        System.out.println("Enter your address");
        String guestAddress = scan.nextLine();
        System.out.println("Enter phone number:");
        long phoneNumber = scan.nextLong();
        System.out.println("Enter your guest type:");
        String guestType = scan.nextLine();
        scan.nextLine();
        UserInformation user = new UserInformation(username, password, email, phoneNumber, guestType, guestAddress);
        database.addUser(user);
        System.out.println("User registered successfully.");
        System.out.println(database);
        break;
      case 2:
        System.out.print("Enter username to view details: ");
        String viewUsername = scan.nextLine();
        UserInformation viewUser = database.getUserByUsername(viewUsername);
        if (viewUser != null) {
          System.out.println(viewUser);
        } else {
          System.out.println("User not found.");
        }
        break;
      case 3:
        // read data from registration.txt and assign it to database.
        Set<UserInformation> allUsers = database.getAllUsers();
        if (!allUsers.isEmpty()) {
          System.out.println("All Registered Users:");
          for (UserInformation u : allUsers) {
            System.out.println(u);
          }
        } else {
          System.out.println("No users registered yet.");
        }
        break;
      case 4:
        System.out.print("Enter username to remove: ");
        String removeUsername = scan.nextLine();
        database.removeUser(removeUsername);
        System.out.println("User removed successfully.");
        break;
      case 5:
        System.out.println("Thank you for using the User Registration System!");
        database.saveToFile("/home/dci-student/eclipse-workspace/FinalProject/src/registration.txt");
        System.exit(0);
        break;
      default:
        System.out.println("Invalid choice. Please enter a valid option.");
        break;
      }
    } while (choice != 5);

  }

  private static void handleRoomBooking(BookingRoom bookRoom, UserDatabase database, Scanner scan) {
    System.out.println("please enter your book type:");
    bookRoom.setBookingType(scan.nextLine());
    System.out.println("Enter your check in date from now");
    bookRoom.setCheckInDate(LocalDate.of(2023, Month.DECEMBER, 23));
  
    System.out.println("Enter checkout date from now");
    bookRoom.setCheckOutDate(LocalDate.of(2023, Month.DECEMBER, 25));
    
    System.out.println("Enter number of guests");
    bookRoom.setNumberOfGuests(scan.nextInt());
    scan.nextLine();
    bookRoom.setGuests(database);
  }

  private static void handleRoomAddition(RoomType roomType, Scanner scan) {
    System.out.println("Enter room type");
    roomType.setRoomType(scan.nextLine());
    System.out.println("Enter room price");
    roomType.setRoomPricePerDay(scan.nextInt());
  }

  private static void handleExtraItemOrder(ExtraItemOrder extraItemOrder, HotelItem hotelItem, HotelFood hotelFood,
      Scanner scan) {
    System.out.println("Write item discription");
    hotelItem.setItemDescription(scan.nextLine());
    System.out.println("Add item ID");
    hotelItem.setItemID(scan.nextInt());
    System.out.println("Write item name");
    hotelItem.setItemName(scan.nextLine());
    System.out.println("Write item price");
    hotelItem.setItemPrice(scan.nextDouble());
  }

  private static void handleHotelFood(HotelFood hotelFood, Scanner scan) {
    System.out.println("Write hotel food name");
    hotelFood.setFoodName(scan.nextLine());
    System.out.println("Enter food ID");
    hotelFood.setFoodID(scan.nextInt());
    System.out.println("Enter food price");
    hotelFood.setFoodPrice(scan.nextDouble());
  }

}
