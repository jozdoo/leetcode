package com.jozdoo.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/22
 * @email jozdoo@gmail.com
 */
public class FourSumII454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int count = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < B.length; j++) {
                map.put(A[i]+B[j],map.getOrDefault(A[i]+B[j],0)+1);
            }
        }
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < D.length; j++) {
                count += map.getOrDefault(-C[i]-D[j],0);
            }
        }
        return count;
    }
}
