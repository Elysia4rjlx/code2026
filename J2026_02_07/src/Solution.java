public class Solution {
    private int maxStrart = 0;
    private int maxLen = 0;

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        for (int i = 0; i < s.length(); i++) {
            //奇数长度
            extend(s, i, i);
            //偶数长度
            extend(s, i, i + 1);
        }
        return s.substring(maxStrart,maxStrart + maxLen);
    }

    private void extend(String s, int left, int right) {
        while (left >= 0 && right < s.length() &&
                s.charAt(left) == s.charAt(right)) {
// 核心循环：只要不越界，且字符相等，就一直扩
            left--;
            right++;
        }
        int len = right - left - 1;

        if (len > maxLen) {
            maxLen = len;
            maxStrart = left + 1;
        }
    }
}
