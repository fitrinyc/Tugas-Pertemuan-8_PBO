/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tugas;
import java.util.ArrayList;
import java.util.Scanner;

class DetailPembelian {
    String kodeBarang;
    String namaBarang;
    double hargaBarang;
    int jumlahBeli;

    public DetailPembelian(String kodeBarang, String namaBarang, double hargaBarang, int jumlahBeli) {
        this.kodeBarang = kodeBarang;
        this.namaBarang = namaBarang;
        this.hargaBarang = hargaBarang;
        this.jumlahBeli = jumlahBeli;
    }
}

public class tugas_praktikum7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Masukkan jumlah barang: ");
        int jumlahBarang = scanner.nextInt();

        String[] kodeBarang = new String[jumlahBarang];
        String[] namaBarang = new String[jumlahBarang];
        double[] hargaBarang = new double[jumlahBarang];

        for (int i = 0; i < jumlahBarang; i++) {
            System.out.println("\nData Barang ke-" + (i + 1));
            System.out.print("Masukkan Kode Barang: ");
            kodeBarang[i] = scanner.next();
            System.out.print("Masukkan Nama Barang: ");
            namaBarang[i] = scanner.next();
            System.out.print("Masukkan Harga Barang: ");
            hargaBarang[i] = scanner.nextDouble();
        }

        ArrayList<DetailPembelian> detailPembelianList = new ArrayList<>();

        do {
            System.out.println("\nData Barang:");
            System.out.println(" No | Kode Barang | Nama Barang | Harga Barang ");
            for (int i = 0; i < jumlahBarang; i++) {
                System.out.println(" " + (i + 1) + "   | " + kodeBarang[i] + "           | " + namaBarang[i] + "           | " + hargaBarang[i]);
            }

            System.out.print("\nMasukkan nama kode barang yang akan dibeli: ");
            String kodePembelian = scanner.next();
            int indexPembelian = -1;

            for (int i = 0; i < jumlahBarang; i++) {
                if (kodeBarang[i].equals(kodePembelian)) {
                    indexPembelian = i;
                    break;
                }
            }

            if (indexPembelian != -1) {
                System.out.print("Masukkan jumlah beli: ");
                int jumlahBeli = scanner.nextInt();

                double subtotal = hargaBarang[indexPembelian] * jumlahBeli;

                detailPembelianList.add(new DetailPembelian(kodeBarang[indexPembelian], namaBarang[indexPembelian], hargaBarang[indexPembelian], jumlahBeli));

                System.out.print("Apakah ingin membeli barang lagi? (ya/tidak): ");
                String pilihan = scanner.next().toLowerCase();

                if (!pilihan.equals("ya")) {
                    break; 
                }
            } else {
                System.out.println("Barang tidak ditemukan");
            }
        } while (true);

        System.out.println("\nTabel Pembelian Keseluruhan:");
        System.out.println(" No | Kode Barang | Nama Barang | Harga Barang | Jumlah Beli | Jumlah Bayar ");
        System.out.println("=========================================================================");

        double totalHarga = 0.0;

        for (int i = 0; i < detailPembelianList.size(); i++) {
            DetailPembelian detailPembelian = detailPembelianList.get(i);
            double subtotal = detailPembelian.hargaBarang * detailPembelian.jumlahBeli;
            totalHarga += subtotal;

            System.out.println(" " + (i + 1) + "   | " + detailPembelian.kodeBarang + "           | " + detailPembelian.namaBarang + "           | " + detailPembelian.hargaBarang + "             | " + detailPembelian.jumlahBeli + "            | " + subtotal);
        }

        System.out.println("=========================================================================");
        System.out.println("                                               | Total Harga Keseluruhan | " + totalHarga);
        System.out.println("=========================================================================");

        System.out.println("Terima kasih telah berbelanja!");

        scanner.close();
    }
}




