public class List {
    private class Element{
       private int Data;
       private Element Next;
       private Element Prev;
       private static int count = 0;

        public int getData() {
            return Data;
        }

        public Element getNext() {
            return Next;
        }

        public Element getPrev() {
            return Prev;
        }

        public void setData(int data) {
            Data = data;
        }

        public void setNext(Element next) {
            Next = next;
        }

        public void setPrev(Element prev) {
            Prev = prev;
        }

        public Element(int Data) {
            this.Data = Data;
            count++;
            System.out.println("EConstractor: \t" + Integer.toHexString(hashCode()));
        }
        public Element(int Data, Element Next)
        {
            this.Data = Data;
            this.Next = Next;
            count++;
            System.out.println("EConstractor:\t" + Integer.toHexString(hashCode()));
        }
        protected void finalize()
            {
            //super.finalize();
            count--;
            System.out.println("EDestructor:\t" + Integer.toHexString(hashCode()));
        }
    }

    private Element Head, Tail;
   private int size;

    public Element getHead() {
        return Head;
    }

    public Element getTail() {
        return Tail;
    }

    public int getSize() {
        return size;
    }

    public List() {
        Head = Tail = null;
        size = 0;
        System.out.println("LConstractor:\t" + Integer.toHexString(hashCode()));
    }


   public void push_front(int Data){
        if(Head == null && Tail == null ){
            Head = Tail = new Element(Data);
        }
        else {
            /*Element New = new Element(Data);
            New.setNext(Head);
            Head.setPrev(New);
            Head = New;*/
            Head = Head.Prev = new Element(Data, Head);
        }
            size++;

    }
    public void push_back(int Data){
        if(Head == null && Tail == null ){
            Head = Tail = new Element(Data);
        }
        else{
            Element New = new Element(Data);
            New.setPrev(Tail);
            Tail.setNext(New);
            Tail= New;
        }
        size++;
    }
        public void pop_front(){
        if(Head == null &&  Tail == null)
        return;
        else if(Head == Tail)
        {
            Head.finalize();
            Head = Tail = null;

        }
        else {
            Head = Head.Next;
            Head.Prev.finalize();
            Head.Prev = null;
        }
        size--;
        }
        public void pop_back(){
        if(Head == null && Tail == null)
            return;
        if (Head == Tail)
        {
            Tail.finalize();
            Head = Tail = null;
        }

        else{
            Tail = Tail.Prev;
            Tail.Next.finalize();
            Tail.Next = null;
        }
        size--;
        }

        public void clear(){
        while ( Head != null)pop_front();
        }
    void insert(int Data, int Index)
    {
        if(Index == 0)
        {
            push_front(Data);
            return;
        }
        if(Index > size)return;
        Element Temp = Head;
        for(int i = 0; i < Index - 1; i++)Temp = Temp.getNext();
        Temp.setNext(new Element(Data, Temp.getNext()));
        size++;
    }
public void print(){
        for (Element Temp = Head; Temp != null; Temp = Temp.getNext())
            System.out.print(Temp.Data + "\t");
    System.out.println("\nКолличество элементов списка: " + size);
    System.out.println("Общее колличество элементов: " + Element.count);
}
public void reverse_print(){
        for(Element Temp = Tail; Temp != null; Temp = Temp.Prev )
            System.out.print(Temp.Data + "\t");
    System.out.println("\nКолличество элементов списка: " + size);
    System.out.println("Общее колличество элементов: " + Element.count);
    }
}
