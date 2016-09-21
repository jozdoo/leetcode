package com.jozdoo.leetcode;

import java.util.ArrayList;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *        Given a linked list, remove the nth node from the end of list and return its head.
 *        For example,
 *        Given linked list: 1->2->3->4->5, and n = 2.
 *        After removing the second node from the end, the linked list becomes 1->2->3->5.
 */
public class RemoveNthNodeFromEndOfList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ArrayList<ListNode> listNodes = new ArrayList<>();
        ListNode temp = head;
        while (temp!=null){
            listNodes.add(temp);
            temp=temp.next;
        }
        if(listNodes.size()==1)return null;
        if(n==listNodes.size())return listNodes.get(1);
        ListNode remove = listNodes.get(listNodes.size()-n);
        ListNode beforeRemove = listNodes.get(listNodes.size()-n-1);
        beforeRemove.next=remove.next;
        return head;
    }
}

