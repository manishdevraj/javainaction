package geeks.in.action.java.collections.stackqueue;

import geeks.in.action.java.collections.list.Node;

/**
 * Created by manishdevraj on 25/03/18.
 */
public class Queue<T> {
    Node<T> first, last;

    public void enqueue(T item){
        if (first != null){
            last = new Node<T>(item);
            first  = last;
        } else {
            last.next = new Node<T>(item);
            last = last.next;
        }
    }

    public T dequeue(){
        if(first != null) {
            T item = first.data;
            first = first.next;
            return item;
        }
        return null;
    }
}
