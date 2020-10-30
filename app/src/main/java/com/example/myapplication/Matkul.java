package com.example.myapplication;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Matkul {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("nama")
    @Expose
    private String nama;

    @SerializedName("nim_progmob")
    @Expose
    private String nim_progmob;

    @SerializedName("kode")
    @Expose
    private String kode;

    @SerializedName("hari")
    @Expose
    private String hari;

    @SerializedName("sesi")
    @Expose
    private String sesi;

    @SerializedName("sks")
    @Expose
    private String sks;

    @SerializedName("kode_cari")
    @Expose
    private String kode_cari;


    public Matkul(String nama, String nim_progmob, String kode, String hari, String sesi) {
        this.nama = nama;
        this.nim_progmob = nim_progmob;
        this.kode = kode;
        this.hari = hari;
        this.sesi = sesi;
//        this.sks = sks;

    }
    public Matkul(String id,String nama, String nim_progmob, String kode, String hari,String sesi, String sks, String kode_cari) {
        this.id = id;
        this.nama = nama;
        this.nim_progmob = nim_progmob;
        this.kode = kode;
        this.hari = hari;
        this.sesi = sesi;
        this.sks = sks;
        this.kode_cari = kode_cari;
    }

    public Matkul(String kode, String nim_progmob) {
        this.kode = kode;
        this.nim_progmob = nim_progmob;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNamaMatkul() {
        return nama;
    }

    public void setNamaMatkul(String namaMatkul) {
        this.nama = nama;
    }

    public String getKodeMatkul() {
        return kode;
    }

    public void setKodeMatkul(String kodeMatkul) {
        this.kode = kode;
    }

    public String getMatkulHari() {
        return hari;
    }

    public void setMatkulHari(String matkulHari) {
        this.hari = hari;
    }

    public String getSesi() {
        return sesi;
    }

    public void setSesi(String sesi) {
        this.sesi = sesi;
    }


    public String getSks() {
        return sks;
    }

    public void setSks(String sks) {
        this.sks = sks;
    }


}

