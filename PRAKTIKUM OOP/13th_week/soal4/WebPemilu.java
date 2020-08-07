import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

public class WebPemilu {
    private Map<String, Integer> votes;

    public WebPemilu() {
        votes = new HashMap<String, Integer>();
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
    }

    public Thread receiveVote(String vote) {
        // ubah kode berikut agar mengembalikan thread yang akan menambah vote
        // PENTING: jangan start thread, cukup return saja
        return new Thread(new Runnable() {
            @Override
            public void run() {
                if (verify(vote)) {
                    addVote(vote);
                }
            }
        });
    }

    public void printResult() {
        for (String vote : votes.keySet()) {
            System.out.println(vote + " " + votes.get(vote));
        }
    }

    public static void main(String[] args) throws Exception {
        int nVotes = 3000;
        List<Thread> threads = new ArrayList<Thread>();
        WebPemilu web = new WebPemilu();
     
        long startTime = System.nanoTime();
        for (int i = 0; i < nVotes; i++) {
          Thread t = web.receiveVote("candidate-1");
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
          t.start();
        }
        web.printResult();
      }
}

// import java.util.HashMap;
// import java.util.Map;

// public class WebPemilu {
//     public Map<String, Integer> votes;

//     public WebPemilu() {
//         votes = new HashMap<String, Integer>();
//     }

//     public boolean verify(String vote) {
//         // Di sini, website melakukan verifikasi. Verifikasi butuh waktu yang
//         // lama. Untuk menyingkat soal, anggap saja Thread.sleep(1) ini melakukan verifikasi.
//         try {
//             Thread.sleep(1);
//         } catch (InterruptedException e) {
//             System.out.println(e);
//         }
//         return true;
//     }

//     public synchronized void addVote(String vote) {
//         Integer previousVoteCount = votes.get(vote);
//         if (previousVoteCount == null) {
//             previousVoteCount = 0;
//         }
//         votes.put(vote, previousVoteCount + 1);
//     }

//     public Thread receiveVote(String vote) {
//         // ubah kode berikut agar mengembalikan thread yang akan menambah vote
//         // PENTING: jangan start thread, cukup return saja
//         Thread t = new Thread()
//         {
//             public void run()
//             {
//                 if (verify(vote)) {
//                     addVote(vote);
//                 }
//             }
//         };
//         return t;
//     }

//     public void printResult() {
//         for (String vote : votes.keySet()) {
//             System.out.println(vote + " " + votes.get(vote));
//         }
//     }

//     public static void main(String[] args) {
//         System.out.println("hohoho");
//         WebPemilu webPemilu = new WebPemilu();
//         for(int i = 0 ; i < 1000; i++) {
//             webPemilu.receiveVote("prabowo").run();
//         }
//         webPemilu.printResult();
//     }
// }
