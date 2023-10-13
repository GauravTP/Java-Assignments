import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
public class WebPageScraper {

    private static final String BBC_NEWS_URL = "https://www.bbc.com/news";

    public static void main(String[] args) {
        try {
            Document document = Jsoup.connect(BBC_NEWS_URL).get();

            Elements headlines = document.select(".gs-c-promo-heading__title");

            for (Element headline : headlines) {
                System.out.println(headline.text());
            }

            Elements links = document.select(".gs-c-promo-heading[href]");
            for (Element link : links) {
                System.out.println(link.attr("abs:href"));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
