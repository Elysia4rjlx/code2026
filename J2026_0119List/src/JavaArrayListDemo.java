import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class JavaArrayListDemo {

    public static void main(String[] args) {
        // 1. 构造方法
        List<Integer> list = new ArrayList<>();

        // 2. 增加元素 (Add)
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(1, 15);

        System.out.println("当前列表：" + list);

        //3. 获取元素 (Get) - 优势
        int val = list.get(2);
        System.out.println("下标2；" + val);

        //4.修改元素（Set)
        list.set(0, 520);
        System.out.println("当前列表：" + list);

        //5. 判断是否存在 (Contains)
        boolean has20 = list.contains(20);
        System.out.println("是否包含20：" + has20);

        //6. 删除元素 (Remove) - 劣势
        // remove(int index) -> 删除下标位置
        // remove(Object o)  -> 删除指定对象
        list.remove(0);
        System.out.println("当前列表：" + list);
        list.remove(Integer.valueOf(20));
        // 如果想删除数字20，要这样写
        System.out.println("当前列表：" + list);

       // 7. 截取子列表 (SubList)
        List<Integer> sub = list.subList(0,2);
        System.out.println("子列表：" + sub);


        list.add(11);
        list.add(22);
        list.add(33);


        //8.遍历
        System.out.print("遍历：");
        for(Integer x : list){
            System.out.print(x + " ");
        }
        System.out.println();

        System.out.println(list);

        // 9. 排序 (ArrayList 独有优势)
        Collections.sort(list);
        System.out.println("排序后：" + list);

    }
}
