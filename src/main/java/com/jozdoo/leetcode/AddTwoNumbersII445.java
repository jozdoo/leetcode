package com.jozdoo.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/20
 * @email jozdoo@gmail.com
 */
public class AddTwoNumbersII445 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(9);
        l1.next = new ListNode(9);
        l1.next.next = new ListNode(9);
        l1.next.next.next = new ListNode(9);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(9);
        l2.next.next = new ListNode(9);
        ListNode listNode = new AddTwoNumbersII445().addTwoNumbers(l1, l2);
        while (listNode!=null){
            System.out.print(listNode.val+",");
            listNode = listNode.next;
        }
    }
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int l1Length =0;
        int l2Length =0;
        ListNode l1Curr = l1;
        ListNode l2Curr = l2;

        while (l1Curr!=null){
            l1Length++;
            l1Curr = l1Curr.next;
        }
        while (l2Curr!=null){
            l2Length++;
            l2Curr = l2Curr.next;
        }

        if(l1Length>l2Length){
            for (int i = 0; i < l1Length-l2Length; i++) {
                ListNode listNode = new ListNode(0);
                listNode.next=l2;
                l2 = listNode;
            }
        }else {
            for (int i = 0; i < l2Length-l1Length; i++) {
                ListNode listNode = new ListNode(0);
                listNode.next=l1;
                l1 = listNode;
            }
        }
        int maxLength = l1Length>l2Length?l1Length:l2Length;
        ListNode l3 = new ListNode(0);
        ListNode l3Head = l3;
        List<ListNode> l9 = new LinkedList<>();
        l9.add(l3);
        for (int i = 0; i < maxLength; i++) {
            ListNode l3Next = new ListNode(0);
            int i1 = l1.val + l2.val;
            if (i1>9){
                l3Next.val = i1%10;
                boolean flag = true;
                while (flag) {
                    for (ListNode listNode : l9) {
                        int i2 = listNode.val + 1;
                        if(i2==10){
                            listNode.val = 0;
                        }else {
                            listNode.val = i2;
                            flag = false;
                        }
                    }
                }
                l9.clear();
                l9.add(l3Next);

            }else {
                l3Next.val = i1;
                if(i1!=9){
                    l9.clear();
                }
                l9.add(0,l3Next);
            }
            l3.next = l3Next;
            l3 = l3Next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l3Head.val==0)return l3Head.next;
        return l3Head;
    }
}
