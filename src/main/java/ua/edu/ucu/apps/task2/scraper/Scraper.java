package ua.edu.ucu.apps.task2.scraper;

import org.jsoup.nodes.Document;

public abstract class Scraper {
    final String scrapeURL = "https://www.newhomesource.com/locationhandler/searchtext-{location}#skip-to-content";

    boolean checkAvailability(Document doc) {
        return !doc.select("div.clearfix").select("h3").text().contains("We could not find any homes");
    }
}
