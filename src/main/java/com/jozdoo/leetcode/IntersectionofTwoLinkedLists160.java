package com.jozdoo.leetcode;

import java.util.HashMap;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/27
 * @email jozdoo@gmail.com
 *        Write a program to find the node at which the intersection of two singly linked lists begins.
 *        For example, the following two linked lists:
 *        A: a1 → a2
     *                   ↘
     *                   c1 → c2 → c3
     *                   ↗
 *        B: b1 → b2 → b3
 *        a1 a2 c1 c2 c3 b1 b2
 *        b1 b2 b3 c1 c2 c3 a1
 *        begin to intersect at node c1.
 *        Notes:
 *        If the two linked lists have no intersection at all, return null.
 *        The linked lists must retain their original structure after the function returns.
 *        You may assume there are no cycles anywhere in the entire linked structure.
 *        Your code should preferably run in O(n) time and use only O(1) memory.
 */
public class IntersectionofTwoLinkedLists160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        HashMap<ListNode,Boolean>  map = new HashMap<>();
        ListNode result = null;
        while (headA!=null){
            map.put(headA,true);
            headA=headA.next;
        }
        while (headB!=null){
            if(map.containsKey(headB)){
                result=headB;
                break;
            }
            headB=headB.next;
        }
        return result;
    }
}
