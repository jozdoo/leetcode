package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 17/1/23
 * @email jozdoo@gmail.com
 */
public class RemoveLinkedListElements203 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        new ListNode(1,new ListNode(1,new ListNode(2,new ListNode(2,new ListNode(1,head)))));
        ListNode listNode = removeElements(head, 1);
        System.out.println(listNode);
    }
    public static ListNode removeElements(ListNode head, int val) {
        while(head!=null){
            if(head.val == val){
                head = head.next;
            }else {
                break;
            }
        }
        ListNode realNode = head;
        while(head!=null){
            ListNode nextNode = head.next;
            while(nextNode!=null&&nextNode.val == val){
                nextNode = nextNode.next;
                head.next = nextNode;
            }
            head = nextNode;
        }
        return realNode;
    }

     static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
        ListNode(int x,ListNode n){
            val = x;
            n.next = this;
        }
    }
}
