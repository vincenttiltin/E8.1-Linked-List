import collections.list.LinkedList;
import collections.list.List;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedList {

    // construct the list: ["abc", "def", "ghi", "jkl"]
    public List<String> sampleList(){
        List<String> list = new LinkedList<>();

        for(String s : "abc def ghi jkl".split(" ")) {
            list.add(s);
        }

        return list;
    }

    @Test
    public void testEmpty() {
        List<String> list = new LinkedList<>();

        assertEquals("[]", list.toString());
        assertEquals(0, list.size());
    }

    @Test
    public void testAdd() {
        List<String> list = new LinkedList<>();

        list.add("abc");
        list.add("def");
        list.add("ghi");

        assertEquals("[abc, def, ghi]", list.toString());
    }

    @Test
    public void testAddMiddle() {
        List<String> list = sampleList();

        list.add(2, "mno");

        assertEquals("[abc, def, mno, ghi, jkl]", list.toString());
    }

    @Test
    public void testAddFirst() {
        List<String> list = sampleList();

        list.add(0, "mno");

        assertEquals("[mno, abc, def, ghi, jkl]", list.toString());
    }

    @Test
    public void testAddLast() {
        List<String> list = sampleList();

        list.add(list.size(), "mno");

        assertEquals("[abc, def, ghi, jkl, mno]", list.toString());
    }

    @Test
    public void testRemoveMiddle() {
        List<String> list = sampleList();
        String removed = list.remove(2);

        assertEquals("ghi", removed);
        assertEquals("[abc, def, jkl]", list.toString());
    }

    @Test
    public void testRemoveFirst() {
        List<String> list = sampleList();
        String removed = list.remove(0);

        assertEquals("abc", removed);
        assertEquals("[def, ghi, jkl]", list.toString());
    }

    @Test
    public void testRemoveLast() {
        List<String> list = sampleList();
        String removed = list.remove(list.size() - 1);

        assertEquals("jkl", removed);
        assertEquals("[abc, def, ghi]", list.toString());
    }

    @Test
    public void testGetMiddle() {
        List<String> list = sampleList();

        assertEquals("ghi", list.get(2));
    }

    @Test
    public void testGetFirst() {
        List<String> list = sampleList();

        assertEquals("abc", list.get(0));
    }

    @Test
    public void testGetLast() {
        List<String> list = sampleList();

        assertEquals("jkl", list.get(list.size() - 1));
    }

    @Test
    public void testSetMiddle() {
        List<String> list = sampleList();

        list.set(2, "mno");

        assertEquals("[abc, def, mno, jkl]", list.toString());
    }

    @Test
    public void testSetFirst() {
        List<String> list = sampleList();

        list.set(0, "mno");

        assertEquals("[mno, def, ghi, jkl]", list.toString());
    }

    @Test
    public void testSetLast() {
        List<String> list = sampleList();

        list.set(list.size() - 1, "mno");

        assertEquals("[abc, def, ghi, mno]", list.toString());
    }

    @Test
    public void testClear() {
        List<String> list = sampleList();

        list.clear();

        assertEquals("[]", list.toString());
    }

    @Test
    public void testTraversal() {
        List<String> list = sampleList();

        list.reset();

        assertTrue(list.hasNext());
        assertEquals("abc", list.next());
        assertTrue(list.hasNext());
        assertEquals("def", list.next());
        assertTrue(list.hasNext());
        assertEquals("ghi", list.next());
        assertTrue(list.hasNext());
        assertEquals("jkl", list.next());
        assertFalse(list.hasNext());
    }

}

