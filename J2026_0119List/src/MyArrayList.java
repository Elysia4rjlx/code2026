import java.util.Arrays;

public class MyArrayList {
    public int[] elem;
    public int usedSize;
    private static final int DEFAULT_CAPACITY = 10;


    public MyArrayList() {
        this.elem = new int[DEFAULT_CAPACITY];
    }


    private void grow() {
        int oldC = elem.length;
        //仅对非负整数来说，x >> 1 与 x / 2 完全等价。
        int newC = elem.length + (elem.length >> 1);

        // Arrays.copyOf 会自动申请新数组并搬移数据
        this.elem = Arrays.copyOf(this.elem, newC);
    }

    //默认尾插，O(1) (不考虑扩容)
    public void add(int data) {
        if (isFull()) {
            grow();
        }
        this.elem[usedSize] = data;
        usedSize++;
    }

    private boolean isFull() {
        return usedSize == elem.length;
    }

    private boolean isEmpty() {
        return usedSize == 0;
    }

    //在 pos 位置插入，O(N)
    public void add(int pos, int data) {
        if (pos < 0 || pos > this.usedSize) {
            throw new IndexOutOfBoundsException("pos:" + pos);
        }
        if (isFull()) {
            grow();
        }
        for (int i = this.usedSize - 1; i > pos; i--) {
            this.elem[i + 1] = this.elem[i];
        }
        this.elem[pos] = data;
        this.usedSize++;
    }

    //判断是否包含
    public boolean contains(int elems) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == elems) {
                return true;
            }
        }
        return false;
    }

    //返回下标
    public int indexOf(int elems) {
        for (int i = 0; i < this.usedSize; i++) {
            if (this.elem[i] == elems) {
                return i;
            }
        }
        return -1;
    }

    //O(1) - 顺序表的优势
    public int getElem(int pos) {
        if (isEmpty()) {
            System.out.println("该表为空");
        }
        if (pos < 0 || pos >= this.usedSize) {
            System.out.println("pos越界");
        }
        return this.elem[pos];
    }

    //修改元素：O(1)
    public void setElem(int pos, int val) {
        if (pos < 0 || pos > this.usedSize) {
            throw new RuntimeException("pos 下标越界");
        }
        elem[pos] = val;
    }

    //删除元素；O(N)
    public void remove(int removeElem) {
        int index = indexOf(removeElem);
        if (!contains(removeElem)) {
            System.out.println("该元素不存在");
            return;
        }
        if (index == -1) {
            System.out.println("该元素不存在");
            return;
        }

        for (int i = index; i < this.usedSize - 1; i--) {
            this.elem[i] = this.elem[i + 1];
        }
        this.usedSize--;

    }

    public int size() {
        return this.usedSize;
    }

    public void display() {

        for (int i = 0; i < this.usedSize; i++) {
            System.out.print(this.elem[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        MyArrayList list = new MyArrayList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(1, 0);          // 头插 0
        list.remove(2);     // 删 2
        list.setElem(2, 9);          // 把下标 2 改成 9
        list.display();          // 输出：[0, 1, 9, 3]
    }


}
