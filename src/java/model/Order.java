/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author Admin
 */
public class Order {

//    SELECT TOP (1000) [id]
//      ,[account_id]
//      ,[totalPrice]
//      ,[note]
//      ,[date]
//      ,[shipping_id]
//  FROM [PRJ301_DB].[dbo].[Orders]
    private int id;
    private int accountId;
    private double totalPrice;
    private double price;
    private String note;
    private Date date;
    private int shippingId;
    private int quantity;
    private String displayName;
    private String phone;
    private String address;
    private String productName;

    public Order() {
    }

    public Order(int id, String productName, int quantity, double price, String note, Date date, double totalPrice, String displayName, String phone, String address) {
        this.id = id;
        this.totalPrice = totalPrice;
        this.note = note;
        this.date = date;
        this.quantity = quantity;
        this.price = price;
        this.displayName = displayName;
        this.phone = phone;
        this.address = address;
        this.productName = productName;
    }

    public Order(int id, int accountId, double totalPrice, String note, Date date, int shippingId) {
        this.id = id;
        this.accountId = accountId;
        this.totalPrice = totalPrice;
        this.note = note;
        this.date = date;
        this.shippingId = shippingId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getShippingId() {
        return shippingId;
    }

    public void setShippingId(int shippingId) {
        this.shippingId = shippingId;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "Order{" + "id=" + id + ", productName=" + productName + ", quantity=" + quantity + ", price=" + price + ", note=" + note + ", date=" + date + ", totalPrice=" + totalPrice + ", displayName=" + displayName + ", phone=" + phone + ", address=" + address + '}';
    }
}
