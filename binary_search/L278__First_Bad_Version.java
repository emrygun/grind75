/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    int badVersion = Integer.MIN_VALUE;

    public int firstBadVersion(int n) {
        // Bad version known scenario
        if (badVersion != Integer.MIN_VALUE) {
            return badVersion;
        } else {
            badVersion = binarySearch(n);
            return badVersion;
        }
    }

    private int binarySearch(int n) {
        if (n == 1) {
            return 1;
        } else if (n == 2) {
            return isBadVersion(1) ? 1 : 2;
        }

        int low = 0;
        int high = n;
        int mid = n/2;

        while(low + 1 != high) {
            if (isBadVersion(mid))
                high = mid;
            else
                low = mid;

            mid = (low + (high - low) / 2);
        }

        return high;
    }

}
