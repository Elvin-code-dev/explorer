import static org.junit.Assert.*;
import org.junit.Test;

public class ExplorerSearchTest {
    @Test
    public void testReachableArea_someUnreachable() {
        int[][] island = {
                { 1, 1, 1, 3, 1, 1 },
                { 3, 2, 3, 1, 3, 1 },
                { 1, 1, 1, 1, 3, 3 },
                { 3, 1, 2, 1, 0, 1 },
                { 1, 1, 1, 2, 1, 1 },
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(14, actual);
    }

    // Add more tests here!
    // Come up with varied cases

    @Test
    public void testReachableArea_onlyStart() {
        int[][] island = {
                { 0 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_allOpen() {
        int[][] island = {
                { 0, 1 },
                { 1, 1 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(4, actual);
    }

    @Test
    public void testReachableArea_blocked() {
        int[][] island = {
                { 3, 3, 3 },
                { 3, 0, 2 },
                { 3, 2, 1 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(1, actual);
    }

    @Test
    public void testReachableArea_someBlocked() {
        int[][] island = {
                { 0, 1, 3 },
                { 1, 2, 1 },
                { 1, 1, 1 }
        };
        int actual = ExplorerSearch.reachableArea(island);
        assertEquals(6, actual);
    }
}
