package week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class StackQueue {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Deque<Object> stack = new ArrayDeque<>();
		Deque<Object> queue = new ArrayDeque<>();
		StringTokenizer st = new StringTokenizer(br.readLine());
		String cases_s = st.nextToken();

		if (cases_s.equals("Stack")) {
			int test = Integer.parseInt(st.nextToken());
			for (int i = 0; i < test; i++) {
				st = new StringTokenizer(br.readLine());
				int cases = Integer.parseInt(st.nextToken());
				if (cases == 0) {
					System.out.println(stack.size());
				} else if (cases == 3) {
					stack.push(st.nextToken());
				}
				if (stack.size() != 0) {
					if (cases == 1) {
						System.out.println(stack.peek());
					} else if (cases == 2) {
						stack.pop();
					}
				}

			}
		}

		else if (cases_s.equals("Queue")) {
			int test = Integer.parseInt(st.nextToken());
			for (int i = 0; i < test; i++) {
				st = new StringTokenizer(br.readLine());
				int cases = Integer.parseInt(st.nextToken());
				if (cases == 0) {
					System.out.println(queue.size());
				} else if (cases == 3) {
					queue.addFirst(st.nextToken());
				}
				if (queue.size() != 0) {
					if (cases == 1) {
						System.out.println(queue.peekLast());
					} else if (cases == 2) {
						queue.removeLast();
					}

				}
			}
		}
	}

}
