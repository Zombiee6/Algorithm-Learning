import java.util.ArrayList;

/**
 * @author Billy
 * @date 2020/2/25 4:28 下午
 */
public class JosephusProblemArrayList {
    public static void main(String[] args) {

    }

    public static void josephus(){
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 1; i <= total; i++) {
            list.add("person-"+i);
        }

        int startIndex = start - 1;
        int countActual = count - 1;
        while(list.size() > 0) {
            startIndex = (startIndex + countActual) % list.size();

            System.out.println(list);
            System.out.println(list.get(startIndex));
            list.remove(startIndex);
        }
    }
}
