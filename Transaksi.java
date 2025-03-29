
class Transaksi {

    // Method untuk transaksi pembelian
    public static void transaksiPembelian(Akun akun, double jumlahPembelian) {
        double saldoSementara = akun.getSaldo() - jumlahPembelian;
        double cashback = 0;

        // Menentukan tipe akun berdasarkan 2 digit awal nomor pelanggan
        String tipe = akun.getNomorPelanggan().substring(0, 2);

        if (jumlahPembelian >= 1000000) {
            if (tipe.equals("38")) {
                cashback = 0.05 * jumlahPembelian;
            } else if (tipe.equals("56")) {
                cashback = 0.07 * jumlahPembelian;
            } else if (tipe.equals("74")) {
                cashback = 0.10 * jumlahPembelian;
            }
        } else {
            if (tipe.equals("56")) {
                cashback = 0.02 * jumlahPembelian;
            } else if (tipe.equals("74")) {
                cashback = 0.05 * jumlahPembelian;
            }
        }

        saldoSementara += cashback;

        if (saldoSementara < 10000) {
            System.out.println("Transaksi gagal, saldo setelah transaksi kurang dari Rp10.000.");
            return;
        }

        akun.setSaldo(saldoSementara);
        System.out.println("Transaksi pembelian berhasil.");
        System.out.printf("Cashback: %.2f \n", cashback);
        System.out.printf("Saldo akhir: %.2f \n", akun.getSaldo());
    }

    // Method untuk transaksi top up
    public static void transaksiTopUp(Akun akun, double jumlahTopUp) {
        double saldoBaru = akun.getSaldo() + jumlahTopUp;
        akun.setSaldo(saldoBaru);
        System.out.println("Top up berhasil. Saldo sekarang: " + akun.getSaldo());
    }
}
