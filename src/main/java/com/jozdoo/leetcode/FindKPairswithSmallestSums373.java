package com.jozdoo.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/2/8
 * @email jozdoo@gmail.com
 */
public class FindKPairswithSmallestSums373 {
    //1 2 3 4
    //3 5 7 8
    public static void main(String[] args) {

    }
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        if(k==0)return list;
        int p1 = 0;
        int p2 = 0;
        list.add(new int[]{nums1[p1],nums2[p2]});
        while (--k>0){
            if(p1+1<nums1.length&&p2+1<nums2.length){
                list.add((nums1[p1+1]+nums2[p2])>(nums1[p1]+nums2[p2+1])?new int[]{nums1[p1],nums2[++p2]}:new int[]{nums1[++p1],nums2[p2]});
            }else if(p1+1<nums1.length){
                list.add(new int[]{nums1[++p1],nums2[p2]});
            }else if(p2+1<nums2.length){
                list.add(new int[]{nums1[p1],nums2[++p2]});
            }
        }
        return list;
    }
}
