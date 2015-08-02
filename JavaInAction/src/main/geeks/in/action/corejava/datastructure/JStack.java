package geeks.in.action.corejava.datastructure;

//Arrays, linked lists, trees, etc. are best for
//data that represents real objects.

//Stacks & Queues are instead used to complete a 
//task and are soon after discarded.

//Stacks & Queues
//1. Allow only a single item to be added or removed at a time
//2. Stacks allow access to the last item inserted (LIFO)
//3. Queues allow access to the first item inserted (FIFO)

import java.util.Arrays;

public class JStack {

	private final String[] stackArray;
	private final int stackSize;

	// Sets stack as empty

	private int topOfStack = -1;

	JStack(int size) {

		stackSize = size;

		stackArray = new String[size];

		// Assigns the value of -1 to every value in the array
		// so I control what gets printed to screen

		Arrays.fill(stackArray, "-1");

	}

	public void push(String input) {

		if (topOfStack + 1 < stackSize) {

			topOfStack++;

			stackArray[topOfStack] = input;

		} else
			System.out.println("Sorry But the Stack is Full");

		displayTheStack();

		System.out.println("PUSH " + input + " Was Added to the Stack\n");

	}

	public String pop() {

		if (topOfStack >= 0) {

			displayTheStack();

			System.out.println("POP " + stackArray[topOfStack]
					+ " Was Removed From the Stack\n");

			// Just like in memory an item isn't deleted, but instead is just
			// not available

			stackArray[topOfStack] = "-1"; // Assigns -1 so the value won't
											// appear

			return stackArray[topOfStack--];

		} else {

			displayTheStack();

			System.out.println("Sorry But the Stack is Empty");

			return "-1";
		}

	}

	public String peek() {

		displayTheStack();

		System.out.println("PEEK " + stackArray[topOfStack]
				+ " Is at the Top of the Stack\n");

		return stackArray[topOfStack];

	}

	public void pushMany(String multipleValues) {

		String[] tempString = multipleValues.split(" ");

		for (int i = 0; i < tempString.length; i++) {

			push(tempString[i]);

		}

	}

	public void popAll() {

		for (int i = topOfStack; i >= 0; i--) {

			pop();

		}

	}

	public void popDisplayAll() {

		String theReverse = "";

		for (int i = topOfStack; i >= 0; i--) {

			theReverse += stackArray[i];

		}

		System.out.println("The Reverse: " + theReverse);

		popAll();

	}

	public void displayTheStack() {

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < stackSize; n++) {

			System.out.format("| %2s " + " ", n);

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

		for (int n = 0; n < stackSize; n++) {

			if (stackArray[n].equals("-1"))
				System.out.print("|     ");

			else
				System.out.print(String.format("| %2s " + " ", stackArray[n]));

		}

		System.out.println("|");

		for (int n = 0; n < 61; n++)
			System.out.print("-");

		System.out.println();

	}

	public static void main(String[] args) {

		JStack jStack = new JStack(10);

		jStack.push("10");
		jStack.push("17");
		jStack.push("13");

		// Look at the top value on the stack

		jStack.peek();

		// Remove values from the stack (LIFO)

		jStack.pop();
		jStack.pop();
		jStack.pop();

		// Add many to the stack

		jStack.pushMany("R E D R U M");

		// Remove all from the stack

		// theStack.popAll();

		// Remove all from the stack and print them

		jStack.popDisplayAll();

		jStack.displayTheStack();

	}

}