package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/1/23
 * @email jozdoo@gmail.com
 */
public class FizzBuzz412 {
    public List<String> fizzBuzz(int n) {
        List<String> strings  = new ArrayList<>(n);
        for (int i = 1; i <= n; i++) {
            if(i%3==0&&i%5==0)strings.add("FizzBuzz");
            else if(i%5==0)strings.add("Buzz");
            else if(i%3==0)strings.add("Fizz");
            else strings.add(String.valueOf(i));
        }
        return strings;
    }
}
