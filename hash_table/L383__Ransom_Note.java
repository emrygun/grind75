class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] map = new int[('a' - 'A') + 2];

        for (char c : ransomNote.toCharArray()) {
            map[c - 'a']++;
        }

        for (char c : magazine.toCharArray()) {
            map[c - 'a']--;
        }

        for (int i = 0; i < ('a' - 'A' + 2); i++) {
            if (map[i] > 0) return false;
        }

        return true;
    }
}
