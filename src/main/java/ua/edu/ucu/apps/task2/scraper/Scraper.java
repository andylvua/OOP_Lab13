package ua.edu.ucu.apps.task2.scraper;

import org.jsoup.nodes.Document;

import java.sql.SQLException;
import java.util.List;

public abstract class Scraper {
    final String scrapeURL = "https://www.newhomesource.com/locationhandler/searchtext-{location}#skip-to-content";
    abstract List<String> scrape(String url) throws SQLException;

    boolean checkAvailability(Document doc) {
        return !doc.select("div.clearfix").select("h3").text().contains("We could not find any homes");
    }
}
