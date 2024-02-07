package finalProjectMainPackage;

import java.util.ArrayList;

interface CalculateTotal{
  double calculateTotal();
}

public class HotelPayment implements CalculateTotal{

  private BookingRoom booking = new BookingRoom();
  ArrayList<ExtraItemOrder> extraOrder = new ArrayList<>();
  int totalPrice;
  int daysInhotelStayed;
  private String paymentDate;
  private String paymentMethod;
  private boolean hasDiscount;
  private double discount;
  double totalAmount;

  public HotelPayment(BookingRoom booking) {
      this.booking = booking;
  }

  public BookingRoom getBookingRoom() {
      return booking;
  }

  public void setBookingRoom(BookingRoom booking) {
      this.booking = booking;
  }

  public String getPaymentDate() {
      return paymentDate;
  }

  public void setPaymentDate(String paymentDate) {

      this.paymentDate = paymentDate;
  }

  public void setPaymentMethod(String paymentMethod) {
      this.paymentMethod = paymentMethod;
  }

  public String getPaymentMethod() {
      return paymentMethod;
  }

  public void setHasDiscount(boolean hasDiscount) {
      this.hasDiscount = hasDiscount;
  }

  public boolean isHasDiscount() {
      return hasDiscount;
  }

  public void setDiscount(double discount) {
      this.discount = discount;
  }

  public double getDiscount() {
      return discount;
  }

  public double calculateTotal() {
      double totalAmountOfBill = 0;
      for (ExtraItemOrder order : extraOrder) {
          totalAmountOfBill = totalAmountOfBill + order.getOrderQuantity() * order.getOrderItem().getItemPrice();
      }
      totalAmount = totalAmountOfBill + totalPrice;
      return totalAmount;
  }

  @Override
  public String toString() {
      return "HotelPayment{" +
              "booking=" + booking +
              ", extraOrder=" + extraOrder +
              ", totalPrice=" + totalPrice +
              ", daysInhotelStayed=" + daysInhotelStayed +
              ", paymentDate='" + paymentDate + '\'' +
              ", paymentMethod='" + paymentMethod + '\'' +
              ", hasDiscount=" + hasDiscount +
              ", discount=" + discount +
              ", totalAmount=" + totalAmount +
              '}';
  }
}

