package com.jozdoo.leetcode;

import java.util.LinkedList;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/4/6
 * @email jozdoo@gmail.com
 *
 * 1
 * 1 1
 * 1 2 1+1
 * 2 2 2
 * 1 2 3 2+1
 * 3 2 2 3
 * 1 2 3 4
 * 4 3 2 2
 */
public class BeautifulArrangement536 {
    public static void main(String[] args) {
        for (int i = 1 ; i <16 ; i++) {
            BeautifulArrangement536 beautifulArrangement536 = new BeautifulArrangement536();
            System.out.println(beautifulArrangement536.countArrangement(i));
        }
    }
    public int count = 0;
    public int[] used ;
    public int N;
    LinkedList<LinkedList<Integer>> linkedLists;
//    public int countArrangement(int N) {
//        int[] i = new int[]{1,2,3,8,10,36,41,132,250,700,750,4010,4237,10680,24679};
//        return i[N-1];
//    }
    public int countArrangement(int N) {
        this.N =N;
        //组成每个位置能够填入的数字
        linkedLists = new LinkedList<>();
        linkedLists.add(null);
        for (int i = 1; i <=N ; i++) {
            LinkedList<Integer> integers = new LinkedList<>();
            linkedLists.add(integers);
            for (int j = 1; j <=N ; j++) {
                if((j>=i&&j%i==0)||(i>=j&&i%j==0)){
                    integers.add(j);
                }
            }
        }
        used = new int[N+1];
        tb(1,0);
        return count;
    }
    public void tb(int a,int b){
        if(a>N){
            count++;
            return;
        }
        LinkedList<Integer> integers = linkedLists.get(a);
        while (integers.size()>b){
            Integer integer = integers.get(b);
            if(used[integer]==0) {
                used[integer] = 1;
                tb(a+1,0);
                used[integer] = 0;
            }
            b++;
        }

    }
}
