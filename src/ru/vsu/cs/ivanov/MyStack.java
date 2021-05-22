package ru.vsu.cs.ivanov;

public class MyStack<T> {
    private class Node<T> {
        public T data;
        public Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    private Node<T> head = null;
    private int count = 0;

    public void push(T data) {
        head = new Node<>(data, head);
        count++;
    }

    public T pop() throws Exception {
        if (count == 0) {
            throw new Exception("Stack is empty");
        }
        T data = head.data;
        head = head.next;
        count--;
        return data;
    }

    public T peek() throws Exception {
        if (count == 0) {
            throw new Exception("Stack is empty");
        }
        return head.data;
    }

    public int size() {
        return count;
    }

    public boolean isEmpty() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
