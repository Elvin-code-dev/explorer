import java.util.ArrayList;
import java.util.List;

public class ExplorerSearch {

    /**
     * Returns how much land area an explorer can reach on a rectangular island.
     * 
     * The island is represented by a rectangular int[][] that contains
     * ONLY the following nunbers:
     * 
     * '0': represents the starting location of the explorer
     * '1': represents a field the explorer can walk through
     * '2': represents a body of water the explorer cannot cross
     * '3': represents a mountain the explorer cannot cross
     * 
     * The explorer can move one square at a time: up, down, left, or right.
     * They CANNOT move diagonally.
     * They CANNOT move off the edge of the island.
     * They CANNOT move onto a a body of water or mountain.
     * 
     * This method should return the total number of spaces the explorer is able
     * to reach from their starting location. It should include the starting
     * location of the explorer.
     * 
     * For example
     * 
     * @param island the locations on the island
     * @return the number of spaces the explorer can reach
     */
    public static int reachableArea(int[][] island) {
        int[] start = startLocation(island);
        boolean[][] visited = new boolean[island.length][island[0].length];

        return explore(start, island, visited);
    }

    private static int explore(int[] loc, int[][] island, boolean[][] visited) {
        int r = loc[0];
        int c = loc[1];

        if (visited[r][c]) {
            return 0;
        }

        if (island[r][c] == 2 || island[r][c] == 3) {
            return 0;
        }

        visited[r][c] = true;

        int count = 1;

        for (int[] move : possibleMoves(island, loc)) {
            count += explore(move, island, visited);
        }

        return count;
    }

    public static List<int[]> possibleMoves(int[][] island, int[] location) {
        int r = location[0];
        int c = location[1];

        List<int[]> validLocs = new ArrayList<>();

        int newR = r - 1;
        int newC = c;
        if (newR >= 0) {
            validLocs.add(new int[] { newR, newC });
        }

        newR = r + 1;
        newC = c;
        if (newR < island.length) {
            validLocs.add(new int[] { newR, newC });
        }

        newR = r;
        newC = c + 1;
        if (newC < island[0].length) {
            validLocs.add(new int[] { newR, newC });
        }

        newR = r;
        newC = c - 1;
        if (newC >= 0) {
            validLocs.add(new int[] { newR, newC });
        }

        return validLocs;
    }

    public static int[] startLocation(int[][] island) {
        for (int r = 0; r < island.length; r++) {
            for (int c = 0; c < island[0].length; c++) {
                if (island[r][c] == 0) {
                    return new int[] { r, c };
                }
            }
        }

        throw new IllegalArgumentException("No start found");
    }
}
