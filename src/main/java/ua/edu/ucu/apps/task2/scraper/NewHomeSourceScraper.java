package ua.edu.ucu.apps.task2.scraper;

import java.io.IOException;
import java.util.List;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class NewHomeSourceScraper extends Scraper {
    @Override
    public List<String> scrape(String location) {
        List<String> output = List.of();
        Document doc;
        location = location.toLowerCase();

        try {
            doc = Jsoup.connect(scrapeURL.replace("{location}", location)).get();
        } catch (IOException e) {
            System.out.println("Cannot scrape url: " + scrapeURL.replace("{location}", location));
            return output;
        }

        boolean isAvailable = checkAvailability(doc);

        if (!isAvailable) {
            System.out.println("No results found for location: " + location);
            return output;
        }

        output = doc.select("a.info__link").eachAttr("href");

        return output;
    }
}
