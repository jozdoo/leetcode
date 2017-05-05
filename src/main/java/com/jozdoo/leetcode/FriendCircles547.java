package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/5/5
 * @email jozdoo@gmail.com
 *
 *        There are N students in a class. Some of them are friends, while some are not. Their friendship is transitive in nature. For example, if A is a direct friend of B, and B is a direct friend of C, then A is an indirect friend of C. And we defined a friend circle is a group of students who are direct or indirect friends.
 *        Given a N*N matrix M representing the friend relationship between students in the class. If M[i][j] = 1, then the ith and jth students are direct friends with each other, otherwise not. And you have to output the total number of friend circles among all the students.
 *        Example 1:
 *        Input:
 *        [[1,1,0],
 *        [1,1,0],
 *        [0,0,1]]
 *        Output: 2
 *        Explanation:The 0th and 1st students are direct friends, so they are in a friend circle.
 *        The 2nd student himself is in a friend circle. So return 2.
 *        Example 2:
 *        Input:
 *        [[1,1,0],
 *        [1,1,1],
 *        [0,1,1]]
 *        Output: 1
 *        Explanation:The 0th and 1st students are direct friends, the 1st and 2nd students are direct friends,
 *        so the 0th and 2nd students are indirect friends. All of them are in the same friend circle, so return 1.
 *        Note:
 *        N is in range [1,200].
 *        M[i][i] = 1 for all students.
 *        If M[i][j] = 1, then M[j][i] = 1.
 */
public class FriendCircles547 {
    private int result = 0;
    public int findCircleNum(int[][] M) {
        int N = M.length;
        for (int i = 0; i < N; i++) {
            if(M[i][i]==1){
                result++;
                markFriend(N,i,M);
            }
        }
        return result;
    }
    private void markFriend(int N,int n,int[][] M){
        if(M[n][n]!=1)return;
        M[n][n] = 2;
        for (int i = 0; i < N; i++) {
            if(M[n][i]==1){
                markFriend(N,i,M);
            }
        }
    }
}
