import java.util.ArrayList;


class Scrapper implements ScrapperThread.ScrapperListener{
    private ArrayList<String> urlList;
    private int lowest;
    private int count;

    public Scrapper() {
        urlList = new ArrayList<String>();
        lowest = Integer.MAX_VALUE;
        count = 0;
    }

    public void addUrl(String url) {
        urlList.add(url);
    }

    public synchronized void onScrapeListener(int price)
    {
        int prev = this.count;
        this.count = prev + 1;
        this.lowest = (this.lowest > price) ? price : this.lowest;
        this.notify();
    }

    public synchronized int scrapLowestPrice() {
        // Kode berikut masih melakukan scrap ke banyak website
        // secara sekuensial. Agar lebih cepat, ubahlah kode di bawah ini
        // menjadi paralel menggunakan wait dan notify, dengan membuat
        // Hint: baca materi praktikum
        for (String url : urlList) {
            Thread t = new ScrapperThread(this, url);
            t.start();
        }
        while(this.count<urlList.size())
        {
            try{this.wait();}
            catch(InterruptedException e) {}
        }

        return this.lowest;
    }
}
