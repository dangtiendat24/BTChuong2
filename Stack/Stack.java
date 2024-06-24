package Stack;

import java.util.EmptyStackException;
import java.util.Scanner;

public class Stack {
    private Node top;

    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public Stack() {
        this.top = null;
    }

    // Trả về true nếu ngăn xếp là trống và false nếu ngược lại
    public boolean isEmpty() {
        return top == null;
    }

    // Xóa sạch ngăn xếp
    public void clear() {
        top = null;
    }

    // Chèn một nút có giá trị x vào đỉnh của ngăn xếp
    public void push(int x) {
        Node newNode = new Node(x);
        newNode.next = top;
        top = newNode;
    }

    // Loại bỏ phần tử ở đỉnh ngăn xếp và trả về giá trị của nó
    public int pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        int value = top.data;
        top = top.next;
        return value;
    }

    // Trả về giá trị của một nút ở đỉnh của ngăn xếp
    public int top() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return top.data;
    }

    // Hiển thị tất cả các giá trị trong ngăn xếp từ đỉnh đến đáy
    public void traverse() {
        Node current = top;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Chuyển đổi một số nguyên từ hệ thập phân sang hệ nhị phân
    public static void convertToBinary(int number) {
        Stack stack = new Stack();
        while (number > 0) {
            stack.push(number % 2);
            number = number / 2;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
        System.out.println();
    }

    // Đảo ngược một xâu ký tự
    public static String reverseString(String input) {
        Stack stack = new Stack();
        for (char ch : input.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append((char) stack.pop());
        }
        return reversed.toString();
    }

    public static void main(String[] args) {
        Stack stack = new Stack();
        Scanner scanner = new Scanner(System.in);

        // Kiểm tra các phương thức của ngăn xếp
        System.out.println("Nhập các giá trị để đẩy vào ngăn xếp, kết thúc bằng giá trị âm:");
        while (true) {
            int value = scanner.nextInt();
            if (value < 0) break;
            stack.push(value);
        }

        System.out.println("Ngăn xếp sau khi đẩy các phần tử:");
        stack.traverse();

        System.out.println("Phần tử ở đỉnh ngăn xếp: " + stack.top());

        System.out.println("Phần tử đã loại bỏ khỏi đỉnh ngăn xếp: " + stack.pop());
        System.out.println("Ngăn xếp sau khi loại bỏ phần tử:");
        stack.traverse();

        // Chuyển đổi số từ hệ thập phân sang hệ nhị phân
        System.out.print("Nhập số nguyên để chuyển đổi sang hệ nhị phân: ");
        int decimalNumber = scanner.nextInt();
        System.out.println("Dạng nhị phân của " + decimalNumber + ":");
        convertToBinary(decimalNumber);

        // Đảo ngược chuỗi ký tự
        System.out.print("Nhập chuỗi ký tự để đảo ngược: ");
        scanner.nextLine(); // Đọc bỏ dòng mới
        String inputString = scanner.nextLine();
        System.out.println("Chuỗi đảo ngược của '" + inputString + "': " + reverseString(inputString));
    }
}
