class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int w = mat.length;
        int h = mat[0].length;

        int[][] visitedMatrix = new int[w][h];
        int[][] updatedMatrix = new int[w][h];

        ArrayList<int[]> neighborsToVisit = new ArrayList<>();

        for (int i = 0; i < w; i++) {
            for (int j = 0; j < h; j++) {
                if (mat[i][j] == 0)
                    visitedMatrix[i][j] = 1;

                else {
                    int[] currentPoint = {i, j};
                    boolean nearToZero = getNeighbors(mat, currentPoint).stream()
                            .anyMatch(point -> mat[point[0]][point[1]] == 0);
                    if (nearToZero) {
                        neighborsToVisit.add(currentPoint);
                    }
                }
            }
        }

        int distance = 1;
        while (!neighborsToVisit.isEmpty()) {
            ArrayList<int[]> newNeighbors = new ArrayList<>();

            for (int[] neighbor : neighborsToVisit) {

                if (visitedMatrix[neighbor[0]][neighbor[1]] == 1)
                    continue;

                updatedMatrix[neighbor[0]][neighbor[1]] = distance;
                visitedMatrix[neighbor[0]][neighbor[1]] = 1;

                for (int[] pointNeighbors : getNeighbors(mat, neighbor)) {
                    if (visitedMatrix[pointNeighbors[0]][pointNeighbors[1]] == 0)
                        newNeighbors.add(pointNeighbors);
                }

            }

            distance++;
            neighborsToVisit = newNeighbors;
        }

        return updatedMatrix;
    }

    private List<int[]> getNeighbors(int[][] mat, int[] point) {
        int w = mat.length;
        int h = mat[0].length;

        int i = point[0];
        int j = point[1];

        List<int[]> neighbors = new ArrayList() {{
            if (i + 1 < w)
                add(new int[]{i + 1, j});
            if (i - 1 >= 0)
                add(new int[]{i - 1, j});

            if (j + 1 < h)
                add(new int[]{i, j + 1});
            if (j - 1 >= 0)
                add(new int[]{i, j - 1});
        }};

        return neighbors;
    }
}