package topinterviewquestions;
//ac
//子串，子序列如何去求,经典的想法,值得这么去尝试
//假设以i位置结尾的情况下，答案是什么
//也就是必须以i位置结尾的情况下，最长无重复子串有多长,每个位置结尾的情况下答案都求出来，
//取所有答案中的最大值就是我们的总答案
//求所有可能的结尾
public class Problem_0003_LongestSubstringWithoutRepeatingCharacters {
    //i位置结尾的情况下，往左推，推不动的第一个因素为当前字符上次出现的位置，越不过此线
    //第二个因素i-1位置结尾的情况下，往左推了多远，也越不过此线
    //这两个因素谁离你近，谁就是你往左推不倒的位置

    //map大小选择256和128都可以 a~z 97~122 大写在小写前面，如果只有字母，都可以
    //如果还有其他字符 就得是256
    //如果只有小写，可以搞成26大小,减掉a的ASCII就可以

    //时间复杂度o(n),额外空间复杂度o(1)
    //hash表常数级别时间复杂度比较高，能不用就不用
    public static int lengthOfLongestSubstring(String s) {
        if(s == null||s.length()==0){
            return 0;
        }
        char[] str = s.toCharArray();
        int[] map = new int[256];
        for(int i = 0;i < map.length;i++){
            map[i] = -1;
        }
        int len = 0;//收集答案
        int pre = -1;//i-1位置的字符往左推，推不动的位置在哪里
        int cur = 0;
        for(int i = 0;i < str.length;i++){
            //计算当前位置的字符往左推，推不动的位置在哪
            //上一次i位置字符出现的位置和i-1字符推不动的位置取最大值
            pre = Math.max(pre,map[str[i]]);
            cur = i-pre;//以i位置结尾的时候，最长的无重复子串长度有多长
            len = Math.max(cur,len);
            map[str[i]] = i;//记录i位置的字符最后出现的位置
        }
        return len;
    }
    //此方法为自己的方法 在leetcode上测试通过、
    //以窗口左边界为准，求每一个左边界对应的答案
    //上一个方法中map记录i位置的字符最后出现的位置
    //此方法中map记录滑动窗口当中每一个字符是否出现 含义截然不同
    public static int lengthOfLongestSubstring1(String s) {
        if(s == null||s.length()==0){
            return 0;
        }
        char[] str = s.toCharArray();
        int[] map = new int[256];
        for(int i = 0;i < map.length;i++){
            map[i] = -1;
        }
        int len = 0;//收集答案
        int L = 0;
        int R = 0;
        for(L = 0;L < s.length();L++){
            while(R < s.length()&&map[str[R]]==-1){
                map[str[R]] = R;// = 0也可以 因为记录的是字符是否出现过
                R++;
            }
            len = Math.max(len,R-L);
            map[str[L]] = -1;
        }
        return len;
    }
}
