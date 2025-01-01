class Solution {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        ArrayList<ArrayList<String>> result = new ArrayList<>();
        HashMap<String,ArrayList<String>> anagramGroups = new HashMap<>();
        for(String str : arr) {
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String sortedStr = new String(temp);
            anagramGroups.putIfAbsent(sortedStr, new ArrayList<>());
            anagramGroups.get(sortedStr).add(str);
        }
        
        for(ArrayList<String> str : anagramGroups.values()) {
            result.add(str);
        }
        
        return result;
    }
}
