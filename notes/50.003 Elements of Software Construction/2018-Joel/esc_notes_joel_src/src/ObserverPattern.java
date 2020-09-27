import java.util.ArrayList;
import java.util.List;

class Subject {
   private List<Observer> observers = new ArrayList<Observer>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);      
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   }    
}

abstract class Observer {
   protected Subject subject;
   public abstract void update();
}


// two concrete implementations of the observer class

class BinaryObserver extends Observer{

   public BinaryObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
      System.out.println( "Binary String: " + Integer.toBinaryString( subject.getState() ) ); 
   }
}

class OctalObserver extends Observer{

   public OctalObserver(Subject subject){
      this.subject = subject;
      this.subject.attach(this);
   }

   @Override
   public void update() {
     System.out.println( "Octal String: " + Integer.toOctalString( subject.getState() ) ); 
   }
}

public class ObserverPattern {
   public static void main(String[] args) {
      Subject subject = new Subject();

      new OctalObserver(subject);
      new BinaryObserver(subject);

      System.out.println("First state change: 15");   
      subject.setState(15);
      System.out.println("Second state change: 10");  
      subject.setState(10);
   }
}

// output 
// First state change: 15
// Octal String: 17
// Binary String: 1111
// Second state change: 10
// Octal String: 12
// Binary String: 1010