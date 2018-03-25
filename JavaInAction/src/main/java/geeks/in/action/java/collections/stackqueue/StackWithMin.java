package geeks.in.action.java.collections.stackqueue;


/**
 * How would you design a stack which, in addition to push and pop, also has a function min which
 * returns the minimum element? Push, pop and min should all operate in O(1) time.
 * Created by manishdevraj on 25/03/18.
 */
public class StackWithMin extends Stack<Integer> {
    Node<Integer> top;

    public Integer min(){
        if(isEmpty() || super.peek() == null) {
            return Integer.MAX_VALUE;
        }
        return super.peek();
    }

    public Integer pop(){
        if (top != null) {
            Integer item = top.data;
            top = top.next;
            if(item == super.peek().intValue()) {
                super.pop();
            }

            return item;
        }
        return null;
    }

    public void push(Integer item){
        Node<Integer> tNode = new Node<Integer>(item);
        tNode.next = top;
        top = tNode;
        if(min() >= item) {
            super.push(item);
        }
    }

    public boolean isEmpty() { return top == null; }

    public Integer peek(){
        if (top != null) {
            Integer item = top.data;
            return item;
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuffer buff = new StringBuffer();
        buff.append(super.toString());
        buff.append("\n");

        buff.append("StackWithMin{" +
                "top=" + top +
                '}');
        return buff.toString();
    }
}
