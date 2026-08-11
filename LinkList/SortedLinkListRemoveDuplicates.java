package LinkList;

import java.util.LinkedList;

public class SortedLinkListRemoveDuplicates {

    public static void main(String[] args) {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);

        for (int i = 0; i < list.size() - 1; i++) {

            if (list.get(i).equals(list.get(i + 1))) {
                list.remove(i + 1);
                i--; // check again at the same position
            }
        }

        System.out.println(list);
    }
}