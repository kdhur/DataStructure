package week6;

import java.io.*;
import java.util.Stack;

public class Problem2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String output = convertPostfix(input);
        long output2 = caculate(output);
        System.out.println(output);
        System.out.println(output2);
    }

    public static long caculate(String s) {
        String[] input = s.split(" ");
        int len = input.length;
        long first, second;
        Stack<Long> list = new Stack<>();

        for (int i = 0; i < len; i++) {
            String ch = input[i].trim();
            switch (ch) {
                case "+":
                    list.push(list.pop() + list.pop());
                    break;
                case "-":
                    first = list.pop();
                    second = list.pop();
                    list.push(second - first);
                    break;
                case "*":
                    list.push(list.pop() * list.pop());
                    break;
                case "/":
                    first = list.pop();
                    second = list.pop();
                    list.push(second / first);
                    break;
                case "%":
                    first = list.pop();
                    second = list.pop();
                    list.push(second % first);
                    break;
                case "^":
                    first = list.pop();
                    second = list.pop();
                    list.push(Math.round(Math.pow(second, first)));
                    break;
                default:
                    list.push(Long.parseLong(ch));
                    break;
            }
        }

        return list.pop();
    }

    public static String convertPostfix(String s) {
        String[] input = s.split(" ");
        int len = input.length;
        Stack<String> stack = new Stack<String>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < len; i++) {
            String ch = input[i].trim();
            int p = priority(ch);
            if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/") || ch.equals("^") || ch.equals("%")) {
                while (!stack.isEmpty() && priority(stack.peek()) >= p)
                    sb.append(stack.pop() + " ");
                stack.push(ch);
            }
            else if (ch.equals("("))
                stack.push(ch);
            else if (ch.equals(")")) {
                while(!stack.isEmpty() && !stack.peek().equals("("))
                    sb.append(stack.pop() + " ");
                stack.pop();
            }
            else
                sb.append(ch + " ");
        }

        while (!stack.isEmpty())
            sb.append(stack.pop() + " ");

        String result = sb.toString();
        return result;
    }

    public static int priority(String ch) {
        if (ch.equals("^"))
            return 3;
        else if (ch.equals("*") || ch.equals("/") || ch.equals("%"))
            return 2;
        else if (ch.equals("+") || ch.equals("-"))
            return 0;
        else
            return -1;
    }
}

