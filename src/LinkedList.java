
	    
	     public  class LinkedList{
	   public class Node{
	        int item;
	        Node next;
            public Object linkedList;
	    }
	    Node head;
	    Node tail;
	    int len;
	    public LinkedList(){
	        head=tail=null;
	        len=0;
	    }
	    boolean isempty(){
	        return len==0;
	    }
	    public void insertf(int elem){
	        Node newNode;
	        newNode = new Node();
	        newNode.item=elem;
	        if(len==0){
	            head=tail=newNode;
	            newNode.next=null;
	        }else{
	            newNode.next=head;
	            head=newNode;
	            
	        }
	        len++;
	    }
	    public void inserte(int elem){
	          Node newNode;
	        newNode = new Node();
	        newNode.item=elem;
	        if(len==0){
	            head=tail=newNode;
	            newNode.next=null;
	        }else{
	            tail.next=newNode;
	            newNode.next=null;
	            tail=newNode;
	        }
	        len++;
	    }
	    /*
	    pos the postion that user want to insert elemnt in it*/
	    
    public void insertatPos(int pos, int element) {
        Node newNode = new Node();
        newNode.item = element;

        if (pos < 1) {
            System.out.println("Invalid position. Position should be 1 or greater.");
            return;
        }

        if (pos == 1) {
            newNode.next = head;
            head = newNode;
            if (len == 0) {
                tail = newNode;
            }
        } else {
            Node curr = head;
            for (int i = 1; i < pos - 1; i++) {
                if (curr == null) {
                    System.out.println("Invalid position. Position exceeds the length of the list.");
                    return;
                }
                curr = curr.next;
            }

            newNode.next = curr.next;
            curr.next = newNode;

            if (newNode.next == null) {
                tail = newNode;
            }
        }

        len++;
    }
	    public void removef(){
	        
	        if(len==0){
	            return;
	        }else if(len==1){
	            head=tail=null;
	            len--;
	        }else{
	            head=head.next;
	            len--;
	        }
	    }
	    public void removel(){
	        Node currx=head.next;
	        Node prevx=head;
	          if(len==0){
	            return;
	        }else if(len==1){
	            head=tail=null;
	            len--;
	        }else{
	            while(currx!=tail){
	                prevx=currx;
	                currx=currx.next;
	            }
	            prevx.next=null;
	            tail=prevx;
	            len--;
	        }
	    }
	    public void remove(int el){
	        
	        if(isempty()){return;}
	        Node curre,prevs;
	        if(head.item==el){
	            head=head.next;
	            len--;
	            if(len==0)
	            tail=null;
	        }else{
	            curre=head.next;
	            prevs=head;
	            while(curre!=null){
	                if(curre.item==el)
	                break;
	                prevs=curre;
	                curre=curre.next;
	            }
	            if(curre==null){
	                System.out.printf("not found");
	            }else{
	                prevs.next=curre.next;
	                if(tail==curre){
	                    tail=prevs;
	                    len--;
	                }
	            }
	            
	        }
	    }
	   public void reverse(){
	        Node prev,curr,next;
	        prev=null;
	        curr=head;
	        next=curr.next;
	        while(next!=null){
	       next=curr.next;
	       curr.next=prev;
	       prev=curr;
	       curr=next;

	        }
	        head=prev;
	    }
	    
	    public int search(int element){
	        Node curr=head;
	        int i=0;
	        while(curr!=null){
	            if(curr.item == element)
	                return i;
	                curr=curr.next;
	                i++;
	            
	        }
	          return -1;

	    }
	   
    }