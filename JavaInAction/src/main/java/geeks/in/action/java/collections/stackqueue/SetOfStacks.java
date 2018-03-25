package geeks.in.action.java.collections.stackqueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Imagine a (literal) stack of plates. If the stack gets too high, it might topple. Therefore, in real life,
 * we would likely start a new stack when the previous stack exceeds some threshold. Implement a data structure
 * SetOfStacks that mimics this. SetOfStacks should be composed of several stacks, and should create a new stack once
 * the previous one exceeds capacity. SetOfStacks.push() and SetOfStacks.pop() should behave identically to a single
 * stack (that is, pop() should return the same values as it would if there were just a single stack).
 FOLLOW UP
 Implement a function popAt(int index) which performs a pop operation on a specific sub-stack.
 * Created by manishdevraj on 25/03/18.
 */
public class SetOfStacks {
    private List<DStack<Integer>> stacks = new ArrayList<DStack<Integer>>();
    private int capacity;

    public SetOfStacks(int capacity) {
        this.capacity = capacity;
    }

    public int getSize() {
        int size = 0;
        for(DStack<Integer> stack : stacks) {
            size+=stack.getSize();
        }
        return size;
    }

    public DStack<Integer> getLastStack(){
        if (stacks.size() == 0) return null;
        return stacks.get(stacks.size() - 1);
    }

    /**
     * We know that push() should behave identically to a single stack, which means that we need push() to call push on
     * the last stack. We have to be a bit careful here though: if the last stack is at capacity, we need to create a
     * new stack. Our code should look something like this:
     * @param item
     */
    public void push(Integer item) {
        DStack<Integer> last = getLastStack();
        if(last != null && !last.isAtCapacity()) {
            last.push(item);
        } else {
            DStack<Integer> stack = new DStack<Integer>(capacity);
            stack.push(item);
            stacks.add(stack);

        }
    }

    /**
     * What should pop() do? It should behave similarly to push(), in that it should operate on the last stack.
     * If the last stack is empty (after popping), then we should remove it from the list of stacks.
     *
     * This is a bit trickier to implement, but essentially we should imagine a “rollover” system. If we pop an element
     * from stack 1, we need to remove the bottom of stack 2 and push it onto stack 1. We then need to rollover from
     * stack 3 to stack 2, stack 4 to stack 3, etc.
     * @return
     */
    public int pop() throws Exception {
        if(stacks.size() <= 0 ) throw new Exception("Stack is empty");
        DStack<Integer> last = getLastStack();
        if(last != null) {
            int val = last.pop();
            if(last.getSize() == 0) stacks.remove(stacks.size() - 1);
            return val;
        }
        throw new Exception("Stack is empty");
    }

    /**
     * Use this for object chaining, remove top from index stack
     * and then remove bottom from index + 1, if any. And add it
     * to index stack top to fill in gap and keep stack in line
     * @param index
     * @param removeTop
     * @return
     */
    public int leftShift(int index,  boolean removeTop){
        DStack<Integer> stack = stacks.get(index);

        int removedItem;

        if(removeTop) removedItem = stack.pop();
        else removedItem = stack.removeBottom();

        if(stack.isEmpty()) {
            stacks.remove(index);
        } else if (stacks.size() > index + 1){
            int val = leftShift(index + 1, false);
            stack.push(val);
        }
        return removedItem;
    }

    public int popAt(int index) {
        return leftShift(index, true);
    }

    @Override
    public String toString() {
        return "SetOfStacks{" +
                "stacks=" + stacks +
                ", capacity=" + capacity +
                '}';
    }
}
