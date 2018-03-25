package geeks.in.action.java.collections.stackqueue;

import java.util.Arrays;

/**
 * Describe how you could use a single array to implement three stacks.
 * Created by manishdevraj on 25/03/18.
 */
public class SingleArrayStack {
    private static final int STACK_NUMS = 3;
    private static final int STACK_SIZE = 3;
    private int[] buffer = new int[STACK_SIZE * STACK_NUMS];
    private int[] stackPointer = {0, 0, 0}; // pointer to track all top of all stacks

    /**
     * Divide the array in three equal parts and allow the individual stack to grow in that limited space
     * (note: “[“ means inclusive, while “(“ means exclusive of the end point).
     »»for stack 1, we will use [0, n/3)
     »»for stack 2, we will use [n/3, 2n/3)
     »»for stack 3, we will use [2n/3, n)
     This solution is based on the assumption that we do not have any extra information about the usage of space
     by individual stacks and that we can’t either modify or use any extra space. With these constraints,
     we are left with no other choice but to divide equally.
     */

    public void push(final int stackNum, final int intValue) throws Exception {

        if(stackNum > STACK_NUMS) throw new Exception("Only allowed stacks are between 0 to " + STACK_NUMS);

        int index = stackNum * STACK_SIZE + stackPointer[stackNum];
        if(checkPartition(stackNum, index)) {
            stackPointer[stackNum]++;
            buffer[index] = intValue;
        } else {
            throw new Exception("Stack " + stackNum + " is full");
        }

    }

    private boolean checkPartition(final int stackNum, final int index) {
        int maxRange = ((stackNum + 1) * STACK_SIZE) - 1;
        int minRange = stackNum * STACK_SIZE;
        return ((index <= maxRange) && (index >= minRange));
    }

    public int peek(final int stackNum) throws Exception {
        if(stackNum > STACK_NUMS) throw new Exception("Only allowed stacks are between 0 to " + STACK_NUMS);
        return buffer[(stackNum * STACK_SIZE) + stackPointer[stackNum] -1 ];
    }

    public int pop(final int stackNum) throws Exception {
        if(stackNum > STACK_NUMS) throw new Exception("Only allowed stacks are between 0 to " + STACK_NUMS);
        int index = (stackNum * STACK_SIZE) + stackPointer[stackNum] - 1;
        int value = buffer[index];
        stackPointer[stackNum]--;
        buffer[index] = 0;
        return value;
    }

    public boolean isEmpty(final int stackNum) throws Exception {
        if (stackNum > STACK_NUMS) throw new Exception("Only allowed stacks are between 0 to " + STACK_NUMS);
        return stackPointer[stackNum] == 0;
    }

    @Override
    public String toString() {
        return "SingleArrayStack{" +
                "buffer=" + Arrays.toString(buffer) +
                ", stackPointer=" + Arrays.toString(stackPointer) +
                '}';
    }
}
