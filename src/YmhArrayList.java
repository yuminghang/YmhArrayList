import java.util.Objects;

/**
 * Created by ymh on 2016/6/2.
 */
public class YmhArrayList {
    private Object[] elements;
    private int size;

    public YmhArrayList() {
        this(10);
    }

    public YmhArrayList(int size) {
        elements = new Object[size];
    }

    //增
    public void add(Object obj) {
        capacityCheck();
        elements[size++] = obj;
    }

    public void add(int index, Object obj) {
        rangecheck(index);
        capacityCheck();
        int moveCount = size - index;
        if (moveCount > 0)
            System.arraycopy(elements, index, elements, index + 1, moveCount);
        elements[index] = obj;
        size++;
    }


    //删
    public Object remove(int index) {
        rangecheck(index);
        Object oldValue = elements[index];
        int moveCount = size - 1 - index;
        if (moveCount > 0)
            System.arraycopy(elements, index + 1, elements, index, moveCount);
        elements[--size] = null; // clear to let GC do its work
        return oldValue;
    }

    public boolean remove(Object obj) {
        if (obj == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    remove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elements[i].equals(obj)) {
                    remove(i);
                    return true;
                }
            }
        }
        return false;
    }

    //    //改
//    public void set(Object obj) {
//        if (obj == null) {
//            for (int i = 0; i < size; i++) {
//                if (elements[i] == null) {
//                    remove(i);
//                }
//            }
//        } else {
//            for (int i = 0; i < size; i++) {
//                if (elements[i].equals(obj)) {
//                    remove(i);
//                }
//            }
//        }
//    }
    //改
    public Object set(int index, Object obj) {
        rangecheck(index);
        Object oldValue = elements[index];
        elements[index] = obj;
        return oldValue;
    }

    //查
    public Object get(int index) {
        rangecheck(index);
        return elements[index];
    }

    private void rangecheck(int index) {
        if (index < 0 || index > elements.length - 1) {
            try {
                throw new MyException();
            } catch (MyException e) {
                e.printStackTrace();
            }
        }
    }

    private void capacityCheck() {
        if (size > elements.length - 1) {
            Object[] newElements = new Object[size * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public int size() {
        return size;
    }
}