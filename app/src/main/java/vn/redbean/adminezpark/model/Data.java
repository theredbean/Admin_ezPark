package vn.redbean.adminezpark.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("OrderID")
    @Expose
    private Integer orderID;
    @SerializedName("QRCode")
    @Expose
    private String qRCode;
    @SerializedName("CustomerID")
    @Expose
    private Integer customerID;
    @SerializedName("CustomerName")
    @Expose
    private String customerName;
    @SerializedName("CustomerEmail")
    @Expose
    private String customerEmail;
    @SerializedName("CustomerPhoneNumber")
    @Expose
    private String customerPhoneNumber;
    @SerializedName("CustomerCarNumber")
    @Expose
    private String customerCarNumber;
    @SerializedName("ParkingID")
    @Expose
    private Integer parkingID;
    @SerializedName("ParkingName")
    @Expose
    private String parkingName;
    @SerializedName("ParkingEmail")
    @Expose
    private String parkingEmail;
    @SerializedName("ParkingPhoneNumber")
    @Expose
    private String parkingPhoneNumber;
    @SerializedName("ParkingAddress")
    @Expose
    private String parkingAddress;
    @SerializedName("DateCreate")
    @Expose
    private String dateCreate;
    @SerializedName("Status")
    @Expose
    private String status;

    public Data(Integer orderID, String qRCode, Integer customerID, String customerName, String customerEmail, String customerPhoneNumber, String customerCarNumber, Integer parkingID, String parkingName, String parkingEmail, String parkingPhoneNumber, String parkingAddress, String dateCreate, String status) {
        super();
        this.orderID = orderID;
        this.qRCode = qRCode;
        this.customerID = customerID;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.customerPhoneNumber = customerPhoneNumber;
        this.customerCarNumber = customerCarNumber;
        this.parkingID = parkingID;
        this.parkingName = parkingName;
        this.parkingEmail = parkingEmail;
        this.parkingPhoneNumber = parkingPhoneNumber;
        this.parkingAddress = parkingAddress;
        this.dateCreate = dateCreate;
        this.status = status;
    }

    public Integer getOrderID() {
        return orderID;
    }

    public void setOrderID(Integer orderID) {
        this.orderID = orderID;
    }

    public String getQRCode() {
        return qRCode;
    }

    public void setQRCode(String qRCode) {
        this.qRCode = qRCode;
    }

    public Integer getCustomerID() {
        return customerID;
    }

    public void setCustomerID(Integer customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public String getCustomerCarNumber() {
        return customerCarNumber;
    }

    public void setCustomerCarNumber(String customerCarNumber) {
        this.customerCarNumber = customerCarNumber;
    }

    public Integer getParkingID() {
        return parkingID;
    }

    public void setParkingID(Integer parkingID) {
        this.parkingID = parkingID;
    }

    public String getParkingName() {
        return parkingName;
    }

    public void setParkingName(String parkingName) {
        this.parkingName = parkingName;
    }

    public String getParkingEmail() {
        return parkingEmail;
    }

    public void setParkingEmail(String parkingEmail) {
        this.parkingEmail = parkingEmail;
    }

    public String getParkingPhoneNumber() {
        return parkingPhoneNumber;
    }

    public void setParkingPhoneNumber(String parkingPhoneNumber) {
        this.parkingPhoneNumber = parkingPhoneNumber;
    }

    public String getParkingAddress() {
        return parkingAddress;
    }

    public void setParkingAddress(String parkingAddress) {
        this.parkingAddress = parkingAddress;
    }

    public String getDateCreate() {
        return dateCreate;
    }

    public void setDateCreate(String dateCreate) {
        this.dateCreate = dateCreate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
