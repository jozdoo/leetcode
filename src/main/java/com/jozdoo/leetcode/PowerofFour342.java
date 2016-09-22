package com.jozdoo.leetcode;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 16/9/22
 * @since 3.0
 *        Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 *        Example:
 *        Given num = 16, return true. Given num = 5, return false.
 *
 *        EA nagetive num
 *        AC
 */
public class PowerofFour342 {
    public static void main(String[] args) {
        System.out.println(new PowerofFour342().isPowerOfFour(64));
    }
    public boolean isPowerOfFour(int num) {
        if(num<1)return false;
        while (num>0){
            if((num&3)==0){
                num>>=2;
            }else if((num&3)==1){
                if(num>>2!=0)return false;
                else return true;
            }else {
                return false;
            }
        }
        return true;
    }
}
