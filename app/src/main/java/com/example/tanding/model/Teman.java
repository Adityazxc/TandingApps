package com.example.tanding.model;

public class Teman {

    private String nama_teman;
    private String jenis_kelamin;
    private String hobi;
    private Integer teman_photo;

    public Teman(String nama_teman, String jenis_kelamin, String hobi, Integer teman_photo) {
        this.nama_teman = nama_teman;
        this.jenis_kelamin = jenis_kelamin;
        this.hobi = hobi;
        this.teman_photo = teman_photo;
    }

    public String getNama_teman() {
        return nama_teman;
    }

    public void setNama_teman(String nama_teman) {
        this.nama_teman = nama_teman;
    }

    public String getJenis_kelamin() {
        return jenis_kelamin;
    }

    public void setJenis_kelamin(String jenis_kelamin) {
        this.jenis_kelamin = jenis_kelamin;
    }

    public String getHobi() {
        return hobi;
    }

    public void setHobi(String hobi) {
        this.hobi = hobi;
    }

    public Integer getTeman_photo() {
        return teman_photo;
    }

    public void setTeman_photo(Integer teman_photo) {
        this.teman_photo = teman_photo;
    }
}
