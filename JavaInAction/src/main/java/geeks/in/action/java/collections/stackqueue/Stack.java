package geeks.in.action.java.collections.stackqueue;


import java.util.Iterator;

/**
 * Created by manishdevraj on 25/03/18.
 */
public class Stack<T> {

    Node<T> top;
    private int size = 0;

    public T pop(){
        if (top != null) {
            T item = top.data;
            top = top.next;
            size--;
            return item;
        }
        return null;
    }

    public int getSize(){
        return size;
    }

    public void push(T item){
        Node<T> tNode = new Node<T>(item);
        tNode.next = top;
        top = tNode;
        size++;
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
