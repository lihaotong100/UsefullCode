package designPattern.templateMethodPattern;

public abstract class CaffeineBeverageWithHook {

    void prepareRecipe(){
        boilWater();
        brew();
        pourInCup();
        if(customerWantsCondiments()){
            addCondiments();
        }
    }

    abstract void brew();

    abstract void addCondiments();

    void boilWater(){
        System.out.print("Boil water");
    }

    final void pourInCup(){
        System.out.print("Pouring into cup");
    }

    boolean customerWantsCondiments(){
        return true;
    }
}
