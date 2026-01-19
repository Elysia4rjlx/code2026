import java.util.List;


// 1. 定义节点类：这是链表的最小单元
class ListNode {
    public int val;
    public ListNode next;//指针域（引用），指向下一个节点

    public ListNode(int val) {
        this.val = val;
    }
}

// 2. 定义链表类：管理这些节点
public class MyLinkedList {

    public ListNode head;

    //【头插法】：在链表最前面插入，效率 O(1)
    public void addFirst(int data) {
        ListNode node = new ListNode(data);
        node.next = this.head;
        this.head = node;
    }

    // 【尾插法】：在链表最后面插入，效率 O(N)
    public void addLast(int data) {
        ListNode node = new ListNode(data);
        if (this.head == null) {
            this.head = node;
            return;
        }
        ListNode cur = this.head;
        while (cur.next != null) {
            cur = cur.next;
        }
        cur.next = node;
    }

    // 【任意位置插入】：在 index 位置插入，效率 O(N)
    public void addIndex(int index, int data) {
        if (index == 0) {
            addFirst(data);
            return;
        }
        if (index == size()) {
            addLast(data);
            return;
        }
        ListNode prev = searchPrev(index);
        if (prev == null) {
            System.out.println("位置不合法");
            return;
        }
        ListNode node = new ListNode(data);
        node.next = prev.next;
        prev.next = node;

    }


    // 辅助方法：找到 index-1 位置的节点
    private ListNode searchPrev(int index) {
        ListNode cur = this.head;
        int count = 0;
        while (count < index - 1 && cur != null){
            cur = cur.next;
            count++;
        }
        return cur;
    }

    //获取长度
    public int size(){
        int count = 0;
        ListNode cur = this.head;
        while (cur != null){
            cur = cur.next;
            count++;
        }
        return count;
    }

    //打印链表
    public void display(){
        ListNode cur = this.head;
        while (cur != null){
            System.out.print(cur.val + "->");
            cur = cur.next;
        }
        System.out.println("null");
    }


    // 测试主程序
    public static void main(String[] args) {
        MyLinkedList myLink = new MyLinkedList();
        myLink.addLast(10);
        myLink.addLast(20);
        myLink.addLast(30);
        // 目前：10 -> 20 -> 30 -> null

        myLink.addFirst(5);
        // 目前：5 -> 10 -> 20 -> 30 -> null

        myLink.addIndex(2, 99); // 在下标2插入99
        // 结果：5 -> 10 -> 99 -> 20 -> 30 -> null

        myLink.display();
    }























}
