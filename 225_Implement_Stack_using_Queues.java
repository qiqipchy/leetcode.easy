import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
public class Solution {

	public static void main(String[] args) {
		MyStack myStack = new MyStack();
		myStack.push(1);
		myStack.push(2);
		myStack.push(3);

		System.out.println(myStack.top());
		myStack.pop();
		System.out.println(myStack.top());
		myStack.pop();
		System.out.println(myStack.top());
		System.out.println(myStack.empty());
		myStack.pop();
		System.out.println(myStack.empty());
	}

}

class MyStack {
	// Push element x onto stack.
	Queue<Integer> queue = new LinkedList<Integer>();

	public void push(int x) {
		queue.add(x);
	}

	// Removes the element on top of the stack.
	public void pop() {
		List<Integer> list = new ArrayList<Integer>();
		while (!queue.isEmpty())
			list.add(queue.poll());
		for (int i = 0; i < list.size() - 1; i++)
			queue.add(list.get(i));
	}

	// Get the top element.
	public int top() {
		Iterator<Integer> iter = queue.iterator();
		int temp = 0;
		while (iter.hasNext())
			temp = iter.next();
		return temp;
	}

	// Return whether the stack is empty.
	public boolean empty() {
		return queue.isEmpty();
	}
}
