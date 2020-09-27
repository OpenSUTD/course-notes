import java.util.Scanner;

public class PizzaStore {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String whichPizza = "";
		System.out.print("What type of pizza? cheese/greek/pepperoni: ");
            
        if (sc.hasNextLine()){   
            whichPizza = sc.nextLine();
        }

		PizzaFactory factory = new PizzaFactory();
		Pizza pizza = factory.makePizza(whichPizza);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
	}
}

class PizzaFactory {

	public Pizza makePizza(String type) {
		Pizza pizza = null;
		String log = "";
		if (type.equals("cheese")) {
			pizza = new CheesePizza();
			log = "Made pizza of type " + pizza.getClass().getSimpleName();
		}
		else if (type.equals("greek")) {
			pizza = new GreekPizza();
			log = "Made pizza of type " + pizza.getClass().getSimpleName();
		}
		else if (type.equals("pepperoni")) {
			pizza = new PepperoniPizza();
			log = "Made pizza of type " + pizza.getClass().getSimpleName();
		} else {
			pizza = new CheesePizza();
			log = "We don't serve " + type +", instead we made you a " + pizza.getClass().getSimpleName();
		}
		System.out.println(log);
		return pizza;
	}
}

class Pizza {

	public void prepare() {
	}

	public void box() {
	}

	public void cut() {
	}

	public void bake() {
	}
}

class CheesePizza extends Pizza {}
class GreekPizza extends Pizza {}
class PepperoniPizza extends Pizza {}

