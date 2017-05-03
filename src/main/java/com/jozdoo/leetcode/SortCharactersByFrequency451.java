package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/5/3
 * @email jozdoo@gmail.com
 *        Given a string, sort it in decreasing order based on the frequency of characters.
 *        Example 1:
 *        Input:
 *        "tree"
 *        Output:
 *        "eert"
 *        Explanation:
 *        'e' appears twice while 'r' and 't' both appear once.
 *        So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *        Example 2:
 *        Input:
 *        "cccaaa"
 *        Output:
 *        "cccaaa"
 *        Explanation:
 *        Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 *        Note that "cacaca" is incorrect, as the same characters must be together.
 *        Example 3:
 *        Input:
 *        "Aabb"
 *        Output:
 *        "bbAa"
 *        Explanation:
 *        "bbaA" is also a valid answer, but "Aabb" is incorrect.
 *        Note that 'A' and 'a' are treated as two different characters.
 */
public class SortCharactersByFrequency451 {
    public String frequencySort(String s) {
        StringBuffer stringBuffer = new StringBuffer();
        int[] chars = new int[128];
        for (int i = 0; i < s.length(); i++) {
            chars[s.charAt(i)]++;
        }
        while (true){
            int max = 0;
            char c = 0;
            for (int j = 0; j < 128; j++) {
                if(chars[j]>max){
                    max = chars[j];
                    c = (char) j;
                }
            }
            chars[c]=0;
            if(max>0){
                for (int j = 0; j < max; j++) {
                    stringBuffer.append(c);
                }
            }else {
                break;
            }
        }
        return stringBuffer.toString();
    }
}
