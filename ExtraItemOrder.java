package finalProjectMainPackage;

public class ExtraItemOrder {
  private HotelItem orderItem = new HotelItem();
  private int customerID;
  private int orderID;
  private String dateTime;
  private int orderQuantity;

  public HotelItem getOrderItem() {
    return orderItem;
  }

  public int getCustomerID() {
    return customerID;
  }

  public int getOrderID() {
    return orderID;
  }

  public String getDateTime() {
    return dateTime;
  }

  public int getOrderQuantity() {
    return orderQuantity;
  }

  public void setOrderItem(HotelItem orderItem) {
    this.orderItem = orderItem;
  }

  public void setCustomerID(int customerID) {
    this.customerID = customerID;
  }

  public void setOrderID(int orderID) {
    this.orderID = orderID;
  }

  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
  }

  public void setOrderQuantity(int orderQuantity) {
    this.orderQuantity = orderQuantity;
  }

  public double totalPrice() {
    return orderItem.getItemPrice() * orderQuantity;
  }

}
