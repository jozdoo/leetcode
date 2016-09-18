package com.jozdoo.leetcode;

import java.util.*;


public class GroupAnagrams49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sortStr = new String(chars);
            List<String> list = map.get(sortStr);
            if(list==null)list = new ArrayList<>();
            list.add(str);
            map.put(sortStr,list);
        }
        ArrayList<List<String>> lists = new ArrayList<>(map.values());
        return lists;
    }
}
