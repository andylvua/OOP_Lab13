package ua.edu.ucu.apps.task2.scraper;

import ua.edu.ucu.apps.task2.database.HomeSourceDatabase;

import java.sql.SQLException;
import java.util.List;

public class NewHomeSourceCachedScraper extends Scraper {
    private final NewHomeSourceScraper generalScraper = new NewHomeSourceScraper();

    @Override
    public List<String> scrape(String location) throws SQLException {
        List<String> output;
        location = location.toLowerCase();

        output = HomeSourceDatabase.getCache(location);
        if (!output.isEmpty()) {
            System.out.println("Found cached results for location: " + location);
            return output;
        }

        System.out.println("No cached results found for location: " + location + ". Scraping...");
        output = generalScraper.scrape(location);

        if (!output.isEmpty()) {
            HomeSourceDatabase.setCache(location, output);
        }

        return output;
    }
}
