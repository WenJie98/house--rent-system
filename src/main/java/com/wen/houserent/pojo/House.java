package com.wen.houserent.pojo;

public class House {

    private int id;
    private String name;
    private int tel;
    private String address;
    private int price;
    private String rent;


    public House() {
    }

    public House(int id, String name, int tel, String address, int price, String rent) {
        this.id = id;
        this.name = name;
        this.tel = tel;
        this.address = address;
        this.price = price;
        this.rent = rent;
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

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    @Override
    public String toString() {
        return id +
                "\t\t" + name +
                "\t\t" + tel +
                "\t\t" + address +
                "\t" + price +
                "\t" + rent
                ;
    }
}
