import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	public static void main(String[] args) {
		MyQueue myQueue = new MyQueue();
		// push(1),push(2),push(3),peek,pop,peek,pop,peek,empty,pop,empty
		myQueue.push(1);
		myQueue.push(2);
		myQueue.push(3);

		System.out.println(myQueue.peek());
		myQueue.pop();
		System.out.println(myQueue.peek());
		myQueue.pop();
		System.out.println(myQueue.peek());
		System.out.println(myQueue.empty());
		myQueue.pop();
		System.out.println(myQueue.empty());

	}

}

class MyQueue {
	// Push element x to the back of queue.
	Stack<Integer> stack = new Stack<Integer>();
	List<Integer> list = new ArrayList<Integer>();

	public void copy() {

		for (int i = list.size() - 1; i >= 0; i--)
			stack.push(list.get(i));
		list.clear();
	}

	public void push(int x) {
		stack.push(x);
	}

	// Removes the element from in front of queue.
	public void pop() {
		while (stack.size() > 1)
			list.add(stack.pop());
		stack.pop();
		copy();

	}

	// Get the front element.
	public int peek() {
		while (stack.size() > 1)
			list.add(stack.pop());
		int temp = stack.peek();
		copy();
		return temp;
	}

	// Return whether the queue is empty.
	public boolean empty() {
		return stack.isEmpty();
	}
}
