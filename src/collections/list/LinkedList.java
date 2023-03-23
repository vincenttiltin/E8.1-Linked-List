/*
 * Copyright (c) 2021 Ian Clement. All rights reserved.
 */

package collections.list;

/**
 * An implementation of the List interface using unidirectional links, forming a "chain".
 *
 * @author Ian Clement
 */
public class LinkedList<T> implements List<T> {

    /* private inner class for link "chains" */
    private static class Link<T> {
        T element;
        Link<T> next;

        public Link() {}

        public Link(T element) {
            this.element = element;
        }
    }

    private Link<T> head;
    private Link<T> last;  // a last reference is used to make list append operations `add(x)`, `add(size(), x)` more efficient
    private int size;

    public LinkedList() {
        head = null;
        last = null;
        size = 0;
    }

    @Override
    public void add(T element) {
        // TODO
    }

    @Override
    public void add(int position, T element) {
        if (position < 0 || position > size) {
            throw new ListBoundsException();
        }

        // TODO
    }

    @Override
    public T remove(int position) {
        if (position < 0 || position >= size) {
            throw new ListBoundsException();
        }

        // TODO

        return null;
    }

    @Override
    public void clear() {
        // TODO
    }

    @Override
    public T get(int position) {
        if (position < 0 || position >= size) {
            throw new ListBoundsException();
        }

        // TODO

        return null;
    }

    @Override
    public T set(int position, T element) {
        if (position < 0 || position >= size) {
            throw new ListBoundsException();
        }

        // TODO
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append('[');

        for (Link<T> current = head; current != null; current = current.next) {
            sb.append(current.element);

            if (current.next != null) {
                sb.append(", ");
            }
        }

        sb.append(']');

        return sb.toString();
    }

}


     
      
