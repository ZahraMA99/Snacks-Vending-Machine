package snacksVendingMachine;

public interface VendingMachineInterface {

    void displayProducts();
    void selectProduct(int product);
    void displayEnterCoinsMessage();
    void enterCoins(int... coins);
    void displayChangeMessage();
}