class Solution {
    public int longestPalindrome(String s) {
        int mapSize = '{' - 'A';
        int[] map = new int[mapSize];
        int length = 0;
        boolean single = false;

        for (char c : s.toCharArray()) {
            map[c - 'A']++;
        }

        for (int i = 0; i < mapSize; i++) {
            length += map[i] / 2 * 2;

            if (map[i] % 2 == 1) single = true;
        }

        return length + (single ? 1 : 0);


    }
}
