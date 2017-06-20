package com.jozdoo.leetcode;

import java.util.Random;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/19
 * @email jozdoo@gmail.com
 */
public class LinkedListRandomNode382 {
    ListNode head;
    Random  random = new Random();
    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode382(ListNode head) {
        this.head=head;
    }

    /** Returns a random node's value. */
    public int getRandom() {
        ListNode c = head;
        int r= c.val;
        for (int i = 1; c.next!=null; i++) {
            c = c.next;
            if (random.nextInt(i)==i) r = c.val;
        }
        return r;
    }
}
