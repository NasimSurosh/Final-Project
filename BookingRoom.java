package finalProjectMainPackage;

import java.time.LocalDate;
import java.util.ArrayList;

public class BookingRoom {
  private UserDatabase guests;
  private ArrayList<RoomFeatures> roomFeatures;

  private int IdOfBooking;
  private String bookingType;
  private int numberOfGuests;
  private LocalDate checkInDate;
  private LocalDate checkOutDate;

  public BookingRoom() {
     this.guests = new UserDatabase();
     this.roomFeatures = new ArrayList<>();
    this.IdOfBooking = 1;
    this.bookingType = "reserved";
  }

  public void setNumberOfBooking(int bookingId) {
    this.IdOfBooking = bookingId;
  }

  public int getIdOfBooking() {
    return IdOfBooking;

  }

  public void setBookingType(String bookingType) {
    this.bookingType = bookingType;
  }

  public String getBookingType() {
    return bookingType;

  }

  public void setNumberOfGuests(int numberOfGuests) throws IllegalArgumentException{
    if(numberOfGuests <= 0) {
      throw new IllegalArgumentException("Number of guests should be greater than 0!");
    }
    this.numberOfGuests = numberOfGuests;
  }

  public int getNumberOfGuests() {
    return numberOfGuests;

  }

  public void setCheckInDate(LocalDate checkInDate) {
    this.checkInDate = checkInDate;
  }

  public LocalDate getCheckInDate() {
    return checkInDate;
  }

  public void setCheckOutDate(LocalDate checkOutDate) {
    if(checkOutDate.isBefore(checkInDate)) {
      throw new IllegalArgumentException("Check-out date musr be after check in date.");
    }
    this.checkOutDate = checkOutDate;
  }

  public LocalDate getCheckOutDate() {
    return checkOutDate;
  }

  public void setGuests(UserDatabase guests) {
    this.guests = guests;
  }

  public UserDatabase getGuests() {
    return guests;

  }
  public ArrayList<RoomFeatures> getRooms(){
    return roomFeatures;    
  }
  public int getRoomType() {
    int totalRooms = 0;
    for(RoomFeatures roomNumber : roomFeatures) {
      totalRooms = totalRooms+roomNumber.getRoomFeature().getRoomPricePerDay();
    }
    return totalRooms;
  }
  public void addRoom(String roomNumber) {
    roomFeatures.add(new RoomFeatures(roomNumber));
  }
  public void removeRoom(String roomNumber) {
    for(RoomFeatures room : roomFeatures) {
      if(room.getRoomNumber().equals(roomNumber)) {
        roomFeatures.remove(room);
      }
    }
    
  }

  @Override
  public String toString() {
    return "BookingRoom [guests=" + guests + ", roomFeatures=" + roomFeatures + ", IdOfBooking=" + IdOfBooking
        + ", bookingType=" + bookingType + ", numberOfGuests=" + numberOfGuests + ", checkInDate=" + checkInDate
        + ", checkOutDate=" + checkOutDate + "]";
  }
}
