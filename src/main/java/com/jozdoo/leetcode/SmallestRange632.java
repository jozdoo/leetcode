package com.jozdoo.leetcode;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/7/13
 * @email jozdoo@gmail.com
 */
public class SmallestRange632 {
    public static void main(String[] args) {
        String s = "[[95387,95790,97307,98168,99868,99995,99995,100000],[-69454,-17042,8172,50983,63432,72854,73012,80848,83723,85916,91759,99779,99913,99944,99994,99999,99999],[65641,95910,97995,98196,98969,99008,99591,99732,99735,99896,99952,99989,99999,100000],[57459,95855,97360,98320,99147,99865,99955,99989,99997,99998,100000],[-81589,-3474,84141,92981,95255,99192,99962,99970,99994,99998,99999,100000],[-23262,92924,95548,96462,99338,99553,99555,99569,99644,99903,99909,99999,99999,100000],[-58466,24432,87898,92795,95701,98143,98163,99182,99351,99746,99811,99943,99955,99978,99997,100000],[-97588,7867,10356,20288,67836,69868,73038,77753,81937,88474,89979,92182,98091,99635,99902,99941,99975,99987,99991,99998,99998,99998,99998,99998,99999,99999,99999,100000],[-96955,41521,84537,89794,96226,97103,97490,99347,99957,99997,100000],[-49247,93963,99006,99428,99964,99992,100000],[46062,48599,95745,98620,98677,99516,99802,99973,99993,100000],[-3786,59724,62870,80033,90471,98836,99395,99574,99682,99724,99909,99963,99979,99999,100000],[-62512,-19463,84187,89388,91368,95524,98987,99085,99230,99809,99978,100000],[18183,83019,98718,99570,99777,99980,100000],[19925,20448,81509,93698,98451,98776,98915,99007,99925,99994,99996,99999,100000],[-96129,93245,95417,98492,99013,99921,99934,99989,99995,100000],[-25468,61948,68372,85478,91239,98906,98988,99653,99915,99957,99998,99999,99999,100000],[36648,65266,95679,98905,99868,99977,99983,99983,99995,99995,99996,99997,100000],[56006,78969,86785,89834,92494,93887,98268,99771,99982,99998,99999,100000],[95387,95790,97307,98168,99868,99995,99995,100000],[-69454,-17042,8172,50983,63432,72854,73012,80848,83723,85916,91759,99779,99913,99944,99994,99999,99999],[65641,95910,97995,98196,98969,99008,99591,99732,99735,99896,99952,99989,99999,100000],[57459,95855,97360,98320,99147,99865,99955,99989,99997,99998,100000],[-81589,-3474,84141,92981,95255,99192,99962,99970,99994,99998,99999,100000],[-23262,92924,95548,96462,99338,99553,99555,99569,99644,99903,99909,99999,99999,100000],[-58466,24432,87898,92795,95701,98143,98163,99182,99351,99746,99811,99943,99955,99978,99997,100000],[-97588,7867,10356,20288,67836,69868,73038,77753,81937,88474,89979,92182,98091,99635,99902,99941,99975,99987,99991,99998,99998,99998,99998,99998,99999,99999,99999,100000],[-96955,41521,84537,89794,96226,97103,97490,99347,99957,99997,100000],[-49247,93963,99006,99428,99964,99992,100000],[46062,48599,95745,98620,98677,99516,99802,99973,99993,100000],[-3786,59724,62870,80033,90471,98836,99395,99574,99682,99724,99909,99963,99979,99999,100000],[-62512,-19463,84187,89388,91368,95524,98987,99085,99230,99809,99978,100000],[18183,83019,98718,99570,99777,99980,100000],[19925,20448,81509,93698,98451,98776,98915,99007,99925,99994,99996,99999,100000],[-96129,93245,95417,98492,99013,99921,99934,99989,99995,100000],[-25468,61948,68372,85478,91239,98906,98988,99653,99915,99957,99998,99999,99999,100000],[36648,65266,95679,98905,99868,99977,99983,99983,99995,99995,99996,99997,100000],[56006,78969,86785,89834,92494,93887,98268,99771,99982,99998,99999,100000],[95387,95790,97307,98168,99868,99995,99995,100000],[-69454,-17042,8172,50983,63432,72854,73012,80848,83723,85916,91759,99779,99913,99944,99994,99999,99999],[65641,95910,97995,98196,98969,99008,99591,99732,99735,99896,99952,99989,99999,100000],[57459,95855,97360,98320,99147,99865,99955,99989,99997,99998,100000],[-81589,-3474,84141,92981,95255,99192,99962,99970,99994,99998,99999,100000],[-23262,92924,95548,96462,99338,99553,99555,99569,99644,99903,99909,99999,99999,100000],[-58466,24432,87898,92795,95701,98143,98163,99182,99351,99746,99811,99943,99955,99978,99997,100000],[-97588,7867,10356,20288,67836,69868,73038,77753,81937,88474,89979,92182,98091,99635,99902,99941,99975,99987,99991,99998,99998,99998,99998,99998,99999,99999,99999,100000],[-96955,41521,84537,89794,96226,97103,97490,99347,99957,99997,100000],[-49247,93963,99006,99428,99964,99992,100000],[46062,48599,95745,98620,98677,99516,99802,99973,99993,100000],[-3786,59724,62870,80033,90471,98836,99395,99574,99682,99724,99909,99963,99979,99999,100000],[-62512,-19463,84187,89388,91368,95524,98987,99085,99230,99809,99978,100000],[18183,83019,98718,99570,99777,99980,100000],[19925,20448,81509,93698,98451,98776,98915,99007,99925,99994,99996,99999,100000],[-96129,93245,95417,98492,99013,99921,99934,99989,99995,100000],[-25468,61948,68372,85478,91239,98906,98988,99653,99915,99957,99998,99999,99999,100000],[36648,65266,95679,98905,99868,99977,99983,99983,99995,99995,99996,99997,100000],[56006,78969,86785,89834,92494,93887,98268,99771,99982,99998,99999,100000],[95387,95790,97307,98168,99868,99995,99995,100000],[-69454,-17042,8172,50983,63432,72854,73012,80848,83723,85916,91759,99779,99913,99944,99994,99999,99999],[65641,95910,97995,98196,98969,99008,99591,99732,99735,99896,99952,99989,99999,100000],[57459,95855,97360,98320,99147,99865,99955,99989,99997,99998,100000],[-81589,-3474,84141,92981,95255,99192,99962,99970,99994,99998,99999,100000],[-23262,92924,95548,96462,99338,99553,99555,99569,99644,99903,99909,99999,99999,100000],[-58466,24432,87898,92795,95701,98143,98163,99182,99351,99746,99811,99943,99955,99978,99997,100000],[-97588,7867,10356,20288,67836,69868,73038,77753,81937,88474,89979,92182,98091,99635,99902,99941,99975,99987,99991,99998,99998,99998,99998,99998,99999,99999,99999,100000],[-96955,41521,84537,89794,96226,97103,97490,99347,99957,99997,100000],[-49247,93963,99006,99428,99964,99992,100000],[46062,48599,95745,98620,98677,99516,99802,99973,99993,100000],[-3786,59724,62870,80033,90471,98836,99395,99574,99682,99724,99909,99963,99979,99999,100000],[-62512,-19463,84187,89388,91368,95524,98987,99085,99230,99809,99978,100000],[18183,83019,98718,99570,99777,99980,100000],[19925,20448,81509,93698,98451,98776,98915,99007,99925,99994,99996,99999,100000],[-96129,93245,95417,98492,99013,99921,99934,99989,99995,100000],[-25468,61948,68372,85478,91239,98906,98988,99653,99915,99957,99998,99999,99999,100000],[36648,65266,95679,98905,99868,99977,99983,99983,99995,99995,99996,99997,100000],[56006,78969,86785,89834,92494,93887,98268,99771,99982,99998,99999,100000],[95387,95790,97307,98168,99868,99995,99995,100000],[-69454,-17042,8172,50983,63432,72854,73012,80848,83723,85916,91759,99779,99913,99944,99994,99999,99999],[65641,95910,97995,98196,98969,99008,99591,99732,99735,99896,99952,99989,99999,100000],[57459,95855,97360,98320,99147,99865,99955,99989,99997,99998,100000],[-81589,-3474,84141,92981,95255,99192,99962,99970,99994,99998,99999,100000],[-23262,92924,95548,96462,99338,99553,99555,99569,99644,99903,99909,99999,99999,100000],[-58466,24432,87898,92795,95701,98143,98163,99182,99351,99746,99811,99943,99955,99978,99997,100000],[-97588,7867,10356,20288,67836,69868,73038,77753,81937,88474,89979,92182,98091,99635,99902,99941,99975,99987,99991,99998,99998,99998,99998,99998,99999,99999,99999,100000],[-96955,41521,84537,89794,96226,97103,97490,99347,99957,99997,100000],[-49247,93963,99006,99428,99964,99992,100000],[46062,48599,95745,98620,98677,99516,99802,99973,99993,100000],[-3786,59724,62870,80033,90471,98836,99395,99574,99682,99724,99909,99963,99979,99999,100000],[-62512,-19463,84187,89388,91368,95524,98987,99085,99230,99809,99978,100000],[18183,83019,98718,99570,99777,99980,100000],[19925,20448,81509,93698,98451,98776,98915,99007,99925,99994,99996,99999,100000],[-96129,93245,95417,98492,99013,99921,99934,99989,99995,100000],[-25468,61948,68372,85478,91239,98906,98988,99653,99915,99957,99998,99999,99999,100000],[36648,65266,95679,98905,99868,99977,99983,99983,99995,99995,99996,99997,100000],[56006,78969,86785,89834,92494,93887,98268,99771,99982,99998,99999,100000],[95387,95790,97307,98168,99868,99995,99995,100000],[-69454,-17042,8172,50983,63432,72854,73012,80848,83723,85916,91759,99779,99913,99944,99994,99999,99999],[65641,95910,97995,98196,98969,99008,99591,99732,99735,99896,99952,99989,99999,100000],[57459,95855,97360,98320,99147,99865,99955,99989,99997,99998,100000],[-81589,-3474,84141,92981,95255,99192,99962,99970,99994,99998,99999,100000],[-23262,92924,95548,96462,99338,99553,99555,99569,99644,99903,99909,99999,99999,100000],[-58466,24432,87898,92795,95701,98143,98163,99182,99351,99746,99811,99943,99955,99978,99997,100000],[-97588,7867,10356,20288,67836,69868,73038,77753,81937,88474,89979,92182,98091,99635,99902,99941,99975,99987,99991,99998,99998,99998,99998,99998,99999,99999,99999,100000],[-96955,41521,84537,89794,96226,97103,97490,99347,99957,99997,100000],[-49247,93963,99006,99428,99964,99992,100000],[46062,48599,95745,98620,98677,99516,99802,99973,99993,100000],[-3786,59724,62870,80033,90471,98836,99395,99574,99682,99724,99909,99963,99979,99999,100000],[-62512,-19463,84187,89388,91368,95524,98987,99085,99230,99809,99978,100000],[18183,83019,98718,99570,99777,99980,100000],[19925,20448,81509,93698,98451,98776,98915,99007,99925,99994,99996,99999,100000],[-96129,93245,95417,98492,99013,99921,99934,99989,99995,100000],[-25468,61948,68372,85478,91239,98906,98988,99653,99915,99957,99998,99999,99999,100000],[36648,65266,95679,98905,99868,99977,99983,99983,99995,99995,99996,99997,100000],[56006,78969,86785,89834,92494,93887,98268,99771,99982,99998,99999,100000]]";
//        String s = "[[4,10,15,24,26,30],[0,9,12,20,29],[5,18,22,30]]";
        List<List<Integer>> lists1 = JSON.parseObject(s, new TypeReference<List<List<Integer>>>() {
        });
        int[] ints = new SmallestRange632().smallestRange(lists1);
        System.out.println(ints[0]+""+ints[1]);
    }
    public int[] smallestRange(List<List<Integer>> nums) {
        int[] rightIndexs = new int[nums.size()];
        int[] leftIndexs = new int[nums.size()];
        int[] lineNums = new int[nums.size()];
        int minNum = Integer.MAX_VALUE,maxNUm = Integer.MIN_VALUE;
        for (List<Integer> num : nums) {
            minNum = num.get(0)<minNum ? num.get(0):minNum;
            maxNUm = num.get(num.size()-1)>maxNUm ? num.get(num.size()-1):maxNUm;
        }
        int left=minNum,right=maxNUm;
        int curLeft=minNum-1,curRight=minNum-1;
        boolean rangeFlag = false;
        while (curLeft<=curRight&&(curRight<maxNUm||rangeFlag)){
            if(!rangeFlag){
                curRight = maxNUm;
                for (int i = 0; i < nums.size(); i++) {
                    List<Integer> list = nums.get(i);
                    int a;
                    if(rightIndexs[i]<list.size())a = list.get(rightIndexs[i]);
                    else continue;
                    if(a<curRight)curRight = a;
                }
                for (int i = 0; i < nums.size(); i++) {
                    List<Integer> list = nums.get(i);
                    while(rightIndexs[i]<nums.get(i).size()&&list.get(rightIndexs[i])==curRight){
                        rightIndexs[i]++;
                        lineNums[i]++;
                    }
                }
            }
            if(rangeFlag){
                curLeft = maxNUm;
                for (int i = 0; i < nums.size(); i++) {
                    List<Integer> list = nums.get(i);
                    int a;
                    if(leftIndexs[i]<list.size())a = list.get(leftIndexs[i]);
                    else  continue;
                    if(a<curLeft)curLeft = a;
                }
                if(right-left>curRight-curLeft){
                    left = curLeft;
                    right = curRight;
                }
                for (int i = 0; i < nums.size(); i++) {
                    List<Integer> list = nums.get(i);
                    while(leftIndexs[i]<nums.get(i).size()&&list.get(leftIndexs[i])==curLeft){
                        leftIndexs[i]++;
                        lineNums[i]--;
                    }
                }
            }
            for (int i = 0; i < lineNums.length; i++) {
                if(lineNums[i]<=0){
                    rangeFlag=false;
                    break;
                }
                if(i==lineNums.length-1){
                    rangeFlag = true;
                    if(right-left>curRight-curLeft){
                        left = curLeft;
                        right = curRight;
                    }
                }
            }

        }
        return new int[]{left,right};
    }
}
