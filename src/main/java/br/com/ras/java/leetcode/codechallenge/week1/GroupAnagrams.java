package br.com.ras.java.leetcode.codechallenge.week1;


import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 *
 * Note:
 *
 *     All inputs will be in lowercase.
 *     The order of your output does not matter.
 */
public class GroupAnagrams {

    public List<List<String>> solution(String[] strs) {
        if (strs == null) {
            return Collections.emptyList();
        } else if (strs.length == 1) {
            return Collections.singletonList(new ArrayList<String>(){{add(strs[0]);}});
        }

        final Map<String, List<String>> map = new HashMap<>();
        for (int i=0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            final String ajusted = new String(chars);
            if (map.containsKey(ajusted)) {
                List<String> a = map.get(ajusted);
                a.add(strs[i]);
                map.put(ajusted, a);
            } else {
                List<String> temp = new ArrayList<>(1);
                temp.add(strs[i]);
                map.put(ajusted, temp);
            }
        }
        return new ArrayList<>(map.values());
    }

}
