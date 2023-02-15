package Week3.Apple;
import java.util.*;
public class Q2 {
    // Java Iterator interface reference:
// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html

    class PeekingIterator implements Iterator<Integer> {
        Integer curr;
        Iterator<Integer> iterator;

        public PeekingIterator(Iterator<Integer> iterator) {
            this.iterator = iterator;
            curr = this.iterator.next();
        }

        // Returns the next element in the iteration without advancing the iterator.
        public Integer peek() {
            return curr;
        }

        // hasNext() and next() should behave the same as in the Iterator interface.
        // Override them if needed.
        @Override
        public Integer next() {
            Integer next = curr;
            if(iterator.hasNext())
                curr = iterator.next();
            else curr = null;
            return next;
        }

        @Override
        public boolean hasNext() {
            return curr != null;

        }
    }
}
