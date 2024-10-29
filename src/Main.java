import java.util.ArrayList;
import java.util.Scanner;

/**
 * ConcertTicketOrder adalah kelas yang menangani pemesanan tiket konser,
 * memungkinkan pengguna untuk memasukkan jenis tiket dan harga, menampilkan
 * pesanan tiket, dan menghitung total harga tiket yang dipesan.
 */
class ConcertTicketOrder {

    /**
     * Daftar jenis tiket untuk konser.
     */
    private ArrayList<String> ticketTypes;

    /**
     * Daftar harga tiket yang sesuai dengan setiap jenis tiket.
     */
    private ArrayList<Double> ticketPrices;

    /**
     * Membangun objek ConcertTicketOrder baru, menginisialisasi daftar untuk menyimpan
     * jenis tiket dan harga tiket.
     */
    public ConcertTicketOrder() {
        ticketTypes = new ArrayList<>();
        ticketPrices = new ArrayList<>();
    }

    /**
     * Menambahkan tiket konser ke dalam pesanan, menyimpan jenis dan harganya.
     *
     * @param ticketType  jenis atau kategori tiket (misalnya, VIP, Reguler)
     * @param ticketPrice harga tiket
     */
    public void addConcertTicket(String ticketType, double ticketPrice) {
        ticketTypes.add(ticketType);
        ticketPrices.add(ticketPrice);
    }

    /**
     * Menampilkan daftar tiket konser yang dipesan, menunjukkan setiap jenis tiket
     * dan harga yang sesuai.
     */
    public void displayTicketOrders() {
        System.out.println("Daftar Pesanan Tiket Konser:");
        for (int i = 0; i < ticketTypes.size(); i++) {
            System.out.println(ticketTypes.get(i) + " - Rp" + ticketPrices.get(i));
        }
    }

    /**
     * Menghitung dan mengembalikan total harga dari semua tiket yang dipesan.
     *
     * @return total harga dari tiket yang dipesan
     */
    public double getTotalOrderPrice() {
        double totalPrice = 0;
        for (double ticketPrice : ticketPrices) {
            totalPrice += ticketPrice;
        }
        return totalPrice;
    }

    /**
     * Metode utama yang memungkinkan pengguna untuk memasukkan jenis dan harga tiket,
     * kemudian menampilkan daftar pesanan tiket beserta total harganya.
     *
     * @param args argumen baris perintah (tidak digunakan)
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ConcertTicketOrder order = new ConcertTicketOrder();

        System.out.println("Masukkan jumlah tiket yang ingin dipesan:");
        int ticketCount = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < ticketCount; i++) {
            System.out.println("Masukkan jenis tiket:");
            String ticketType = sc.nextLine();
            System.out.println("Masukkan harga tiket:");
            double ticketPrice = sc.nextDouble();
            sc.nextLine();
            order.addConcertTicket(ticketType, ticketPrice);
        }

        order.displayTicketOrders();
        System.out.println("Total Harga: Rp" + order.getTotalOrderPrice());

        sc.close(); // Menutup scanner untuk menghindari kebocoran sumber daya
    }
}
