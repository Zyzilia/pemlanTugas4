
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data akun disimpan dalam array
        Akun[] daftarAkun = {
            new Akun("3835634561", "jhon", 5000000, "4657"),
            new Akun("5639857342", "mark", 8000000, "7894"),
            new Akun("7459375479", "siny", 10000000, "0346")
        };

        while (true) {  // Loop tak hingga
            System.out.println("\nSelamat datang di sistem transaksi.");
            System.out.print("Masukkan nomor pelanggan: ");
            String inputNomor = scanner.nextLine();

            Akun akunTerpilih = null;
            for (int i = 0; i < daftarAkun.length; i++) {
                if (daftarAkun[i].getNomorPelanggan().equals(inputNomor)) {
                    akunTerpilih = daftarAkun[i];
                    break;
                }
            }

            if (akunTerpilih == null) {
                System.out.println("Nomor pelanggan tidak ada dalam data.");
                continue;  // Kembali ke awal loop
            }

            System.out.print("Masukkan PIN: ");
            String inputPIN = scanner.nextLine();

            if (!akunTerpilih.verifikasiPIN(inputPIN)) {
                continue;  // Jika verifikasi gagal, ulangi transaksi
            }

            System.out.println("Pilih transaksi:");
            System.out.println("1. Pembelian");
            System.out.println("2. Top Up");
            System.out.print("Pilihan: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    System.out.print("Jumlah pembelian: ");
                    double jumlahPembelian = scanner.nextDouble();
                    scanner.nextLine();
                    Transaksi.transaksiPembelian(akunTerpilih, jumlahPembelian);
                    break;
                case 2:
                    System.out.print("Jumlah top up: ");
                    double jumlahTopUp = scanner.nextDouble();
                    scanner.nextLine();
                    Transaksi.transaksiTopUp(akunTerpilih, jumlahTopUp);
                    break;
                default:
                    System.out.println("Tidak valid.");
            }

            // Opsional: Tampilkan status akun setelah transaksi
            System.out.println("Status akun saat ini:");
            System.out.println("Nama: " + akunTerpilih.getNama());
            System.out.println("Saldo: " + akunTerpilih.getSaldo());
            // Program akan kembali ke awal loop untuk transaksi berikutnya.
        }
    }
}
