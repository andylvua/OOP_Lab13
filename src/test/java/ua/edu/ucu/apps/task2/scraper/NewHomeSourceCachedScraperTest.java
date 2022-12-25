package ua.edu.ucu.apps.task2.scraper;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.sql.SQLException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class NewHomeSourceCachedScraperTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private static final PrintStream originalOut = System.out;

    @BeforeAll
    public static void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll
    public static void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void scrapeNoCache() throws SQLException {
        NewHomeSourceCachedScraper cachedScraper = new NewHomeSourceCachedScraper();
        List<String> result = cachedScraper.scrape("lviv");

        assertTrue(result.isEmpty());

        // Assert that stdout contains "No cached results found"
        // Thanks to dfa: https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        assertTrue(outContent.toString().contains("No cached results found"));
    }

    @Test
    void scrapeWithCache() throws SQLException {
        NewHomeSourceCachedScraper cachedScraper = new NewHomeSourceCachedScraper();
        List<String> result = cachedScraper.scrape("texas");

        assertFalse(result.isEmpty());

        // Assert that stdout contains "Found cached results"
        // Thanks to dfa: https://stackoverflow.com/questions/1119385/junit-test-for-system-out-println
        assertTrue(outContent.toString().contains("Found cached results"));
    }
}