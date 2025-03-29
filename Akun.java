
class Akun {

    private String nomorPelanggan;
    private String nama;
    private double saldo;
    private String pin;
    private int kesalahanAuth;
    private boolean blokir;

    public Akun(String nomorPelanggan, String nama, double saldo, String pin) {
        this.nomorPelanggan = nomorPelanggan;
        this.nama = nama;
        this.saldo = saldo;
        this.pin = pin;
        this.kesalahanAuth = 0;
        this.blokir = false;
    }

    public String getNomorPelanggan() {
        return nomorPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // Verifikasi PIN; blokir akun jika terjadi 3 kesalahan
    public boolean verifikasiPIN(String inputPIN) {
        if (this.blokir) {
            System.out.println("Akun telah diblokir.");
            return false;
        }
        if (this.pin.equals(inputPIN)) {
            kesalahanAuth = 0;
            return true;
        } else {
            kesalahanAuth++;
            System.out.println("PIN salah. Count: " + kesalahanAuth);
            if (kesalahanAuth >= 3) {
                blokir = true;
                System.out.println("Akun diblokir karena 3 kali kesalahan pin.");
            }
            return false;
        }
    }
}
