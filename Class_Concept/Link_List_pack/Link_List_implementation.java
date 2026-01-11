package Class_Concept.Link_List_pack;

class Node {
    int data ;
    Node next;
    Node (int data){
        this.data = data;
        this.next = null;
    }

    // to string 

 
}

// class Link_List
class LinkList{
    private Node head;


    void addfront(int data){
        Node new_node = new Node(data);
        if(head == null ){
            head = new_node;
            return;
        }
        else{
            new_node.next = head;
            head = new_node;
        }
    }

    // add back

    void add_back(int data){
        Node new_node = new Node(data);

        if (head == null) {
            head = new_node;
            new_node.next = null;
            return;
        }else{
            Node currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = new_node;
            new_node.next = null ;
            
        }
        

    }

    // print
    public void  print_info(){
        Node crr = head;
        if (crr == null ) {
            System.out.println("Link List is null");
        }

        while (crr != null) {
            System.out.println(crr.data);
            crr = crr.next;
        }

    }


    // size

    public int  size(){
        Node crr = head;
        int i=0;
        if (crr == null ) {
            System.out.println(i);
            return i;
        }

        while (crr != null) {
            crr = crr.next;
            i++;
        }
        // System.out.println(i);
        return i;

    }

    //delete

public void delete(int data) {
    // Case 1: Empty list
    if (head == null) {
        System.out.println("List is empty");
        return;
    }

    // Case 2: Delete head
    if (head.data == data) {
        head = head.next;
        return;
    }

    Node prev = head;
    Node curr = head.next;

    while (curr != null) {
        if (curr.data == data) {
            prev.next = curr.next; // DELETE
            return;
        }
        prev = curr;
        curr = curr.next;
    }

    System.out.println("Value not found");
}

// reversed Link list

public void reversed(){
    if (head == null){
        System.out.println("Link List Empty");
        return;
    }
    Node prev = null;
    Node curr = head;
    Node Next = null;


    while (curr != null) {
        Next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = Next;

  
    }
    head = prev;
    print_info();
}

// sort

public void sort(){
        if (head == null){
        System.out.println("Link List Empty");
        return;
    }
    Node curr = head;
    Node first_itr = curr.next ;


    while (curr.next != null){
        while (first_itr != null) {
            if (curr.data > first_itr.data) {
                int temp = curr.data;
                curr.data = first_itr.data;
                first_itr.data = temp;
    

            }
            first_itr = first_itr.next;
            
        }

        curr = curr.next;
        first_itr = curr.next;

  
    }

    print_info();


}


// Merg Sort

public void Merg_sort( ){
    Node L1hed = head;
        LinkList list2  = new LinkList();
        LinkList list3 = new LinkList();
        if (L1hed == null || L1hed.next == null){
        
            return;
        }

        Node midd = midCal(L1hed);
        list2.head = L1hed;
         list3.head = midd.next;
         midd.next = null ;
    list2.Merg_sort();
    list3.Merg_sort();

    head = conqure(list2.head, list3.head);// why this 

    // L1hed = conqure(list2.head, list3.head);// because lihed is the local refrence not the actual refrence
}
// merg Sort conqure

private Node conqure(Node li2, Node li3){
    LinkList final_ll = new LinkList(); 

      while (li2 != null && li3 != null) {
        if (li2.data <= li3.data) {
            final_ll.add_back(li2.data);
            li2 = li2.next;
        } else {
            final_ll.add_back(li3.data);
            li3 = li3.next;
        }
    }

while (li2 != null) {
    final_ll.add_back(li2.data);
    li2 = li2.next;
}

while (li3 != null) {
    final_ll.add_back(li3.data);
    li3 = li3.next;
}


    return final_ll.head;
} 


//  Mid Of Link List

private Node midCal(Node head) {
    Node slow = head;
    Node fast = head.next;

    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}


// Q) delete from back 

public int delete_count_back(int target){
    if (head == null) {
        System.out.println("List is empty");
        return -1;
    }

    int size = size();
    // Case 2: Delete head
    if (head.data == target) {
        System.out.println("if head is target  " + (size-1));
        head = head.next;
        return size-1;
    }

    Node prev = head;
    Node curr = head.next;
    int final_size = 2;

    while (curr != null) {
        System.out.println(final_size);
        if (curr.data == target) {
            System.out.println("found data in while loop  " + (size - final_size ) );
            prev.next = curr.next; // 
            
            return size - final_size + 1;
        }
        prev = curr;
        curr = curr.next;
        final_size++;
    }

    System.out.println("Value not found");
    return -1;

}

// palindrome

public void palindrome_TcN_Scn_bruteforce(){
    if (head == null) {
        System.out.println(" Link List Is Empty");
        return;
    }
    LinkList list = new LinkList();
    Node curr = head;
    while (curr != null) {
        list.addfront(curr.data);
        curr = curr.next;
    }


    Node mainList = head;
    Node revList = list.head;

    while (mainList != null) {
        if (mainList.data != revList.data) {
            System.out.println("List is not palindrom");
            return;
        }
        mainList= mainList.next;
        revList = revList.next;

    }
    System.out.println("List is palindrom");
    return;

}

// palindrom good approach

public void palindrom_good_Aproach(){
    if (head == null ) {
        System.out.println("LinkList is Enpty");
        return;
    }
    LinkList half = new LinkList();
    Node cmp = head;
    Node slow = head;
    Node fast = slow; 
    while (fast != null && fast.next != null) {
        
        slow = slow.next;
        fast = fast.next.next;
    }
    half.head = slow.next;
    slow.next = null;
     Node prev = null;
    Node curr = half.head;
    Node Next = null;


    while (curr != null) {
        Next = curr.next;
        curr.next = prev;
        prev = curr;
        curr = Next;

  
    }
    half.head = prev;
    Node sec_cmp = half.head;

    while (sec_cmp != null ) {
        if (sec_cmp.data != cmp.data ){
            System.out.println("no pelondrom");
            return;
        }
        cmp = cmp.next;
        sec_cmp = sec_cmp.next;
    }
    System.out.println("list palindrom");
    return;

}
}



public class Link_List_implementation {
    public static void main(String[] aurg){
        LinkList ll = new LinkList();
        ll.addfront(600);
        ll.addfront(200);
        ll.addfront(600);
        ll.addfront(5);
        // ll.addfront(4);
        // ll.addfront(8);
        // ll.addfront(2);
        // ll.addfront(1);
        // ll.add_back(100);
        //    ll.size();
        // ll.delete(100);
        //    ll.print_info();

            // ll.print_info();
            System.out.println("Sourted List Is In The Frame");
        //    ll.sort();
        //    Node head = new Node(0);

        //    ll.Merg_sort();
        //    ll.print_info();
        // ll.size();
        // ll.print_info();
        // ll.palindrome_TcN_Scn_bruteforce();
        ll.palindrom_good_Aproach();
        // ll.delete_count_back(1);
    }
}
