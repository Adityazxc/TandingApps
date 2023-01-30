package com.example.tanding.model;

public class Pesanan {
    private String no_pesanan;
    private String tanggal_pesanan;
    private String tanggal_bermain;
    private String jam_mulai;
    private String jam_akhir;

    public Pesanan(String no_pesanan, String tanggal_pesanan, String tanggal_bermain, String jam_mulai, String jam_akhir) {
        this.no_pesanan = no_pesanan;
        this.tanggal_pesanan = tanggal_pesanan;
        this.tanggal_bermain = tanggal_bermain;
        this.jam_mulai = jam_mulai;
        this.jam_akhir = jam_akhir;
    }

    public String getNo_pesanan() {
        return no_pesanan;
    }

    public void setNo_pesanan(String no_pesanan) {
        this.no_pesanan = no_pesanan;
    }

    public String getTanggal_pesanan() {
        return tanggal_pesanan;
    }

    public void setTanggal_pesanan(String tanggal_pesanan) {
        this.tanggal_pesanan = tanggal_pesanan;
    }

    public String getTanggal_bermain() {
        return tanggal_bermain;
    }

    public void setTanggal_bermain(String tanggal_bermain) {
        this.tanggal_bermain = tanggal_bermain;
    }

    public String getJam_mulai() {
        return jam_mulai;
    }

    public void setJam_mulai(String jam_mulai) {
        this.jam_mulai = jam_mulai;
    }

    public String getJam_akhir() {
        return jam_akhir;
    }

    public void setJam_akhir(String jam_akhir) {
        this.jam_akhir = jam_akhir;
    }
}
