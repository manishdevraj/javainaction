package geeks.in.action;


import geeks.in.action.java.collections.stackqueue.SetOfStacks;
import geeks.in.action.java.collections.stackqueue.SingleArrayStack;
import geeks.in.action.java.collections.stackqueue.StackWithMin;
import org.junit.Test;
import org.omg.PortableInterceptor.Interceptor;

import static org.junit.Assert.*;

/**
 * Created by manishdevraj on 25/03/18.
 */
public class StacksQueueTest extends BaseTestCase{

    @Test
    public void testSingleStackThreeArr(){
        SingleArrayStack obj = new SingleArrayStack();

        try {
            obj.push(0, 1);
            obj.push(0, 2);
            obj.push(1, 3);
            obj.push(2, 1);

            System.out.println(obj);

            assertEquals(2, obj.pop(0));
            assertEquals(3, obj.peek(1));
            assertEquals(1, obj.peek(2));

            System.out.println("Post few operations " + obj);

            obj.push(0, 10);
            obj.push(0, 20);

            assertEquals(1, obj.pop(2));
            assertTrue(obj.isEmpty(2));
            assertFalse(obj.isEmpty(0));

            System.out.println("Final copy " + obj);

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testStackWithMin() {
        StackWithMin obj = new StackWithMin();
        obj.push(8);
        obj.push(10);
        obj.push(6);
        obj.push(4);
        obj.push(12);
        obj.push(2);
        obj.push(11);

        System.out.println(obj);

        assertEquals(Integer.valueOf(2), obj.min());

        obj.pop();
        obj.pop();

        System.out.println("Few pops " +  obj);

        assertEquals(Integer.valueOf(4), obj.min());

        obj = new StackWithMin();
        obj.push(8);
        obj.push(10);
        obj.push(6);
        obj.push(4);
        obj.push(2);
        obj.push(2);
        obj.push(11);

        System.out.println("New stack " +  obj);

        assertEquals(Integer.valueOf(2), obj.min());

        obj.pop();
        obj.pop();

        System.out.println("New stack few pops " +  obj);

        assertEquals(Integer.valueOf(2), obj.min());
    }

    @Test
    public void testSetOfStack() {
        SetOfStacks obj = new SetOfStacks(2);
        obj.push(1);
        obj.push(2);
        obj.push(3);
        obj.push(4);
        obj.push(5);
        obj.push(6);
        obj.push(7);
        obj.push(8);

        System.out.println(obj);

        try {

            assertEquals(8, obj.pop());

            obj.push(10);

            assertEquals(8, obj.getSize());

            assertEquals(4, obj.popAt(1));

            System.out.println(obj);

            assertEquals(7, obj.getSize());

        } catch (Exception e) {
            fail(e.getMessage());
        }
    }


}
