package com.flannery;

public interface List<E> {

    int size();
    boolean isEmpty();
    boolean contains(Object o);
    Object[] toArray();
    boolean add(E e);
    boolean remove(Object o);
    E get(int index);
    E set(int index, E element);
    void add(int index, E element);
    E remove(int index);
    int indexOf(Object o);
}
