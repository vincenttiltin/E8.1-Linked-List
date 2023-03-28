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

    @Override
    public void reset() {

    }

    @Override
    public T next() {
        return null;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

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
    private Link<T> tail;  // a tail reference is used to make list append operations `add(x)`, `add(size(), x)` more efficient
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    @Override
    public void add(T element)
    {
        Link<T> link = new Link<>(element);

        if (size == 0) {
            head = link;
        }
        else {
            tail.next = link;
        }

        tail = link;
        size++;

    }

    @Override
    public void add(int position, T element)
    {
        if (position < 0 || position > size) {
            throw new ListBoundsException();
        }

        if (size == 0 || position == size)
        {
            this.add(element);
        }

        else if (position == 0 )
        {
            Link link = new Link<>(element);

            link.next = head;
            head = link;
            size++;

        }

        else
        {
            Link<T> current = move(position - 1);

            Link<T> link = new Link<>();

            //points to nothing
            link.next = current.next;
            current.next = link;

            size++;
        }

    }

    @Override
    public T remove(int position)
    {
        if (position < 0 || position >= size) {
            throw new ListBoundsException();
        }

        T removed;

        // If we only hae one element
        if(position == 0 && size ==1)
        {
            removed = head.element;
            head = null;
            tail = null;
        }

        // If were removing from the beginning
        else if(position == 0)
        {
            removed = head.element;
            head = head.next;
        }
        else
        {
            Link<T> current = move(position - 1);

            removed = current.next.element;

            if (position == size -1)
            {
                tail = current;
                tail.next = null;
            }
            else
            {
                current.next = current.next.next;
            }
        }

        return removed;
    }

    private Link<T> move(int position)
    {
        Link<T> current = head;

        for (int i = 0; i < position;i++)
        {
            current = current.next;
        }
        return current;
    }


    @Override
    public void clear()
    {

    }

    @Override
    public T get(int position)
    {
        if (position < 0 || position >= size)
        {
            throw new ListBoundsException();
        }

        Link<T> current = move(position);
        return current.element;
    }

    @Override
    public T set(int position, T element)
    {
        if (position < 0 || position >= size) {
            throw new ListBoundsException();
        }

        Link<T> current = move(position);
        T oldElement = current.element;
        current.element = element;
        return oldElement;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return List.super.isEmpty();
    }

    @Override
    public boolean contains(T element) {
        return List.super.contains(element);
    }

    @Override
    public boolean remove(T element) {
        return List.super.remove(element);
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


     
      
