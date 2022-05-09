package com.flannery;

public class Node<E> {
    public Node(Node<E> prev, E item, Node<E> next) {
        this.item = item;
        this.next = next;
        this.prev = prev;
    }

    E item;
    Node<E> next;
    Node<E> prev;
}
