package org.example.models;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;

public class Car {
    private int id;

    @NotEmpty(message = "Number should not be empty")
    @Size(min = 8, max = 9, message = "Number should be between 8 and 9 characters")
    private String number;

    @NotEmpty(message = "Brand should not be empty")
    private String brand;

    @NotEmpty(message = "Model should not be empty")
    private String model;

    @NotEmpty(message = "Color should not be empty")
    private String color;

    @Min(value = 1886, message = "Year of manufacture should be greater than 1886")
    @Max(value = 2022, message = "Year of manufacture should not be greater than 2022")
    private int yearOfManufacture;

    private Date date;

    public Car() {

    }

    public Car(int id, String number, String brand, String model, String color, int yearOfManufacture, Date date) {
        this.id = id;
        this.number = number;
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.yearOfManufacture = yearOfManufacture;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getYearOfManufacture() {
        return yearOfManufacture;
    }

    public void setYearOfManufacture(int yearOfManufacture) {
        this.yearOfManufacture = yearOfManufacture;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
