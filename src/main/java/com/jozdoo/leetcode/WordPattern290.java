package com.jozdoo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/1/23
 * @email jozdoo@gmail.com
 */
public class WordPattern290 {
    public static void main(String[] args) {
        System.out.println(wordPattern("abba","dog dog dog dog"));
    }
    public static boolean wordPattern(String pattern, String str) {
        Map<Character,String> patterAsKey = new HashMap<>(24);
        Map<String,Character> strAsKey = new HashMap<>(24);
        char[] charArray = pattern.toCharArray();
        String[] split = str.split(" ");
        if(charArray.length!=split.length)return false;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            String word = split[i];

            String s = patterAsKey.get(c);
            if(s==null){
                patterAsKey.put(c,word);
            }else {
                if(!s.equals(word)){
                    return false;
                }
            }

            Character character = strAsKey.get(word);
            if(character==null){
                strAsKey.put(word,c);
            }else {
                if(!character.equals(c)){
                    return false;
                }
            }
        }
        return true;
    }
}
