
//package src;
//import lib.*;
import java.util.Scanner;
//@SuppressWarnings("unused")

public class App {
    public static void main(String[] args)
    {
        queue obj = new queue(9);
        obj.app();
    }
}

//lib is disabled for now, this class is from lib
class console {
    public static void clear() {
        System.out.print("\033[H\033[2J");
    }
}


class queue
{

    private Scanner scan = new Scanner(System.in);
    int front, rear, size;

    int[] queue;
    public queue(int x)
    {
        size = x;
        queue = new int[size];
        front = rear = -1;
    }

    private void display()
    {
        //console.clear();
        if(!(isEmpty()))
        {
            System.out.print("Actual Queue :[ "); 
            for(int i = this.front ; i < this.rear+1 ; i++ )
            {   
                System.out.print("'" + this.queue[i] + "'");
                if(i > this.front-1 && i < this.rear  )
                {
                    System.out.print(" , ");
                }
            }
            System.out.print(" ]"); 
            System.out.println("");
            System.out.print("Array :[ "); 
            for(int i = 0 ; i < this.size ; i++ )
            {   
                System.out.print("'" + this.queue[i] + "'");
                if(i > -1 && i < this.size-1  )
                System.out.print(" , ");
            }
            System.out.print(" ]"); 
            System.out.println("");
        }else
        {
            System.out.println("The queue is empty !!");
        }
    }

    private void enqueue(int x)
    {
        if(isFull())
        {
            return;
        }
        else if(isEmpty())
        {
            this.front = this.rear = 0;
            queue[this.rear] = x;
        }
        else
        {
            this.rear ++;
            queue[this.rear] = x;
        }
    }

    private void dequeue()
    {
        //int j;
        if(isEmpty() && this.front == this.rear)
        {
            return;
        }
        else if( !(isEmpty()) && this.front == this.rear)
        {
            //j = queue[this.front];
            queue[this.front] = 0;
            this.front = this.rear = -1;
        }
        else if( !(isEmpty()) && (this.front != this.rear))
        {
            //j = queue[this.front];
            queue[this.front] = 0;
            this.front +=1;
        }
        else
        {
            return;
        }
        return;
    }

    private int peek()
    {
        if(isEmpty())
        {
            return -1 ;
        }else
        {
            return this.queue[this.front];
        }
    }

    private boolean isEmpty()
    {
        if(this.front == this.rear && this.rear == -1)
        {
            return true;
        }else{
            return false;
        }
    }

    private boolean isFull() {
        if (this.rear == this.size-1) {
            return true;
        } else {
            return false;
        }
    }

    private void menu()
    {
        display();
        System.out.print("1. enqueue\n");
        System.out.print("2. dequeue\n");
        System.out.print("3. Peek\n");
        System.out.print("4. isEmpty\n");
        System.out.print("5. isFull\n");
        System.out.print("null. ...\n");
        //System.out.print("9. Display\n");
        input();
    }

    /**
     * 
     */
    private void input()
    {
        System.out.print("Enter Your Choice: ");
        String input = scan.nextLine();

        if(input.equals("1"))
        {
            console.clear();
            System.out.print("Enter Integer number to add to the Queue: ");
            String push = scan.nextLine();
            this.enqueue(Integer.valueOf(push));
            System.out.print("The value '"+push+"' is added to the rear position: "+(this.rear+1)+"\n");
            this.menu();
        }
        else if (input.equals("2"))
        {
            console.clear();
            //System.out.print("Enter Integer number to add to the Stack: ");
            //String push = scan.nextLine();
            if(!(isEmpty()))
            {
                dequeue();
                System.out.println("One data is removed from the front !!");
            }
            else
            {
                System.out.println("The queue is already empty !!");
            }
            //this.dequeue();
            this.menu();
        }
        else if (input.equals("3")) {
            console.clear();
            // System.out.print("Enter Integer number to add to the Stack: ");
            // String push = scan.nextLine();
            System.out.println("The front is :" + this.peek());
            this.menu();
        }
        else if (input.equals("4")) {
            console.clear();
            // System.out.print("Enter Integer number to add to the Stack: ");
            // String push = scan.nextLine();
            if(this.isEmpty())
            {
                System.out.println("The queue is empty");
            }
            else
            {
                System.out.println("The queue is not empty");
            }
            this.menu();
        }
        else if (input.equals("5")) {
            console.clear();
            // System.out.print("Enter Integer number to add to the Stack: ");
            // String push = scan.nextLine();
            if(this.isFull())
            {
                System.out.println("The queue is Full");
            }
            else
            {
                System.out.println("The queue is not Full");
            }
            this.menu();
        }
        else if(input.equals("9"))
        {
            console.clear();
            this.display();
            this.menu();
        }
        else if(input.equals("0"))
        {
            console.clear();
            return;
        }
        else
        {
            console.clear();
            System.out.print("Wrong option\n");
            this.menu();
        }

    }

    public void app()
    {
        this.menu();
    }

    /*
    public static void main (String[] args)
    {

        queue queue = new queue(9);
        queue.app();
        //console.clear();
        

    }
    */
}