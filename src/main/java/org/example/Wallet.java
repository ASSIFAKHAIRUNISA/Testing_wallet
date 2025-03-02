// TUGAS 1
package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Wallet {
    private final String owner; // Pemilik dompet
    private List<String> kartu; // List kartu dalam dompet
    private List<Integer> uangLembaran; // List uang kertas dalam dompet
    private List<Integer> koin; // List uang koin dalam dompet

    // Constructor wajib menerima owner
    public Wallet(String owner) {
        this.owner = owner;
        this.kartu = new ArrayList<>();
        this.uangLembaran = new ArrayList<>();
        this.koin = new ArrayList<>();
        System.out.println("Pemilik Wallet adalah: " + owner);
    }

    // Method untuk menambahkan kartu ke dompet
    public void addCard(String card) {
        this.kartu.add(card);
        System.out.println("Kartu yang Ditambahkan: " + card);
    }

    // Method untuk mengambil kartu dari dompet
    public boolean removeCard(String card) {
        if (this.kartu.contains(card)) {
            this.kartu.remove(card);
            System.out.println("Kartu yang Diambil: " + card);
            return true;
        } else {
            System.out.println("Kartu tidak ditemukan di dompet.");
            return false;
        }
    }

    // Getter untuk mendapatkan jumlah kartu
    public int getCardCount() {
        return this.kartu.size();
    }

    // Method untuk menambahkan uang kertas
    public void addCash(int nominal) {
        if (nominal > 0) {
            this.uangLembaran.add(nominal);
            System.out.println("Uang kertas yang Ditambahkan: Rp " + nominal);
        }
    }

    // Method untuk menambahkan uang koin
    public void addCoin(int nominal) {
        if (nominal > 0) {
            this.koin.add(nominal);
            System.out.println("Koin yang Ditambahkan: Rp " + nominal);
        }
    }

    // Method untuk menarik uang dari dompet
    public boolean withdrawMoney(int nominal) {
        int totalUang = getTotalMoney();
        if (nominal > totalUang) {
            System.out.println("Saldo tidak cukup untuk menarik Rp " + nominal);
            return false;
        }

        int sisa = nominal;

        // **Gunakan sorting dari besar ke kecil untuk uang kertas**
        Collections.sort(uangLembaran, Collections.reverseOrder());

        for (int i = 0; i < uangLembaran.size(); i++) {
            if (uangLembaran.get(i) <= sisa) {
                sisa -= uangLembaran.get(i);
                uangLembaran.remove(i);
                i--; // Sesuaikan indeks karena elemen dihapus
            }
            if (sisa == 0) break;
        }

        // **Gunakan sorting dari besar ke kecil untuk koin**
        Collections.sort(koin, Collections.reverseOrder());

        for (int i = 0; i < koin.size(); i++) {
            if (koin.get(i) <= sisa) {
                sisa -= koin.get(i);
                koin.remove(i);
                i--;
            }
            if (sisa == 0) break;
        }

        if (sisa == 0) {
            System.out.println("Berhasil menarik Rp " + nominal);
            return true;
        } else {
            System.out.println("Tidak bisa menarik jumlah yang diminta.");
            return false;
        }
    }

    // Method untuk mendapatkan total uang dalam dompet
    public int getTotalMoney() {
        int total = 0;
        for (int uang : uangLembaran) {
            total += uang;
        }
        for (int k : koin) {
            total += k;
        }
        return total;
    }

    // Method untuk menampilkan isi dompet
    public void showWallet() {
        System.out.println("Pemilik Wallet: " + owner);
        System.out.println("Kartu: " + kartu);
        System.out.println("Total Uang di Dompet: Rp " + getTotalMoney());
    }
}
