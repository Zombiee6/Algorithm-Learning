import java.util.ArrayList;
import java.util.List;

/**
 * @author Billy
 * @date 2020/2/25 4:28 下午
 */
public class JosephusProblem {
    public static void main(String[] args) {
        solvedByArrayList(5,2);
    }

    /**
     * 约瑟夫问题-ArrayList解法
     *
     * @param total 总人数
     * @param count 数到几出列
     */
    public static void solvedByArrayList(int total, int count){
        if(total == 0 || count == 0) {
            throw new RuntimeException("Invalid input");
        }
        if(total == 1 && count == 1) {
            throw new RuntimeException("Invalid input");
        }
        List<Integer> list = new ArrayList<Integer>();
        for(int i = 0; i < total; i++) {
            list.add(i);
        }
        //初值设为-1，
        int index = -1;
        while(list.size() > 1){
            index = (index+count)%list.size();
            System.out.println("当前队列：" + list);
            System.out.println("出局：" + list.get(index));
            list.remove(index);
            //从上一个位置开始计数
            index--;
        }
    }

}
