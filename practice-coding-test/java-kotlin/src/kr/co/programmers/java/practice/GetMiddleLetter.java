package kr.co.programmers.java.practice;

public class GetMiddleLetter {

    public static void main(String[] args) {
        String s = "abcde";
        System.out.println(new Solution().solution(s));
    }

    static class Solution {
        public String solution(String s) {
            return s.length()%2 == 0 ? s.substring(s.length()/2 - 1, s.length()/2 + 1) : String.valueOf(s.charAt(s.length()/2));
        }
    }
}
