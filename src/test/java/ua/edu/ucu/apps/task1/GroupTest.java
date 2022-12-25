package ua.edu.ucu.apps.task1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.util.concurrent.atomic.AtomicReference;

class GroupTest {
    @Test
    void testGroup() {
        Group<String> group = new Group<>();
        AtomicReference<String> result = new AtomicReference<>("");

        group.addTask(
                new Signature<>(string -> result.set(string.replace("world", "universe")))
        );

        group.apply("Hello, world!");

        assertEquals("Hello, universe!", result.get());
    }
}