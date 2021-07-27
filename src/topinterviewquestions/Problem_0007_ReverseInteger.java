package topinterviewquestions;
//两种都ac
//把所有的x搞成负数,如果是负数则不变,如果不是负数搞成负数
//因为负数可以表达的绝对值域比整数可以表达的域大一个
//不是所有的负数都可以转成正数去处理的，但是所有的正数都可以转成负数去处理最后再决定符号的
public class Problem_0007_ReverseInteger {
    public static int reverse(int x) {
        boolean neg = ((x>>31) & 1) == 1; //	boolean neg = x < 0 ? true:false; 判断x是否为负数
        x = neg? x:-x;
        int m = Integer.MIN_VALUE/10;
        int o = Integer.MIN_VALUE%10;
        int res = 0;
        while(x!=0){
            if(res < m || res==m&&x%10<o){ // 因为x为负数，所以只用判断当前负数是否越界即可
                return 0;
            }
            res = res*10+x%10;
            x /=10;
        }
        return neg? x : Math.abs(x);
    }

    public static void main(String[] args){
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
    //更简单的做法
    public static int reverse2(int x) {
        long n = 0;
        while(x != 0) {
            n = n*10 + x%10;
            x = x/10;
        }
        return (int)n==n? (int)n:0;
    }

}
