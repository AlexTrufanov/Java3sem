import java.util.*;

public class Collections {
    public static void main(String[] args) {
        System.out.println(createList100());
    }

    public static List<Integer> createList100() {
        List<Integer> num = new ArrayList<>();
        for (int i = 1; i <= 100; i++)
            num.add(i);
        return num;
    }

    public static void printList(List<String> a) {
        System.out.println("Элементов в списке: " + a.size());
        for (String element : a)
            System.out.println(element);
    }


    public static void printListIndex(List<String> a) {
        int i = 1;
        System.out.println("Элементов в списке: " + a.size());
        for (String element : a) {
            System.out.println((i) + ": " + element);
            i++;
        }
    }

    public static List<String> concatenateLists(List<String> a, List<String> b) {
        List<String> res = new ArrayList<>();
        res.addAll(a);
        res.addAll(b);
        return res;
    }

    public static List<String> reverseList(List<String> a) {
        List<String> res = new ArrayList<>();
        for (int i = a.size() - 1; i >= 0; i--) {
            res.add(a.get(i));
        }
        return res;
    }

    public static void replaceList(List<String> a) {
        for (int i = a.size() - 1; i >= 0; i--) {
            a.add(a.get(i));
            a.remove(i);
        }
    }
}
