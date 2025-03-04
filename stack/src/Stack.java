public class Stack {

    private int counter = 0;
    private Node last;

   public void addLast(Integer value) {
        last = new Node(last, value);
        counter ++;
    }

   public boolean remove(Integer value) {
        Node reference = last;
        while (reference.getNext() != null) {
            if (reference.getNext().getValue().equals(value)) {
                reference.setNext(reference.getNext().getNext());
                counter--;
                return true;
            }
            reference = reference.getNext();
        }
        return false;
   }

}


