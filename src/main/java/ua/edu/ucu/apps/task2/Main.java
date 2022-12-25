package ua.edu.ucu.apps.task2;

import ua.edu.ucu.apps.task2.scraper.NewHomeSourceCachedScraper;

import java.sql.SQLException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws SQLException {
//        NewHomeSourceScraper scraper = new NewHomeSourceScraper();
        NewHomeSourceCachedScraper cachedScraper = new NewHomeSourceCachedScraper();

//        List<String> result = scraper.scrape("texas");
        List<String> cachedResult = cachedScraper.scrape("lviv");
        System.out.println("-----");
        List<String> cachedResult2 = cachedScraper.scrape("texas");

//        result.forEach(System.out::println);
        cachedResult.forEach(System.out::println);
        cachedResult2.forEach(System.out::println);
    }
}
