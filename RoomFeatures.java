package finalProjectMainPackage;

public class RoomFeatures {
  private RoomType roomType = new RoomType();

  private int roomID;
  private String roomNumber;
  private int bedRoomHas;
  private boolean hasPhone;
  private boolean hasInternet;
  private boolean hasAircondition;

  public RoomFeatures(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public void setRoomID(int roomID) {
    this.roomID = roomID;
  }

  public int getRoomID() {
    return roomID;
  }

  public void setRoomNumber(String roomNumber) {
    this.roomNumber = roomNumber;
  }

  public String getRoomNumber() {
    return roomNumber;
  }

  public void setBedRoomHas(int bedRoomHas) {
    this.bedRoomHas = bedRoomHas;
  }

  public int getBedRoomHas() {
    return bedRoomHas;
  }

  public void setHasPhone(boolean hasPhone) {
    this.hasPhone = hasPhone;
  }

  public boolean isHasPhone() {
    return hasPhone;
  }

  public void setHasInternet(boolean hasInternet) {
    this.hasInternet = hasInternet;
  }

  public boolean isHasInternet() {
    return hasInternet;
  }

  public void setHasAircondition(boolean hasAircondition) {
    this.hasAircondition = hasAircondition;
  }

  public boolean isHasAircondition() {
    return hasAircondition;
  }

  public void setRoomFeature(RoomType roomType) {
    this.roomType = roomType;
  }

  public RoomType getRoomFeature() {
    return roomType;
  }

}
