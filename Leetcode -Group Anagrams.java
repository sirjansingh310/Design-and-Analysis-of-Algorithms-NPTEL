/// http://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/778/
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> groups = new HashMap<>();
        
        for (String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String sortedString = new String(ch);
            if (groups.containsKey(sortedString)) {
                groups.get(sortedString).add(s);
            } else {
                groups.put(sortedString, new ArrayList<>(Collections.singletonList(s)));
            }
        }
        
        return new ArrayList<>(groups.values());
    }
}
