import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class WebPemilu {
    protected Map<String, Integer> votes;
    private int voteMasuk;

    public WebPemilu() {
        votes = new HashMap<String, Integer>();
        this.voteMasuk = 0;
    }

    public boolean verify(String vote) {
        // Di sini, website melakukan verifikasi. Verifikasi butuh waktu yang
        // lama. Untuk menyingkat soal, anggap saja Thread.sleep(1) ini melakukan verifikasi.
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            System.out.println(e);
        }
        return true;
    }

    public synchronized void addVote(String vote) {
        Integer previousVoteCount = votes.get(vote);
        if (previousVoteCount == null) {
            previousVoteCount = 0;
        }
        votes.put(vote, previousVoteCount + 1);
        this.voteMasuk++;
        this.notify();
    }

    public Thread receiveVote(String vote) {
        // ubah kode berikut agar mengembalikan thread yang akan menambah vote
        // PENTING: jangan start thread, cukup return saja
        return new Thread() {
            @Override
            public void run() {
                if (verify(vote)) {
                    addVote(vote);
                }
            }
        };
    }

    public void printResult() {
        for (String vote : votes.keySet()) {
            System.out.println(vote + " " + votes.get(vote));
        }
    }

    public void getVotes() {
        int nVotes = 3000;
        List<Thread> threads = new ArrayList<Thread>(nVotes);
     
        long startTime = System.nanoTime();
        for (int i = 0; i < nVotes; i++) {
          Thread t = this.receiveVote("candidate-1");
          if (t != null) {
            threads.add(t);
          }
        }
        long endTime = System.nanoTime();
        long durationInNanoSeconds = (endTime - startTime);
        System.out.println("waktu: " + (durationInNanoSeconds / (1000 * 1000)) + " milisekon");
        System.out.flush();
     
        // memastikan semua vote sudah masuk
        for (Thread t : threads) {
            try {
                t.start();                
            } catch (Exception e) { }
        }
        while(this.voteMasuk < nVotes) {
            try {
                wait();
            } catch (Exception e) { }
        }
        this.printResult();
    }

    public static void main(String[] args) {
        WebPemilu webPemilu = new WebPemilu();
        webPemilu.getVotes();
    }
}