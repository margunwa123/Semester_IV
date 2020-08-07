
public class ScrapperThread extends Thread {
    private ScrapperListener listener;
    private String url;

    public ScrapperThread(ScrapperListener listener, String url)
    {
        this.listener = listener;
        this.url = url;
    }

    @Override
    public void run()
    {
        Website w = new Website(this.url);
        this.listener.onScrapeListener(w.getPrice());
        this.notify();
    }

    public interface ScrapperListener
    {
        public void onScrapeListener(int price);
    }
}