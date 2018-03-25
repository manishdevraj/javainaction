package geeks.in.action.java.collections.stackqueue;

/**
 * Created by manishdevraj on 25/03/18.
 */
public class DNode<T> {
    public DNode<T> above;
    public DNode<T> below;
    public T data;

    public DNode(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "DNode{" +
                "data=" + data +
                '}';
    }
}
