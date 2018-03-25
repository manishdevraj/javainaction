package geeks.in.action.java.collections.stackqueue;

/**
 * Created by manishdevraj on 25/03/18.
 */
public class DStack<T> {

    private int capacity;
    private DNode<T> top, bottom;
    private int size = 0;

    public DStack(int capacity){
        this.capacity = capacity;
    }

    public boolean isAtCapacity(){ return this.capacity == this.size; }

    public int getSize(){ return this.size; }

    public T pop(){
        if (top != null) {
            T item = top.data;
            top = top.below;
            size--;
            return item;
        }
        return null;
    }

    private void join(final DNode<T> below, final DNode<T> above){
        if(below != null) below.above = above;
        if(above != null) above.below = below;
    }

    public boolean push(T item){
        if(size >= capacity) return false;

        size++;

        DNode<T> t = new DNode<T>(item);

        if(size == 1) bottom = t;
        join(t, top);
        top = t;

        return true;
    }

    public T removeBottom(){
        DNode<T> b = bottom;
        bottom = bottom.above;

        if(bottom != null) bottom.below = null;
        size--;
        return b.data;
    }

    public boolean isEmpty() { return size == 0; }

    public T peek(){
        if (top != null) {
            T item = top.data;
            return item;
        }
        return null;
    }

    @Override
    public String toString() {
        if(top != null && top.equals(bottom)) {
            return "Stack{" +
                    "capacity=" + capacity +
                    ", top and bottom =" + top +
                    '}';
        } else {
            return "Stack{" +
                    "capacity=" + capacity +
                    ", top=" + top +
                    ", bottom=" + bottom +
                    '}';
        }

    }
}
