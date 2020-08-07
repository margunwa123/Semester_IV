public class ScrapperThread extends Thread {
    private Website website;
    private Scrapper eventListener;

    // constructor, website udah jelas lah ya mo di getprice, eventlistener tuh buat
    // reference dari scrapper itu sendiri, nanti biar scrapperthread bisa manggil fungsi
    // notify price
    public ScrapperThread(Website website, Scrapper eventListener) {
        this.website = website;
        this.eventListener = eventListener;
    }

    // ini buat notify kalo website dari thread ini tuh berapa harganya
    @Override
    public void run() {
        this.eventListener.notifyPrice(website.getPrice());
    }
}