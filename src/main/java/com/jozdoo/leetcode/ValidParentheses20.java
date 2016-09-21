package com.jozdoo.leetcode;

import java.util.LinkedList;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *        Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *        The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses20 {
    public boolean isValid(String s) {
        LinkedList<Character> linkedList = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            Character peek = linkedList.peek();
            if(peek!=null&&cp(peek,c))linkedList.pop();
            else linkedList.push(c);
        }
        if (linkedList.size()>0)return false;
        return true;
    }
    public boolean cp(Character a,Character b){
        if(a.equals('(')&&b.equals(')'))return true;
        if(a.equals('[')&&b.equals(']'))return true;
        if(a.equals('{')&&b.equals('}'))return true;
        return false;
    }
}
