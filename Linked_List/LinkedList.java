package Linked_List;

import java.util.Scanner;

public class LinkedList {
    Node head;
    public LinkedList(){
        head = null;
    }
    //Thêm 1 nút giá trị x vào đầu danh sách
    public void addToHead(int x){
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }
    //Thêm 1 nút giá trị x vào cuối danh sách
    public void addToTail(int x){
        Node newNode = new Node(x);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while(current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
    }
    //Thêm 1 nút giá trị x vào sau nút p
    public void addAfter(Node p, int x){
        if(p == null){
            System.out.println("nút rỗng");
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }
    //Duyệt danh sách và in các giá trị
    public void traverse(){
        Node current = head;
        while(current != null){
            System.out.println(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
    //Xoá nút đầu tiên trong danh sách
    public int deleteFromHead(){
        if (head == null){
            System.out.println("danh sách rỗng");
            return -1 ;
        }
        int value = head.data;
        head = head.next;
        return value;
    }
    //Xoá nút cuối cùng trong danh sách
    public int deleteFromTail(){
        Node current = head;
        if(head == null){
            System.out.println("nút rỗng");
            return -1;
        }
        if(head.next == null){
            int value = head.data;
            head = null;
            return value;
        }
        while(current.next.next != null){
            current = current.next;
        }
        int value = current.next.data;
        current.next = null;
        return value;
    }
    //Xoá nút ở sau nút p và trả về giá trị
    public int deleteAfterP(Node p){
        if(p == null || p.next == null){
            System.out.println("nút rỗng hoặc sau nút p là rỗng");
            return -1;
        }
        Node toDelete = p.next;
        int value = p.next.data;
        p.next = toDelete.next;
        return value;
    }
    //Xoá nút đầu tiên có giá trị là x
    public void dele(int x){
        Node current = head;
        if(head == null){
            System.out.println("nút rỗng");
            return;
        }
        if(head.data == x){
            head = head.next;
            return;
        }
        while(current.next != null && current.next.data != x){
            current = current.next;
        }
        if(current.next != null){
            current.next = current.next.next;
        }else{
            System.out.println("không tìm thấy nút có giá trị trên");
        }
    }
    //Tím kiếm và trả về nút đầu tiên có giá trị là x
    public Node search(int x){
        Node current = head;
        while(current != null){
            if(current.data == x){
                return current;
            }
            current = current.next;
        }
        return null;
    }
    //Đếm và trả về số lượng nút trong danh sách
    public int count(){
        Node current = head;
        if (head == null){
            System.out.println("danh sách rỗng");
        }
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        return count;
    }
    //Xoá nút tại vị trí thứ i
    public void delete(int i){
        Node current = head;
        if(head == null){
            System.out.println("danh sách rỗng");
            return;
        }
        if(i == 0){
            head = head.next;
            return;
        }
        int count = 0;
        while(current != null && count < i - 1){
            current = current.next;
            count++;
        }
        if(current == null || current.next == null){
            System.out.println("nút thứ" + i + "không tồn tại");
            return;
        }
        current.next = current.next.next;
    }
    //Sắp xếp tăng dần
    public void sort() {
        // Nếu danh sách rỗng hoặc chỉ có một nút, không cần sắp xếp
        if (head == null || head.next == null) {
            return;
        }

        boolean swapped;
        Node current;
        Node lastSorted = null;

        do {
            swapped = false;
            current = head;

            while (current.next != lastSorted) {
                if (current.data > current.next.data) {
                    // Swap data
                    int temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;
                    swapped = true;
                }
                current = current.next;
            }
            lastSorted = current;
        } while (swapped);
    }
    //Xoá nút p nếu nó tồn tại trong danh sách
    public void dele(Node p){
        Node current = head;
        if(head == null){
            System.out.println("nút rỗng");
        }
        if(head == p){
            head = head.next;
        }
        while(current.next != null && current.next != p){
            current = current.next;
        }
        if(current.next == p){
            current.next = p.next;
        }
    }
    //Tạo và trả về một mảng chứa thông tin của tất cả các nút
    public int[] toArray(){
        if(head == null){
            System.out.println("Danh sách rỗng");
            return new int[0]; // Trả về mảng rỗng nếu danh sách trống
        }
        Node current = head;
        if(head == null){
            System.out.println("nút rỗng");
        }
        int count = 0;
        while(current != null){
            count++;
            current = current.next;
        }
        int index = 0;
        int[] array = new int[count];
        while(current != null){
            array[index] = current.data;
            current = current.next;
        }
        return array;
    }
    // Phương thức để hợp nhất hai danh sách đã sắp xếp
    public static LinkedList mergeSortedLists(LinkedList list1, LinkedList list2) {
        LinkedList mergedList = new LinkedList();
        Node p1 = list1.head;
        Node p2 = list2.head;
        // Tạo một nút giả (dummy node) để dễ dàng thêm các nút mới vào danh sách kết quả
        Node dummy = new Node(0);
        Node current = dummy;
        // So sánh các nút từ hai danh sách và thêm nút nhỏ hơn vào danh sách kết quả
        while (p1 != null && p2 != null) {
            if (p1.data <= p2.data) {
                current.next = p1;
                p1 = p1.next;
            } else {
                current.next = p2;
                p2 = p2.next;
            }
            current = current.next;
        }
        // Nếu một trong hai danh sách còn lại các nút, thêm tất cả vào danh sách kết quả
        if (p1 != null) {
            current.next = p1;
        } else if (p2 != null) {
            current.next = p2;
        }
        // Bỏ qua nút giả và cập nhật head của mergedList
        mergedList.head = dummy.next;
        return mergedList;
    }
    //Thêm nút x vào trước nút p
    public void addBefore(Node p, int x){
        Node current = head;
        Node newNode = new Node(x);
        if(head == null || p == null){
            return;
        }
        if(head == p){
            newNode.next = head;
            head = newNode;
            return;
        }
        while(current.next != null && current.next != p){
            current = current.next;
        }
        if(current.next == p){
            newNode.next = p;
            current.next = newNode;
        }
    }
    //Liên kết 2 danh sách liên kết đơn
    public void concatList(LinkedList list1, LinkedList list2 ){
        if(list1.head == null){
            list1.head = list2.head;
            return;
        }
        if(list2.head == null){
            return;
        }
        Node current = list1.head;
        while(current.next != null){
            current = current.next;
        }
        current.next = list2.head;
    }
    //Tìm và trả về giá trị lớn nhất trong danh sách
    public int Max(){
        if(head == null){
            throw new RuntimeException("nút rỗng");
        }
        int maxValue = head.data;
        Node current = head;
        while(current.next != null){
            if(current.data > maxValue){
                maxValue = current.data;
            }
            current = current.next;
        }
        return maxValue;
    }
    //Tìm và trả về giá trị nhỏ nhất
    public int Min(){
        if(head == null){
            throw new RuntimeException("nút rỗng");
        }
        int minValue = head.data;
        Node current = head;
        while(current.next != null){
            if(current.data < minValue){
                minValue = current.data;
            }
            current = current.next;
        }
        return minValue;
    }
    //Trả về tổng tất cả các giá trị
    public int sum(){
        Node current = head;
        if(head == null){
            throw new RuntimeException("nút rỗng");
        }
        int sum = 0;
        while (current != null){
            sum += current.data;
            current = current.next;
        }
        return sum;
    }
    //Trả về giá trị trung bình
    public int avg(){
        int sum = 0;
        int count = 0;
        Node current = head;
        if(head == null){
            throw new RuntimeException("danh sách rỗng");
        }
        while(current != null){
            count++;
            sum += current.data;
            current = current.next;
        }
        int avg = sum/count;
        return avg;
    }
    //Kiểm tra danh sách đã sắp xếp hay chưa
    public boolean sorted(){
        Node current = head;
        if(head == null || head.next == null){
            return true;
        }
        while(current.next != null){
            if(current.data > current.next.data){
                return false;
            }
            current = current.next;
        }
        return true;
    }
    //chèn x vào danh sách đã sắp xếp
    public void insert(int x){
        Node newNode = new Node(x);
        Node current = head;
        if(head == null || x < head.data){
            newNode.next = head;
            head = newNode;
            return;
        }
        while(current.next != null && current.next.data < x){
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }
    //Đảo ngược danh sách trong 1 lần duyệt
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;

        // Duyệt qua danh sách và thực hiện đảo ngược
        while (current != null) {
            next = current.next; // Lưu lại nút kế tiếp của nút hiện tại
            current.next = prev; // Đảo ngược liên kết của nút hiện tại

            // Di chuyển các con trỏ tiến tới
            prev = current;
            current = next;
        }

        // Đặt lại head cho danh sách đã đảo ngược
        head = prev;
    }
    // Phương thức để kiểm tra hai danh sách có cùng nội dung hay không
    public static boolean isEqual(LinkedList list1, LinkedList list2) {
        Node current1 = list1.head;
        Node current2 = list2.head;

        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }

        // Độ dài của hai danh sách phải bằng nhau và các phần tử tương ứng cùng giá trị
        return (current1 == null && current2 == null);
    }

    public static void main(String[] args){
        LinkedList list1 = new LinkedList();
        LinkedList list2 = new LinkedList();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử cho danh sách 1: ");
        int n1 = scanner.nextInt();
        System.out.println("Nhập các phần tử cho danh sách 1: ");
        for(int i = 0; i < n1; i++){
            int value1 = scanner.nextInt();
            list1.addToTail(value1);
        }

        System.out.print("Nhập số lượng phần tử cho danh sách 2: ");
        int n2 = scanner.nextInt();
        System.out.println("Nhập các phần tử cho danh sách 2:");
        for(int i = 0; i < n2; i++){
            int value2 = scanner.nextInt();
            list2.addToTail(value2);
        }

        System.out.println("Hiển thị danh sách 1");
        list1.traverse();
        System.out.println("Hiển thị sanh sách 2");
        list2.traverse();

        LinkedList mergedList = LinkedList.mergeSortedLists(list1, list2);
        System.out.println("Danh sách sau khi hợp nhất");
        mergedList.traverse();

        boolean areEqual = LinkedList.isEqual(list1,list2);
        System.out.println("Hai danh sách có cùng nội dung không ?" + areEqual);

        list1.reverse();
        System.out.println("Danh sách 1 sau khi đảo ngược");
        list1.traverse();

        if (list1.head != null && list1.head.next != null) {
            System.out.print("Nhập giá trị để thêm vào sau nút thứ 2 của danh sách 1: ");
            int value = scanner.nextInt();
            list1.addAfter(list1.head.next, value);
            System.out.println("Danh sách 1 sau khi thêm");
            list1.traverse();
        } else {
            System.out.println("Danh sách 1 không đủ nút để thêm vào trước nút thứ 2");
        }

//        list1.concatList(list1, list2);
//        System.out.println("Danh sách sau khi liên kết 2 vào 1");
//        list1.traverse();

        boolean isSorted = list1.sorted();
        System.out.println("Danh sách đã được sắp xếp chưa ?" + isSorted);
        list1.sort();

        System.out.print("Nhập giá trị thêm vào danh sách 1 đã sắp xếp: ");
        int insertValue = scanner.nextInt();
        list1.insert(insertValue);
        System.out.println("Danh sách 1 sau khi thêm là: ");
        list1.traverse();

        int valueMax = list1.Max();
        int sumValue = list1.sum();
        System.out.println("Giá trị lớn nhất của danh sách 1 là: " + valueMax);
        System.out.println("Tổng các giá trị trong danh sách 1 là: " + sumValue);
    }
}
