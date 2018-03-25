package geeks.in.action.java.collections.stackqueue;

/**
 * In the classic problem of the Towers of Hanoi, you have 3 rods and N disks of different sizes which can slide onto
 * any tower. The puzzle starts with disks sorted in ascending order of size from top to bottom
 * (e.g., each disk sits on top of an even larger one). You have the following constraints:
 (A) Only one disk can be moved at a time.
 (B) A disk is slid off the top of one rod onto the next rod.
 (C) A disk can only be placed on top of a larger disk.
 Write a program to move the disks from the first rod to the last using Stacks.
 * Created by manishdevraj on 25/03/18.
 */
public class TowerOfHanoi {
    private Stack<Integer> disks;

    private int index;


    public TowerOfHanoi(int i) {
         disks = new Stack<Integer>();
         index = i;

    }

    public int index() {
        return index;
    }

    public void add(int d) {
        if (!disks.isEmpty() && disks.peek() <= d) {
            System.out.println("Error placing disk " + d);
        } else {
            disks.push(d);
        }

    }

    public void moveTopTo(TowerOfHanoi t) {
         int top = disks.pop();
         t.add(top);
         System.out.println("Move disk " + top + "from "+index() +
                 "to "+t.index());

    }

    public void print() {
        System.out.println("Contents of Tower " + index());
        for (int i = disks.getSize() - 1; i >= 0; i--) {

            StringBuffer buff = new StringBuffer();

            int disk = disks.pop();
            int tmp = disk;

            while( tmp > 0){
                buff.append("-");
                tmp--;
            }

            System.out.println("" + buff);
        }
    }

    public void moveDisks(int n, TowerOfHanoi destination, TowerOfHanoi buffer) {
         if (n > 0) {
             moveDisks(n - 1, buffer, destination);
             moveTopTo(destination);
             buffer.moveDisks(n - 1, destination, this);

        }
    }

    @Override
    public String toString() {
        return "TowerOfHanoi {" +
                "disks=" + disks +
                ", index=" + index +
                '}';
    }

    public static void main(String[] args){
        int n = 5;

        TowerOfHanoi[] towers = new TowerOfHanoi[n];

        for (int i = 0; i < 3; i++) {
            towers[i] = new TowerOfHanoi(i);
        }
        for (int i = n - 1; i >= 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(n, towers[2], towers[1]);

        towers[2].print();

    }

}
