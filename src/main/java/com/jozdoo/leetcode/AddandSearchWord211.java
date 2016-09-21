package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 * TODO 16/9/28
 */
public class AddandSearchWord211 {
    public static void main(String[] args) {
        AddandSearchWord211 a = new AddandSearchWord211();
        a.addWord("a");
        a.addWord("ab");
        a.search(".a");
    }
    List<String> list = new ArrayList<>();
    public void addWord(String word) {
        list.add(word);
    }

    public boolean search(String word) {
        for (String s : list) {
            if(word.length()!=s.length())continue;
            boolean isTrue = true;
            for(int i=0;i<s.length();i++){
                if(word.charAt(i)!='.'&& word.charAt(i)!=s.charAt(i)){
                    isTrue =false;
                    break;
                }
            }
            if(isTrue) {
                return true;
            }
        }
        return false;

    }
}
