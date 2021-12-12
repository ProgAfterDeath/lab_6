package com.example.demo;

import java.io.Serializable;

public class Phone implements Serializable {
    private int num;
    private int id;
    private String fullName;
    private int accNumber;
    private float cityTalkTime;
    private float outOfCityTalkTime;

    public void setNum(int num){
        this.num = num;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccNumber(int accNumber) {
        this.accNumber = accNumber;
    }

    public void setCityTalkTime(float cityTalkTime) {
        this.cityTalkTime = cityTalkTime;
    }

    public void setOutOfCityTalkTime(float outOfCityTalkTime) {
        this.outOfCityTalkTime = outOfCityTalkTime;
    }

    public int getNum() {
        return num;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public float getCityTalkTime() {
        return cityTalkTime;
    }

    public float getOutOfCityTalkTime() {
        return outOfCityTalkTime;
    }

    @Override
    public String toString() {
        return "Client №" + num +" {" +
                "id=" + id +
                ", ПІБ='" + fullName + '\'' +
                ", Номер рахунку=" + accNumber +
                ", Час міських розмов (годин)=" + cityTalkTime +
                ", Час міжміських розмов (годин)=" + outOfCityTalkTime +
                '}';
    }

}
