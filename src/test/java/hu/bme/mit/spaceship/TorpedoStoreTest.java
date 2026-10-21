package hu.bme.mit.spaceship;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TorpedoStoreTest {

    private TorpedoStore store;

    @BeforeEach
    public void setUp() {
        store = new TorpedoStore(1, 0.0);
    }

    @Test
    public void testFireSuccess() {
        assertTrue(store.fire(1));
        assertEquals(0, store.getTorpedoCount());
    }

    @Test
    public void testFireFailureRate() {
        TorpedoStore faultyStore = new TorpedoStore(1, 1.0);
        assertFalse(faultyStore.fire(1));
        assertEquals(1, faultyStore.getTorpedoCount());
    }

    @Test
    public void testFireEmpty() {
        store.fire(1);
        assertThrows(IllegalArgumentException.class, () -> store.fire(1));
    }
}