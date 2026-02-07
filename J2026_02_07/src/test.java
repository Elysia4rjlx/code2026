public class test {


    public static void main(String[] args) {
        String s = "abba123";
        System.out.printf("", solve(s));

    }
    // 题目要求：删除字符串中所有非数字字符，判断剩下的部分是否回文
    public static boolean solve(String s) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c); // 只把数字写在“白板”上
            }
        }
        // 直接翻转并对比内容
        String normal = sb.toString();
        String reversed = sb.reverse().toString();
        return normal.equals(reversed);
    }

    public static void main2(String[] args) {
        String s = "aaabaaa";
        StringBuilder sb = new StringBuilder(s);
        System.out.printf(sb.toString());
//        System.out.printf(s.substring(1,6));
    }




    public static void main1(String[] args) {
        Solution solution = new Solution();
        String s1 = "babad";
        System.out.println("输入:" + s1);
        System.out.printf("输出:" + solution.longestPalindrome(s1));
    }
}
