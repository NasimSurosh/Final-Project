package finalProjectMainPackage;

public class GuestOrder {
  public int orderId;
  public int bookingID;
  public String foodItem;
  public int foodPrice;
  public int foodQuantity;
  public int totalPrice;

  public GuestOrder(int orderId, int bookingID, String foodItem, int foodPrice, int foodQuantity) {
    this.orderId = orderId;
    this.bookingID = bookingID;
    this.foodItem = foodItem;
    this.foodPrice = foodPrice;
    this.foodQuantity = foodQuantity;
  }

  public int getOrderId() {
    return orderId;
  }

  public int getBookingID() {
    return bookingID;
  }

  public String getFoodItem() {
    return foodItem;
  }

  public int getFoodPrice() {
    return foodPrice;
  }

  public int getFoodQuantity() {
    return foodQuantity;
  }

  public int getTotalPrice() {
    return totalPrice;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public void setBookingID(int bookingID) {
    this.bookingID = bookingID;
  }

  public void setFoodItem(String foodItem) {
    this.foodItem = foodItem;
  }

  public void setFoodPrice(int foodPrice) {
    this.foodPrice = foodPrice;
  }

  public void setFoodQuantity(int foodQuantity) {
    this.foodQuantity = foodQuantity;
  }

  public void setTotalPrice(int totalPrice) {
    this.totalPrice = totalPrice;
  }

}
