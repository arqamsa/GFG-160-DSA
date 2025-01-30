class Solution {
    public ArrayList<String> findPermutation(String s) {
        // Code here
        ArrayList<String> result = new ArrayList<>();
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        boolean[] used = new boolean[s.length()];
        backtrack(chars, new StringBuilder(), used, result);
        return result;
    }
    private void backtrack(char[] chars, StringBuilder current, boolean[] used, ArrayList<String> result) {
        if (current.length() == chars.length) {
            result.add(current.toString());
            return;
        }
        HashSet<Character> seen = new HashSet<>();
        for (int i = 0; i < chars.length; i++) {
            if (used[i] || seen.contains(chars[i])) {
                continue;
            }
            used[i] = true;
            seen.add(chars[i]);
            current.append(chars[i]);
            backtrack(chars, current, used, result);
            current.deleteCharAt(current.length() - 1);
            used[i] = false;
        }
    }
}
