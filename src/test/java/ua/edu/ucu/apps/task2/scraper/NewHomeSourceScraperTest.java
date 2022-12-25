package ua.edu.ucu.apps.task2.scraper;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewHomeSourceScraperTest {
    private static NewHomeSourceScraper scraper;

    @BeforeAll
    static void setUp() {
        scraper = new NewHomeSourceScraper();
    }

    @Test
    void scrape() {
        List<String> result = scraper.scrape("texas");

        assertFalse(result.isEmpty());
    }

    @Test
    void scrapeEmpty() {
        List<String> result = scraper.scrape("lviv");

        assertTrue(result.isEmpty());
    }
}