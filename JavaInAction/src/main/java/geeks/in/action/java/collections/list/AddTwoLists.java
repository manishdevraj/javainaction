package geeks.in.action.java.collections.list;

/**
 * You have two numbers represented by a linked list, where each node contains a single digit.
 * The digits are stored in reverse order, such that the 1’s digit is at the head of the list.
 * Write a function that adds the two numbers and returns the sum as a linked list.
 EXAMPLE
 Input: (3 -> 1 -> 5) + (5 -> 9 -> 2)
 Output: 8 -> 0 -> 8
 * Created by manishdevraj on 25/03/18.
 */
public class AddTwoLists {

    public static class Link {
        public Link next;
        public Integer data;

        public Link(Integer data) { this.data = data; }

        public void appendToTail(final Integer data) {
            Link end = new Link(data);
            Link n = this;

            while (n.next != null) {
                n = n.next;
            }

            n.next = end;
        }

        @Override
        public String toString() {
            return "Link [data=" + data
                    + " next= " + next
                    + "]";
        }
    }


    public Link addLists(Link l1, Link l2, int carry){
        if (l1 == null && l2 == null) {
            return null;
        }

        Link result = new Link(carry);
        int value = carry;

        if (l1 != null && l1.data != null){
            value += l1.data;
        }

        if (l2 != null && l2.data != null){
            value += l2.data;
        }

        result.data = value % 10;

        Link more = addLists(l1 == null ? null : l1.next,
                l2 == null ? null : l2.next, value >= 10 ? 1 : 0);

        result.next = more;

        return result;
    }
}
