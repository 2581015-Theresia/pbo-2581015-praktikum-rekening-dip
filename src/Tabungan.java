public class Tabungan extends Rekening implements BerBunga, BisaDitarik {
    private double bungaPersen;

    public Tabungan(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        if (saldo >= 1000000) {
            return 0;
        }

        return 5000;
    }

    @Override
    public boolean tarik(int jumlah) {
        if (jumlah <= 0 || jumlah > saldo) {
            return false;
        }
        saldo -= jumlah;
        return true;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public String keterangan() {
        return String.format("Tabungan, bunga %.1f%% per bulan", bungaPersen);
    }
}