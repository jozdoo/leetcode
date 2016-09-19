package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/19
 * @email jozdoo@gmail.com
 * 根据输入产生图,判断是否为有环图
 * 38行忘记回溯
 * 超时,再用一个数组记录通过数据
 * AC
 */
public class CourseSchedule207 {
    public static void main(String[] args) {
        int numCourses = 3;
        int[][] prerequisites = new int[][]{{0,1},{0,2},{1,2},{2,1}};
        System.out.println(new CourseSchedule207().canFinish(numCourses,prerequisites));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] passCourse = new int[numCourses];
        int[][] graph = new int[numCourses][numCourses];
        for (int[] prerequisite : prerequisites) {
            graph[prerequisite[0]][prerequisite[1]]=1;
        }
        for(int i=0;i<numCourses;i++){
            int[] taked = new int[numCourses];
            boolean b = dpCourse(graph, taked, numCourses, i,passCourse);
            if(!b)return false;
        }
        return true;
    }
    public boolean dpCourse(int[][] graph,int[] taked,int numCourses,int courseNo,int[] passCourse){
        if(passCourse[courseNo]==1)return true;
        if(taked[courseNo]==1)return false;
        taked[courseNo]=1;
        for(int i=0;i<numCourses;i++){
            if(graph[courseNo][i]==1){
                boolean b = dpCourse(graph, taked, numCourses, i,passCourse);
                if(!b)return false;
            }
        }
        taked[courseNo]=0;
        passCourse[courseNo]=1;
        return true;
    }
}
