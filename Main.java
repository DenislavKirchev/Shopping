package shopping;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(){
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] peopleInput = scanner.nextLine().split(";");

        for(String personData:peopleInput){
            String[] parts = scanner.nextLine().split("=");
            String name = parts[0];
            double money = Double.parseDouble(parts[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }
        System.out.println();

        String[] productInput = scanner.nextLine().split(";");

        for(String productData:productInput){
            String[] parts = scanner.nextLine().split("=");
            String name = parts[0];
            double cost = Double.parseDouble(parts[1]);
            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
                return;
            }
        }

        String command = scanner.nextLine();
        while(!"END".equals(command)){
            String[] parts = scanner.nextLine().split(" ");
            String personName = parts[0];
            String productName = parts[1];

            Person buyer = people.get(personName);
            Product productToBuy = products.get(productName);
            try {
                buyer.buyProduct(productToBuy);
                System.out.printf("%s bought %s%n",personName,productName);
            } catch(IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
            command = scanner.nextLine();
        }

	/* Example for Input
	Peter=11;George=4
	Bread=10;Milk=2
	Peter Bread
	George Milk
	*/

    }
}
