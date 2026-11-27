public class Deposito extends Rekening implements BerBunga {
    private double bungaPersen;

    public Deposito(String nomor, String pemilik, int saldo, double bungaPersen) {
        super(nomor, pemilik, saldo);
        this.bungaPersen = bungaPersen;
    }

    @Override
    public int biayaAdminBulanan() {
        return 0;
    }

    @Override
    public boolean tarik(int jumlah) {

        return false;
    }

    @Override
    public int tambahBunga() {
        int bunga = (int) Math.round(saldo * bungaPersen / 100);
        setor(bunga);
        return bunga;
    }

    @Override
    public String keterangan() {
        return String.format("Deposito, bunga %.1f%% per bulan", bungaPersen);
    }
}

