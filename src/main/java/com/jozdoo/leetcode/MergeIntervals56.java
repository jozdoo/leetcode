package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/18
 * @since 3.0
 */
class Interval {
    int start;

    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int a, int b) {
        start = a;
        end = b;
    }

    @Override
    public String toString() {
        return "{" + "start=" + start + ", end=" + end + '}';
    }
}

public class MergeIntervals56 {
    public static void main(String[] args) {
        List<Interval> list = new ArrayList<Interval>();
        Interval interval = new Interval(2, 3);
        Interval interval1 = new Interval(5, 5);
        Interval interval2 = new Interval(2, 2);
        Interval interval3 = new Interval(3, 4);
        Interval interval4 = new Interval(3, 4);
        list.add(interval);
        list.add(interval1);
        list.add(interval2);
        list.add(interval4);
        list.add(interval4);
        List<Interval> merge = merge(list);
        System.out.println(merge);

    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        intervals = new ArrayList<>(intervals);
        intervals.sort((a, b) -> {
            int i = a.start - b.start;
            if(i==0)return a.end-b.end;
            return i;
        });
        for (int i=0;i<intervals.size();i++){
            Interval interval = intervals.get(i);
            if(i==intervals.size()-1){
                result.add(interval);
                break;
            }
            Interval nextInterval = intervals.get(i+1);
            if(nextInterval.end<=interval.end){
                nextInterval.start=interval.start;
                nextInterval.end=interval.end;
            }else if(nextInterval.start<=interval.end){
                nextInterval.start=interval.start;
            }else{
                result.add(interval);
            }
        }
        return result;
    }
}
