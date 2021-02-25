/*
 Joseph Kelly
 Decorator Pattern project
 */
package coffee;

/**
 *
 * @author kelly
 */
abstract class Coffee {
    protected String name;
    protected double cost;
    //protected double baseCost = cost;
   
    public Coffee (String name, double cost){
        this.name = name;
        this.cost = cost;
    }
    
    public void tallyPrice(){
        System.out.println(name+"'s cost is $"+String.format("%,.2f", cost));
    }
}

/*
    Dark roast - $1.15
    House blend - $1.20
    Decaf - $1.10
    Espresso - $2.00
*/
class DarkRoast extends Coffee {
    public DarkRoast() {
        super("Dark Roast", 1.15 );
    }
}

class HouseBlend extends Coffee {
    public HouseBlend() {
        super("House Blend", 1.20 );
    }
}

class Decaf extends Coffee {
    public Decaf() {
        super("Decaf", 1.10);
    }
}

class Espresso extends Coffee{
    public Espresso() {
        super("Espresso", 2.00);
    }
}

/*
Steamed Milk - $0.30
Soy Milk - $0.15
Mocha - $0.20
Whipped cream - $.10
*/
abstract class CoffeeAdditions extends Coffee {
    //private Coffee coffee;
    //protected double costChange;
    public CoffeeAdditions(Coffee c, String addition, double additionCost){
        super(addition + " " + c.name, c.cost + additionCost);
    }
}

class Doubled extends CoffeeAdditions {
    public Doubled (Coffee c) {
        super(c, "Double", c.cost);
    }
}

class SteamedMilk extends CoffeeAdditions {
    public SteamedMilk(Coffee c){
        super(c, "Steamed Milk", 0.3);
    }
}

class SoyMilk extends CoffeeAdditions {
    public SoyMilk(Coffee c){
        super(c, "Soy Milk", 0.15);
    }
}

class Mocha extends CoffeeAdditions {
    public Mocha(Coffee c){
        super(c, "Mocha", 0.2);
    }
}

class WhippedCream extends CoffeeAdditions {
    public WhippedCream(Coffee c){
        super(c, "Whipped Cream", 0.3);
    }
}
class Main {
    public static void main(String[] args) {
        
        Coffee c = new Espresso();
        

        //modify coffee object through decorators 
        
        c = new WhippedCream(c);
        c = new SoyMilk(c);
        c = new Mocha(c);
        c = new Doubled(c);
        c.tallyPrice();
       
        
       
    }
}