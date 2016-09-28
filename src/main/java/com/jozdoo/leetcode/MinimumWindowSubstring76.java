package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *        todo 16/9/29
 *        Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
 *        For example,
 *        S = "ADOBECODEBANC"
 *        T = "ABC"
 *        Minimum window is "BANC".
 *        Note:
 *        If there is no such window in S that covers all characters in T, return the empty string "".
 *        If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
 *
 *
 */
public class MinimumWindowSubstring76 {

    public String minWindow(String s, String t) {
        int[] tMap = new int[128];
        char[] charsT = t.toCharArray();
        for (char c : charsT) {
            tMap[c-0]=1;
        }

        char[] charsS = s.toCharArray();
        int[] charsP = new int[s.length()];
        int leftP = Integer.MIN_VALUE;
        int rightP = Integer.MAX_VALUE;
        for (char c : charsS) {
        }

        return "";
    }

}
