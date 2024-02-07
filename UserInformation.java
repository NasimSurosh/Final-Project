package finalProjectMainPackage;

public class UserInformation {
  private String username;
  private String password;
  private static int id = 000001;
  private int guestID;
  private String guestType;
  private String guestAddress;
  private String email;
  private long phoneNumber;

  public UserInformation(String username, String password, String email, long phoneNumber, String guestType,
      String guestAddress) {
    this.username = username;
    this.guestType = guestType;
    this.guestAddress = guestAddress;
    this.guestID = id;
    id = id + 1;
    this.password = password;
    this.email = email;
    this.phoneNumber = phoneNumber;

  }

  public String getGuestName() {
    return username;
  }

  public String getPassword() {
    if (password.length() >= 8 && password.matches(".*[A-Z].*") && password.matches(".*\\d.*")) {
      System.out.println("Password accepted!");
      return password;
    } else if (!(password.length() >= 8) && !password.matches(".*[A-Z].*") && !password.matches(".*\\d.*")) {
      System.out.println("Password must contain a capital litter and one digit.");
    }
    return "Try again";

  }

  public int getGuestID() {
    guestID++;
    return guestID;
  }

  public String getGuestType() {
    return guestType;
  }

  public String getGuestAddress() {
    return guestAddress;
  }

  public String getGuestEmailAddress() {
    return email;
  }

  public long getGuestPhoneNumber() throws IllegalArgumentException {
    if (phoneNumber < 10L) {
      throw new IllegalArgumentException("Phone number connot be less than 10 digit!");
    }
    return phoneNumber;
  }

  @Override
  public String toString() {
    return "UserInformation [username=" + username + ", password=" + password + ", guestID=" + guestID + ", guestType="
        + guestType + ", guestAddress=" + guestAddress + ", email=" + email + ", phoneNumber=" + phoneNumber + "]";
  }

}
