package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *        Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.
 */
public class MergeTwoSortedLists21 {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(-9);
        l1.next=new ListNode(3);
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(7);
        ListNode l3 = new MergeTwoSortedLists21().mergeTwoLists(l1,l2);
        System.out.println(1);
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode temp;
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val<l2.val){
            head=l1;
            l1=l1.next;
        }else {
            head=l2;
            l2=l2.next;
        }
        temp = head;

        while (l1!=null||l2!=null){
            if(l1==null){
                temp.next=l2;
                l2=l2.next;
            }
            else if(l2==null){
                temp.next=l1;
                l1=l1.next;
            }
            else if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }else if(l1.val>=l2.val){
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        return head;
    }
}


