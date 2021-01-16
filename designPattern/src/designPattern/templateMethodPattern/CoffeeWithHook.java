package designPattern.templateMethodPattern;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CoffeeWithHook extends CaffeineBeverageWithHook{

    @Override
    public void brew() {
        System.out.println("Dripping Coffe through filter");
    }

    @Override
    public void addCondiments() {
        System.out.println("Add sugar");
    }

    public boolean customerWantsCondiments(){
        String answer = getUserInput();
        if("y".equalsIgnoreCase(answer)){
            return true;
        }else{
            return false;
        }
    }

    private String getUserInput(){
        String answer = null;
        System.out.print("Would you like milk and sugar with your coffe(y/n)");

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            answer = in.readLine();
        }catch (Exception e){
            e.printStackTrace();
        }

        if(answer == null)
            return "no";
        return answer;
    }
}