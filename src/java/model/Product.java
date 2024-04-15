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
public class Product {
//       [id] INT IDENTITY(1,1) NOT NULL,
//    [name] NVARCHAR(255) NULL,
//	[quantity] INT NULL,
//    [price] FLOAT NULL,
//    [description] NVARCHAR(255) NULL,
//    [image_url] NVARCHAR(255) NULL,
//    [category_id] INT NULL,

    private int id;
    private String name;
    private int quantity; // slg sp trong kho
    private double price;
    private String description;
    private String imageUrl;
    private int categoryId;
    private Date expDate;
    private Date mfgDate;

    public Product() {
    }

    public Product(int id, String name, int quantity, double price, String description, String imageUrl, int categoryId, Date mfgDate, Date expDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.expDate = expDate;
        this.mfgDate = mfgDate;
    }

    public Product(int id, String name, int quantity, double price, String description, String imageUrl, int categoryId, Date mfgDate) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
        this.mfgDate = mfgDate;
    }

    public Product(int id, String name, int quantity, double price, String description, String imageUrl, int categoryId) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public Product(String name, int quantity, double price, String description, String imageUrl, int categoryId) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.description = description;
        this.imageUrl = imageUrl;
        this.categoryId = categoryId;
    }

    public Date getMfgDate() {
        return mfgDate;
    }

    public void setMfgDate(Date mfgDate) {
        this.mfgDate = mfgDate;
    }

    public Date getExpDate() {
        return expDate;
    }

    public void setExpDate(Date expDate) {
        this.expDate = expDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    @Override
    public String toString() {
        return "Product{" + "id=" + id + ", name=" + name + ", quantity=" + quantity + ", price=" + price + ", description=" + description + ", imageUrl=" + imageUrl + ", categoryId=" + categoryId + ", expDate=" + expDate + ", mfgDate=" + mfgDate + '}';
    }
}
