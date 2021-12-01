class TestDrive {
    public static void main(String[] args) throws InterruptedException {
        BurgerFactory burgerStore = new BurgerStore();

        burgerStore.orderBurger("Chinese Burger");
        burgerStore.orderBurger("American Burger");
        burgerStore.orderBurger("Russian Burger");
    }
}

// Abstract Creator
abstract class BurgerFactory {

    abstract Burger createBurger(String type);

    Burger orderBurger(String type) throws InterruptedException {
        Burger burger = createBurger(type);
        if (burger == null) {
            System.out.println("Sorry, we are not able to create this kind of burger\n");
            return null;
        }
        System.out.println("Making a " + burger.getName());
        burger.putBun();
        burger.putCutlet();
        burger.putSauce();
        Thread.sleep(1500L);
        System.out.println("Done a " + burger.getName() + "\n");
        return burger;
    }
}

// Concrete Creator
class BurgerStore extends BurgerFactory {
    @Override // Factory Method
    Burger createBurger(String type) {
        switch (type) {
            case "Chinese Burger":
                return new ChineseBurger("Chinese Burger");

            case "American Burger":
                return new AmericanBurger("American Burger");

            case "Russian Burger":
                return new RussianBurger("Russian Burger");

            default:
                return null;
        }
    }
}

// Abstract Product | Should the burger assemble it self ?
abstract class Burger {
    private String name;

    Burger(String name) {
        this.name = name;
    }

    String getName() {
        return name;
    }

    void putBun() {
        System.out.println("Putting bun");
    }

    void putCutlet() {
        System.out.println("Putting cutlet");
    }

    void putSauce() {
        System.out.println("Putting sauce");
    }

}

// Concrete Products
class ChineseBurger extends Burger {
    ChineseBurger (String name){
        super(name);
    }
}

class AmericanBurger extends Burger {
    public AmericanBurger(String name) {
        super(name);
    }
}

class RussianBurger extends Burger {
    public RussianBurger(String name) {
        super(name);
    }
}