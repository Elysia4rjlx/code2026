import java.util.LinkedList;
import java.util.ListIterator;

public class JavaLinkedListDemo {
    public static void main(String[] args) {

        // 1. 构造一个空的 LinkedList
        LinkedList<String> list = new LinkedList<>();

        //2.增加元素
        //add 默认尾插
        list.add("JavaSE");
        list.add("JavaEE");
        list.add("JavaWeb");

        // LinkedList 特有的方法：头插和尾插O(1)
        list.addFirst("头");
        list.addLast("尾");

        System.out.println("当前链表：" + list);

        //3.获取元素(Get) - 链表的弱点
        String elem = list.get(0);
        System.out.println("第一个元素为：" + elem);

        // 4. 修改元素 (Set)
        list.set(0,"新头");

        // 5. 删除元素 (Remove)
        list.remove("JavaWeb"); // 删除指定对象
        list.remove(0);         // 删除指定下标
        list.removeFirst();     // 删除头部，O(1)
        list.removeLast();      // 删除尾部，O(1)

        System.out.println("删除后的链表: " + list);

        list.add("I ");
        list.add("LOVE");
        list.add("YOU");
        System.out.println("当前链表：" + list);

        // 6. 遍历链表
        for(String s : list){
            System.out.print(s + " ");
        }
        System.out.println();

        //使用迭代器
        ListIterator<String> it = list.listIterator();
        while (it.hasNext()){
            System.out.print(it.next() + " ");
        }
    }
}
