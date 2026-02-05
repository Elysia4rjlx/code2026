class Solution {

    //
    //No. 125 Valid Palindrome (验证回文串)
    public boolean isPalindrome(String s) {
        //1.字符串转数组 toCharArray()
        char[] str = s.toCharArray();
        //2.双指针
        int left = 0;
        int right = str.length - 1;

        while (left < right) {
            //3.找有效字符 isLetterOrDigit()判断是不是字符或者数字
            while (left < right && !Character.isLetterOrDigit(str[left])) {
                left++;
            }
            while (left < right && !Character.isLetterOrDigit(str[right])) {
                right--;
            }
            //4.将拿到的字符转换为小写再比较
            char ch1 = Character.toLowerCase(str[left]);
            char ch2 = Character.toLowerCase(str[right]);

            if (ch1 != ch2) {
                return false;
            }

            left++;
            right--;
        }
        return true;
    }


    // 14. 最长公共前缀
    public String longestCommonPrefix1(String[] strs) {

        //解法1 两两比较
        String ret = strs[0];
        for (int i = 1; i < strs.length; i++) {
            ret = findCommon(ret,strs[i]);
        }
        return ret;
    }

    private String findCommon(String ret, String str) {
        int i = 0;
        while (i < Math.min(ret.length(),str.length()) && ret.charAt(i) == str.charAt(i) ){
            i++;
        }
        return ret.substring(0,i);
    }

    public String longestCommonPrefix2(String[] strs){

        //解法2 统一比较
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != ch){
                    return strs[0].substring(0,i);
                }
            }
        }
        return strs[0];
    }




















}