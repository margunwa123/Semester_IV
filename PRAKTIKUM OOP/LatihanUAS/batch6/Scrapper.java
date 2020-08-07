import java.util.ArrayList;
import java.util.List;

class Scrapper {
    private ArrayList<String> urlList;
    private int lowestPrice;
    private int websiteVisited;

    public Scrapper() {
        urlList = new ArrayList<String>();
        this.lowestPrice = Integer.MAX_VALUE;
        this.websiteVisited = 0;
    }

    public void addUrl(String url) {
        urlList.add(url);
    }

    // ini sebenernya kyknya harus dipakein synchronized biar
    // thread yang nge notify price ga barengan dan ga terjadi
    // kesalahan data
    public synchronized void notifyPrice(int price) {
        if(price < this.lowestPrice) {
            this.lowestPrice = price;
        }
        // nambahin banyak web yg udah dikunjungi sebanyak 1
        // abis itu notify diri sendiri , (biar waitnya beres)
        this.websiteVisited += 1;
        this.notify();
    }

    public int scrapLowestPrice() {
        // Kode berikut masih melakukan scrap ke banyak website
        // secara sekuensial. Agar lebih cepat, ubahlah kode di bawah ini
        // menjadi paralel menggunakan wait dan notify, dengan membuat
        // instance ScrapperThread
        // Hint: baca materi praktikum
        this.websiteVisited = 0;
        this.lowestPrice = Integer.MAX_VALUE;
        for (String url : urlList) {
            ScrapperThread scrapperThread = new ScrapperThread(new Website(url), this);
            scrapperThread.start();
        }
        while(this.websiteVisited < urlList.size()) {
            // tiap kali di notify, misalnya masih belom semua web dikunjungi, loop terus
            // wait lagi
            try{
                this.wait();
            }
            catch(Exception e) {
                //
            }
        }
        return this.lowestPrice;
    }
}