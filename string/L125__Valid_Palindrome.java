class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        s = s.replaceAll("[^a-zA-Z0-9]", "");

        int len = s.length() - 1;
        char[] st = s.toCharArray();
        for (int i = 0, j = len; i < j; i++, j--){
            System.out.println(st[i] + " - " + st[j]);
            if (st[i] != st[j]) return false;
        }

        return true;
    }
}
