package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/22
 * @email jozdoo@gmail.com
 */
public class MinimumTimeDifference539 {
    public static void main(String[] args) {
        ArrayList<String> strings = new ArrayList<>();
        strings.add("23:59");
        strings.add("00:00");
        System.out.println(new MinimumTimeDifference539().findMinDifference(strings));
    }
    public int findMinDifference(List<String> timePoints) {
        timePoints.sort(String::compareTo);
        int min = betweenTime(timePoints.get(timePoints.size()-1),timePoints.get(0));
        for (int i = 1; i < timePoints.size(); i++) {
            int temp = betweenTime(timePoints.get(i - 1), timePoints.get(i));
            min = min>temp?temp:min;
        }
        return min;
    }
    public int betweenTime(String time1,String time2){
        int between = 0;
        String[] split1 = time1.split(":");
        String[] split2 = time2.split(":");
        int hour1 = Integer.parseInt(split1[0]);
        int min1 = Integer.parseInt(split1[1]);
        int hour2 = Integer.parseInt(split2[0]);
        int min2 = Integer.parseInt(split2[1]);
        if((hour1 * 60 + min1)<=(hour2 * 60 + min2)){
            between = (hour2 * 60 + min2)-(hour1 * 60 + min1);
        }else {
            between = (hour2*60+min2+24*60)-(hour1*60+min1);
        }
        return between;
    }
}
