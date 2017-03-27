package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/3/27
 * @email jozdoo@gmail.com
 */
public class FindBottomLeftTreeValue513 {

    public static int deep = 0;
    public static int maxDeep =0;
    public static Integer val = null;
    public static int findBottomLeftValue(TreeNode root) {
        if(val==null)val=root.val;
        if(deep>maxDeep){
            maxDeep = deep;
            val = root.val;
        }
        if(root.left!=null){
            deep++;
            findBottomLeftValue(root.left);
            deep--;
        }
        if(root.right!=null){
            deep++;
            findBottomLeftValue(root.right);
            deep--;
        }
        return val;
    }
}
