package com.example.tanding.model;

public class Jadwal {

    private Gor gor;
    private Pesanan pesanan;

    public Jadwal(Gor gor, Pesanan pesanan) {
        this.gor = gor;
        this.pesanan = pesanan;
    }

    public Gor getGor() {
        return gor;
    }

    public void setGor(Gor gor) {
        this.gor = gor;
    }

    public Pesanan getPesanan() {
        return pesanan;
    }

    public void setPesanan(Pesanan pesanan) {
        this.pesanan = pesanan;
    }
}
