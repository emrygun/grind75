class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        for (char elem : s.toCharArray()) {
            if (elem == '}' || elem == ']' || elem == ')')
                if ((!stack.isEmpty()) && (Math.abs(stack.lastElement() - elem) < 3))
                    stack.pop();
                else return false;

            else stack.push(elem);
        }
        return stack.isEmpty();
    }
}