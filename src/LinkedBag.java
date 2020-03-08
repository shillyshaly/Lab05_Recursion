/** * A class of bags whose entries are stored in a chain of linked nodes. * The bag is never full. * * @author Jamie Hernandez * @version 2/25/2020 */public class LinkedBag<T extends Comparable<? super T>> implements BagInterface<T>{    private Node<T> firstNode;       // reference to first node    public LinkedBag()    {        this.firstNode = null;    } // end default constructor    /**     * Adds a new entry to this bag.     *     * @param newEntry the object to be added as a new entry     * @return true     */    public boolean add(T newEntry) // OutOfMemoryError possible    {        // add to beginning of chain:        Node<T> newNode = new Node<>(newEntry);        newNode.next = this.firstNode;  // make new node reference rest of chain        // (firstNode is null if chain is empty)        this.firstNode = newNode;       // new node is at beginning of chain        //this.numberOfEntries++;        return true;    } // end add    /**     * Retrieves all entries that are in this bag.     *     * @return a newly allocated array of all the entries in the bag     */    public T[] toArray()    {        // the cast is safe because the new array contains null entries        int counter = 0;        Node<T> currentNode = this.firstNode;        while (currentNode != null)        {            counter++;            currentNode = currentNode.next;        } // end while        T[] result = (T[]) new Comparable<?>[counter]; // unchecked cast        int index = 0;        currentNode = this.firstNode;        while ((index < result.length) && (currentNode != null))        {            result[index] = currentNode.data;            index++;            currentNode = currentNode.next;        } // end while        return result;    } // end toArray    /**     * Sees whether this bag is empty.     *     * @return true if the bag is empty, or false if not     */    public boolean isEmpty()    {        return this.firstNode == null;    } // end isEmpty    /**     * Gets the number of entries currently in this bag.     *     * @return the integer number of entries currently in the bag     */    public int getCurrentSize()    {        throw new UnsupportedOperationException();    } // end getCurrentSize    /**     * Counts the number of times a given entry appears in this bag.     *     * @param anEntry the entry to be counted     * @return the number of times anEntry appears in the bag     *///    public int getFrequencyOf(T anEntry)//    {//        int frequency = 0;//        Node<T> currentNode = this.firstNode;//        while (currentNode != null)//        {//            if (anEntry.equals(currentNode.data))//            {//                frequency++;//            }////            currentNode = currentNode.next;//        }////        return frequency;//    } // end getFrequencyOf    public int getFrequencyOf(T anEntry)    {        return getFrequencyOf(anEntry, this.firstNode);    }    private int getFrequencyOf(T anEntry, Node currentNode)    {        // TODO Project #1a - DONE        // implement recursively        int count = 0;        if (currentNode.next != null){            if (anEntry.equals(currentNode.data)){                count = 1 + getFrequencyOf(anEntry, currentNode.next);            }else {                count = getFrequencyOf(anEntry, currentNode.next);            }            currentNode = currentNode.next;        }        return count; // THIS IS A STUB    }    /**     * isBagSorted - a method that checks if the elements in this.bag are sorted     */    public boolean isBagSorted()    {        return isBagSorted(this.firstNode);    }    /**     * isBagSorted - a private helper recursive method that checks if the elements in this.bag are sorted     *     * @param currentNode node of the current element in this.bag     */    private boolean isBagSorted(Node<T> currentNode)    {        // TODO Project #1b - debug tomorrow        // implement recursively        boolean sorted = true;        while (currentNode.next != null){            T node = currentNode.data;            if (node.compareTo(currentNode.next.data) < 0){                node = currentNode.next.data;                sorted = false;            }            currentNode = currentNode.next;        }        return sorted; // THIS IS A STUB    }    /**     * Tests whether this bag contains a given entry.     *     * @param anEntry the entry to locate     * @return true if the bag contains anEntry, or false otherwise     */    public boolean contains(T anEntry)    {        return getReferenceTo(anEntry) != null;    } // end contains    // Locates a given entry within this bag.    // Returns a reference to the node containing the entry, if located,    // or null otherwise.    private Node<T> getReferenceTo(T anEntry)    {        boolean found = false;        Node<T> currentNode = this.firstNode;        while (!found && (currentNode != null))        {            if (anEntry.equals(currentNode.data))                found = true;            else                currentNode = currentNode.next;        } // end while        return currentNode;    } // end getReferenceTo    /**     * Removes all entries from this bag.     */    public void clear()    {        while (!isEmpty())            remove();    } // end clear    /**     * Removes one unspecified entry from this bag, if possible.     *     * @return either the removed entry, if the removal     * was successful, or null     */    public T remove()    {        T result = null;        if (this.firstNode != null)        {            result = this.firstNode.data;            this.firstNode = this.firstNode.next; // remove first node from chain        } // end if        return result;    } // end remove    /**     * Removes one occurrence of a given entry from this bag, if possible.     *     * @param anElement the entry to be removed     * @return true if the removal was successful, or false otherwise     */    public boolean removeElement(T anElement)    {        boolean result = false;        Node<T> nodeN = getReferenceTo(anElement);        if (nodeN != null)        {            nodeN.data = this.firstNode.data; // replace located entry with entry in first node            this.firstNode = this.firstNode.next; // remove first node from chain            // this.numberOfEntries--;            result = true;        } // end if        return result;    } // end remove    /**     * Displays all the elements in the bag     */    public void display()    {        int counter = 0;        if (this.firstNode != null)        {            Node<T> currentNode = this.firstNode;            while (currentNode != null)            {                System.out.print(currentNode.data + " ");                currentNode = currentNode.next;                counter++;            }            System.out.println();            System.out.print("There are " + counter + " element(s) in the bag.");            System.out.println();        }        else            System.out.println("The bag is empty.");    } // end display    private class Node<S>    {        private S data; // entry in bag        private Node<S> next; // link to next node        private Node(S dataPortion)        {            this(dataPortion, null);        } // end constructor        private Node(S dataPortion, Node<S> nextNode)        {            this.data = dataPortion;            this.next = nextNode;        }    } // end Node    public static void main(String[] args)    {        LinkedBag<String> bag = new LinkedBag<>();        bag.add("Y");        bag.add("A");        bag.add("B");        bag.add("A");        bag.add("C");        bag.add("B");        bag.add("A");        bag.add("B");        bag.add("A");        bag.add("X");        bag.add("Z");        System.out.println("\n***Testing getFrequencyOf method***");        System.out.println("Bag1 contains:");        bag.display();        System.out.println("There are " + bag.getFrequencyOf("A") + " of \"A\"");        System.out.println("There are " + bag.getFrequencyOf("B") + " of \"B\"");        System.out.println("There are " + bag.getFrequencyOf("C") + " of \"C\"");        System.out.println("There are " + bag.getFrequencyOf("K") + " of \"K\"");        System.out.println("There are " + bag.getFrequencyOf("X") + " of \"X\"");        System.out.println("There are " + bag.getFrequencyOf("Y") + " of \"Y\"");        System.out.println("There are " + bag.getFrequencyOf("Z") + " of \"Z\"");        System.out.println("\n***Testing isBagSorted method***");        bag.display();        System.out.println("Bag is " + (bag.isBagSorted() ? "" : "NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.clear();        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.add("X");        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.add("Y");        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.clear();        bag.add("Y");        bag.add("X");        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.clear();        final int ASCII_A = 65;        int NUMBER_OF_ELEMENTS = 11;        for (int i = NUMBER_OF_ELEMENTS - 1; i >= 0; i--)        {            bag.add((char) (ASCII_A + i) + "");        }        bag.add("Z");        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.removeElement("Z");        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.removeElement("K");        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();        System.out.println("Changing the content of the bag");        bag.clear();        for (int i = 0; i < NUMBER_OF_ELEMENTS; i++)        {            bag.add((char) (ASCII_A + i) + "");        }        bag.display();        System.out.println("Bag is" + (bag.isBagSorted() ? "" : " NOT") + " sorted");        System.out.println();    } // end main} // end LinkedBag