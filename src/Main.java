import javax.print.Doc;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        YmhArrayList list = new YmhArrayList(10);
        list.add("123123");
        list.add(new Date());
        list.add("qewe");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).toString());
        }
        System.out.println(list.size());
    }
}

