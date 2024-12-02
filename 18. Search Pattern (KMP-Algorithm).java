class Solution {

    ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        int txtLength = txt.length();
        int patLength = pat.length();
        for (int i = 0; i <= txtLength - patLength; i++) {
            if (txt.substring(i, i + patLength).equals(pat)) {
                result.add(i); 
            }
        }

        return result;
    }
}
