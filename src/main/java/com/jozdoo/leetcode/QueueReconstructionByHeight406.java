package com.jozdoo.leetcode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/3/27
 * @email jozdoo@gmail.com
 *        Input:
 *        [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
 *        []
 *        [5,0],,[7,0] [5,2],  [6,1],[4,4],  [7,1]
 *
 *        Output:
 *        [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */
public class QueueReconstructionByHeight406 {
    public static void main(String[] args) {
        int[][] ints = new QueueReconstructionByHeight406().reconstructQueue2(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}});
//        int[][] ints = new QueueReconstructionByHeight406().reconstructQueue2(new int[][]{{7, 0}});
        System.out.println(ints);
    }

    public int[][] reconstructQueue2(int[][] people) {
        LinkedList<int[]> list = new LinkedList();
        for (int[] person : people) {
            list.add(person);
        }

        Collections.sort(list, (o1, o2) -> {
            int first =  o2[0] - o1[0] ;
            int second = o1[1] - o2[1];
            if(first!=0)return first;
            return second;
        });
        LinkedList<int[]> list_sorted = new LinkedList();
        for (int[] wrongMan : list) {
            list_sorted.add(wrongMan[1],wrongMan);
        }
        for (int i = 0; i < people.length; i++) {
            people[i]=list_sorted.get(i);
        }
        return people;
    }
    public int[][] reconstructQueue(int[][] people) {
        if(people.length<=1)return people;
        LinkedList<int[]> list = new LinkedList();
        for (int[] person : people) {
            list.add(person);
        }
        int[] wrongMan = list.remove(0);
        while (wrongMan!=null){
            //insert wrongMan
            int z = wrongMan[1];
            for(int i=0;i<list.size();i++){
                if(z==0){
                    list.add(i,wrongMan);
                    wrongMan=null;
                    break;
                }
                if(list.get(i)[0]>=wrongMan[0]){
                    z--;
                }
                if(z==0){
                    list.add(i+1,wrongMan);
                    wrongMan=null;
                    break;
                }
            }

            //find wrongMan
            for (int i = 0; i < list.size(); i++) {
                int[] theMan = list.get(i);
                z = 0;
                for (int j = 0; j < i; j++) {
                    if(list.get(j)[0]>=theMan[0]){
                        z++;
                    }
                }
                if(z!=theMan[1]){
                    wrongMan=list.remove(i) ;
                    break;
                }
            }
        }
        for (int i = 0; i < people.length; i++) {
            people[i]=list.get(i);
        }
        return people;
    }
}
