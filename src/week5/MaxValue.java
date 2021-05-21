package week5;
import java.util.*;
import java.io.*;
class Status {
	int index;
	int max;
	public Status(int index, int max) {
		this.index = index;
		this.max = max;
	}
}
public class MaxValue {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		Deque<Status> deque = new ArrayDeque<>();
		int max = Integer.MIN_VALUE;
		int index = 0;
		int push_counter = 0;

		int test = Integer.parseInt(br.readLine());
		for (int i = 0; i < test; i++) {
			String line = br.readLine();
			String[] tokens = line.split(" ");
			String command = tokens[0];

			if (command.equals("Push")) {
				int value = Integer.parseInt(tokens[1]);
				push_counter++;
				if (max <= value) {
					max = value;
					index = push_counter;
				}
				Status status = new Status(index, max);
				deque.addFirst(status);
			}
			else if (command.equals("Pop")){
				Status out = deque.removeFirst();
				System.out.println(out.index + " " + out.max);
				if (deque.size() > 0) {
					max = deque.getFirst().max;
					index = deque.getFirst().index;
				}
				else {
					max = Integer.MIN_VALUE;
					index = 0;
				}
			}
		}
	}

}
