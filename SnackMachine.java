package snacksVendingMachine;

import java.util.Scanner; 
import snacksVendingMachine.VendingMachineMessages; 
import snacksVendingMachine.VendingMachineInterface;
import snacksVendingMachine.Product;



public class SnackMachine {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        VendingMachineInterface machineInterface = new VendingMachineMessages();
        
        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        for(Product product: Product.values()){
            if(Integer.parseInt(selectedProduct) == product.getSelectionNumber()) {
                System.out.println("\t" + " => Price of " + product.name() +" = "+ product.getPrice() + "\n");
            }
        }

        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = scanner.nextLine();
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
        machineInterface.enterCoins(enteredCoins);

        machineInterface.selectProduct(Integer.parseInt(selectedProduct));
        machineInterface.displayChangeMessage();

    }
}