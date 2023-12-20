### Description
Build three classes that conform to the following interfaces. Use arrays in creating your classes (e.g., do not use the built-in ArrayList class when creating the ArrayList-like interface). Extend the sample driver below to completely test the FIFO nature of a Queue, the LIFO nature of a stack and the arbitrary inserts and removes in an ArrayList-like structure.

##ArrayList-like Interface

void add(Object, int index):  Add the object at the end of the ArrayList-like structure.
void insert(Object, int index):  Add the object at the specified index.
Object remove(int index):  Remove and return the object at the specified index.  (This should behave like the corresponding method in Java's built-in ArrayList class; see Savitch's description.)
int size()
String toString()
boolean isEmpty()
int indexOf(Object):  Returns -1 if not found
boolean equals(Object):  Compare sizes and elements in the data structure.
Object get(int index):  Returns the object at index specified.

##Stack Interface (LIFO)

void push(Object) 
Object pop()
int size():  A classic stack does not have a size method, but in this assignment, we are asking you to implement one.
String toString()
boolean isEmpty()
boolean equals(Object)

##Queue Interface (FIFO)

void enqueue(Object)
Object dequeue()
int size():  A classic queue does not have a size method, but in this assignment, we are asking you to implement one.
String toString()
boolean isEmpty()
boolean equals(Object)
