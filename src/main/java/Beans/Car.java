package Beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Car implements Serializable {

    private String id;
    private String brand;
    private int year;
    private String color;
    private int price;
    private boolean sold;

    public Car() {}

    public Car(String id, String brand, int year, String color) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
    }

    public static List<Car> getCars(){
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("1", "BMW", 1990, "white", 3000, true));
        cars.add(new Car("2", "Mercedes", 1990, "yellow", 3000, true));
        cars.add(new Car("3", "Volvo", 1990, "silver", 3000, true));
        cars.add(new Car("4", "Audi", 1990, "orange", 3000, true));
        cars.add(new Car("5", "Renault", 1990, "green", 3000, true));
        cars.add(new Car("6", "Fiat", 1990, "purple", 3000, true));
        cars.add(new Car("7", "Volkswagen", 1990, "blue", 3000, true));
        cars.add(new Car("8", "Honda", 1990, "brown", 3000, true));
        cars.add(new Car("9", "Jaguar", 1990, "red", 3000, true));
        cars.add(new Car("10", "Ford", 1990, "black", 3000, true));
        return cars;
    }

    public Car(String id, String brand, int year, String color, int price, boolean sold) {
        this.id = id;
        this.brand = brand;
        this.year = year;
        this.color = color;
        this.price = price;
        this.sold = sold;
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isSold() {
        return sold;
    }
    public void setSold(boolean sold) {
        this.sold = sold;
    }
}