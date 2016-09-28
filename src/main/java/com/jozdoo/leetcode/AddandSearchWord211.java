package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/21
 * @since 3.0
 *        Design a data structure that supports the following two operations:
 *        void addWord(word)
 *        bool search(word)
 *        search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 *        For example:
 *        addWord("bad")
 *        addWord("dad")
 *        addWord("mad")
 *        search("pad") -> false
 *        search("bad") -> true
 *        search(".ad") -> true
 *        search("b..") -> true
 *        Note:
 *        You may assume that all words are consist of lowercase letters a-z.
 */
public class AddandSearchWord211 {


    public static void main(String[] args) {
        System.out.println('c'-'a');
        AddandSearchWord211 a = new AddandSearchWord211();
        a.addWord("aaaaz");
        a.addWord("aba");
        a.addWord("");
        a.addWord("ada");
        System.out.println(a.search(""));
    }

    private final int charsNum = 'z'-'a'+1;
    ListTreeNode root = new ListTreeNode();

    public void addWord(String word) {
        ListTreeNode currNode = root;
        char[] chars = word.toCharArray();
        for (char c : chars) {
            if(currNode.listTreeNodes[c-'a']==null){
                currNode.listTreeNodes[c-'a']=new ListTreeNode();
            }
            currNode = currNode.listTreeNodes[c-'a'];
        }
        currNode.isEnd=true;
    }

    public boolean search(String word) {
        char[] chars = word.toCharArray();
        return search(root,chars,0);
    }

    public boolean search(ListTreeNode root,char[] chars,int index){
        if(index==chars.length&&root!=null&&root.isEnd)return true;
        if(index==chars.length)return false;
        char c = chars[index];
        if(c=='.'){
            for (ListTreeNode listTreeNode : root.listTreeNodes) {
                if(listTreeNode!=null){
                    boolean search = search(listTreeNode, chars, index+1);
                    if(search)return true;
                }
            }

        }else {
            ListTreeNode listTreeNode = root.listTreeNodes[c-'a'];
            if (listTreeNode != null) {
                boolean search =search(listTreeNode,chars,index+1);
                if(search)return true;
            }
        }
        return false;
    }

    class ListTreeNode {
        boolean isEnd=false;
        ListTreeNode[] listTreeNodes = new ListTreeNode[charsNum];
    }
}
