import java.util.Scanner;

public class DecoratorDemo {
	public static void main(String[] args){
		MyPizza basicPizza = new Ham(new TomatoSauce(new Cheese(new PlainPizza())));
		System.out.println("Ingredients: " + basicPizza.ingredients());		
		System.out.println("Price: " + basicPizza.getCost());
	}
}

interface MyPizza {
	public String ingredients();
	public double getCost();
}

class PlainPizza implements MyPizza {
	public String ingredients() {
		return "dough";
	}

	public double getCost() {
		return 4.00;	
	}
}

abstract class ToppingDecorator implements MyPizza {
	protected MyPizza tempPizza;
	
	public ToppingDecorator(MyPizza newPizza){
		tempPizza = newPizza;		
	}
	
	public String ingredients() {
		return tempPizza.ingredients();
	}

	public double getCost() {
		return tempPizza.getCost();
	}
}

class Cheese extends ToppingDecorator {

	public Cheese(MyPizza newPizza) {		
		super(newPizza);	
	}
	
	public String ingredients(){		
		return tempPizza.ingredients() + ", cheese";		
	}
	
	public double getCost(){
		return tempPizza.getCost() + 2.00;		
	}	
}

class TomatoSauce extends ToppingDecorator {

	public TomatoSauce(MyPizza newPizza) {
		super(newPizza);	
	}
	
	public String ingredients(){		
		return tempPizza.ingredients() + ", tomato sauce";
	}

	public double getCost(){
		return tempPizza.getCost() + .35;		
	}
}

class Ham extends ToppingDecorator {

	public Ham(MyPizza newPizza) {
		super(newPizza);
	}

	public String ingredients(){
		return tempPizza.ingredients() + ", ham";
	}

	public double getCost(){
		return tempPizza.getCost() + 4.00;
	}
}