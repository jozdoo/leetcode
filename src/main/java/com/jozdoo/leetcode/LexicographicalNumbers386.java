package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/19
 * @email jozdoo@gmail.com
 *
 * 深度搜索
 */
public class LexicographicalNumbers386 {
    public static void main(String[] args) {
        System.out.println(new LexicographicalNumbers386().lexicalOrder(13));
    }

    public List<Integer> lexicalOrder(int n) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<=n&&i<10;i++){
            getNum(list,n,i);
        }
        return list;
    }

    public static boolean getNum(List<Integer> list, int n, int s) {
        if(s<=n)list.add(s);
        else return false;
        for(int i=0;i<10;i++) {
            boolean b = getNum(list, n, s * 10 + i);
            if(!b)break;
        }
        return true;
    }
}
