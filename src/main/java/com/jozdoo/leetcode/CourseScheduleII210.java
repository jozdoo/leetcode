package com.jozdoo.leetcode;

import java.util.ArrayList;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/22
 * @since 3.0
 *        There are a total of n courses you have to take, labeled from 0 to n - 1.
 *        Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
 *        Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you should take to finish all courses.
 *        There may be multiple correct orders, you just need to return one of them. If it is impossible to finish all courses, return an empty array.
 *        For example:
 *        2, [[1,0]]
 *        There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1]
 *        4, [[1,0],[2,0],[3,1],[3,2]]
 *        There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 */
public class CourseScheduleII210 {
    private int[][] graph;

    private int[] leared;

    private int[] path;

    private int numCourses;

    private ArrayList<Integer> learnedOrder = new ArrayList<>();

    public static void main(String[] args) {
        int[] order = new CourseScheduleII210().findOrder(1, new int[][] { });
        System.out.println(1);
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
//        if(numCourses<=1&&pre)return new int[]{};
        this.numCourses = numCourses;
        graph = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]] = 1;
        }
        leared = new int[numCourses];
        path = new int[numCourses];
        boolean b = true;
        for (int i = 0; i < numCourses; i++) {
            boolean loop = loop(i);
            if (!loop) {
                b = false;
                break;
            }
        }
        if (!b)
            return new int[] {};

        int[] result = new int[numCourses];
        for (int i = 0; i < learnedOrder.size(); i++) {
            result[i] = learnedOrder.get(i);
        }
        return result;
    }

    public boolean loop(int course) {
        if (leared[course] == 1)
            return true;
        if (path[course] == 1)
            return false;
        path[course] = 1;
        boolean hasSamePath = false;
        for (int i = 0; i < numCourses ; i++) {
            if (graph[course][i] == 1) {
                boolean loop = loop(i);
                if (!loop) {
                    hasSamePath = true;
                    break;
                }
            }
        }
        path[course] = 0;
        if (!hasSamePath) {
            leared[course] = 1;
            learnedOrder.add(course);
        }
        return !hasSamePath;
    }
}
