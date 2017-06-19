package com.jozdoo.leetcode;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jozdoo
 * @company 杭州尚尚签网络科技有限公司
 * @date 2017/6/19
 * @email jozdoo@gmail.com
 */
public class FractionAdditionandSubtraction592 {
    public static void main(String[] args) {
        System.out.println(new FractionAdditionandSubtraction592().fractionAddition("-5/2+10/3+7/9"));
    }
    public String fractionAddition(String expression) {
        Fraction result = new Fraction("0/1");
        Pattern pattern = Pattern.compile("[+-]?\\d+/\\d+");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()){
            String group = matcher.group();
            result = result.add(new Fraction(group));
        }
        return result.toString();
    }
    class Fraction{
        int numerator;
        int denominator;
        public Fraction(String s){
            String[] split = s.split("/");
            numerator = Integer.parseInt(split[0]);
            denominator = Integer.parseInt(split[1]);
        }
        public Fraction add(Fraction f){
            Fraction fraction = new Fraction(this.toString());
            fraction.numerator = fraction.numerator*f.denominator+f.numerator*fraction.denominator;
            fraction.denominator = fraction.denominator*f.denominator;
            for (int i = 2; i <= fraction.denominator; i++) {
                while (fraction.denominator%i==0&&fraction.numerator%i==0){
                    fraction.denominator/=i;
                    fraction.numerator/=i;
                }
            }
            return fraction;
        }

        @Override
        public String toString() {
            return String.valueOf(this.numerator)+"/"+String.valueOf(this.denominator);
        }
    }
}
