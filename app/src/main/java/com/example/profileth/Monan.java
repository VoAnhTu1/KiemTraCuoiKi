package com.example.profileth;

import java.util.Objects;

public class Monan {

    private String ten,mota;
    private int anh;

    public void monan() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Monan monan = (Monan) o;
        return Objects.equals(ten, monan.ten);
    }

    public Monan(String ten) {
        this.ten = ten;
    }
    public Monan(){

    }
    public Monan(String ten, String mota, int anh) {
        this.ten = ten;
        this.mota = mota;
        this.anh = anh;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getAnh() {
        return anh;
    }

    public void setAnh(int anh) {
        this.anh = anh;
    }
}

