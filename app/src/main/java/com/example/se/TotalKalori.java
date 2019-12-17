package com.example.se;

public class TotalKalori {
    private int totalKalori=0;
    private int bakarKalori = 0;
    private int sisaKalori = 0;
    private static volatile TotalKalori tk = new TotalKalori();

    public void tambahKalori(int jumlahKalori){
        totalKalori = totalKalori + jumlahKalori;
    }
    public int getTotalKalori(){
        return totalKalori;
    }
    public void setBakarKalori(int kaloriTerbakar){
        bakarKalori = bakarKalori + kaloriTerbakar;
    }
    public int getSisaKalori(){
        return totalKalori - bakarKalori;
    }
    public int getBakarKalori(){
        return bakarKalori;
    }
    public static TotalKalori getInstance(){
        return tk;
    }
}
