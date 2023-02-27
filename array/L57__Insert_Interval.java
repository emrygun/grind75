class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> result = new ArrayList<>();
        boolean intervalAdded = false;

        for (int[] curr : intervals) {
            if (!isOverlapingIntervals(curr, newInterval) && isBeforeThan(newInterval, curr)) {
                if (!intervalAdded) {
                    result.add(newInterval);
                    intervalAdded = true;
                }
                result.add(curr);
            }

            else if (isOverlapingIntervals(curr, newInterval)) {
                newInterval = mergeIntervals(curr, newInterval);
            }

            else {
                result.add(curr);
            }

        }

        if (!intervalAdded) {
            result.add(newInterval);
        }

        return result.toArray(new int[result.size()][2]);
    }

    boolean isOverlapingIntervals(int[] i1, int[] i2) {
        return Math.min(i1[1], i2[1]) - Math.max(i1[0], i2[0]) >= 0;
    }

    int[] mergeIntervals(int[] i1, int[] i2) {
        return new int[] {Math.min(i1[0], i2[0]), Math.max(i1[1], i2[1])};
    }

    boolean isBeforeThan(int[] i1, int[] i2) {
        return i1[1] < i2[0];
    }

}