package snacksVendingMachine;

import java.util.Scanner;
import snacksVendingMachine.TextVendingMachine; 
import snacksVendingMachine.VendingMachineInterface;


public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        VendingMachineInterface machineInterface = new TextVendingMachine();
        
        machineInterface.displayProducts();

        String selectedProduct = scanner.nextLine();
        machineInterface.selectProduct(Integer.parseInt(selectedProduct));

        machineInterface.displayEnterCoinsMessage();

        String userEnteredCoins = scanner.nextLine();
        int[] enteredCoins = Coin.parseCoins(userEnteredCoins);
        machineInterface.enterCoins(enteredCoins);

        machineInterface.displayChangeMessage();

    }
}