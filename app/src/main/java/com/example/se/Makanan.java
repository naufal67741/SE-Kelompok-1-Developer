package com.example.se;

public class Makanan {
    private String namaMakanan;
    private String kategori;
    private String deskripsi;
    private int jumlahKalori;
    private int qty;
    private int foto;

    public Makanan(){

    }

    public Makanan(String namaMakanan, String kategori, String deskripsi, int jumlahKalori, int qty, int foto) {
        this.namaMakanan = namaMakanan;
        this.kategori = kategori;
        this.deskripsi = deskripsi;
        this.jumlahKalori = jumlahKalori;
        this.qty = qty;
        this.foto = foto;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getKategori() {
        return kategori;
    }

    public void setKategori(String kategori) {
        this.kategori = kategori;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public int getJumlahKalori() {
        return jumlahKalori;
    }

    public void setJumlahKalori(int jumlahKalori) {
        this.jumlahKalori = jumlahKalori;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }
}
