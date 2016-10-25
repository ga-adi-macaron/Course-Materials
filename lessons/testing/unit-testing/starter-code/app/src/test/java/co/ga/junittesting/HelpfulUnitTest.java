package co.ga.junittesting;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * To work on unit tests, switch the Test Artifact in the Build Variants view.
 */
public class HelpfulUnitTest {
    @Test
    public void usefulMethods() throws Exception {
        assertEquals(4, 2 + 2);
        assertTrue(true);
        assertFalse(false);
        assertNull(null);
        assertNotNull("Not null");
    }
}