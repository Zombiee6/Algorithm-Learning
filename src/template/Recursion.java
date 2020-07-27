package template;

/**
 * @author Billy
 * @date 2020/7/21 7:20 上午
 */
public class Recursion {
    //最大递归深度
    private static int MAX_LEVEL = 100;

    public void recursion(int level, int param) {
        //终止条件
        if (level > MAX_LEVEL) {
            return;
        }

        //处理逻辑
        //process(level,data);

        //递归
        recursion(level+1,param);

        //清理状态
        //reverseState(level)
    }
}
