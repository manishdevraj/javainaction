package geeks.in.action.java.collections.stackqueue;


/**
 * Created by manishdevraj on 25/03/18.
 */
public class Stack<T> {

    Node<T> top;

    public T pop(){
        if (top != null) {
            T item = top.data;
            top = top.next;
            return item;
        }
        return null;
    }

    public void push(T item){
        Node<T> tNode = new Node<T>(item);
        tNode.next = top;
        top = tNode;
    }

    public boolean isEmpty() { return top == null; }

    public T peek(){
        if (top != null) {
            T item = top.data;
            return item;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Stack{" +
                "top=" + top +
                '}';
    }
}
