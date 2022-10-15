package snacksVendingMachine;

public class TextVendingMachine implements VendingMachineInterface {

    private VendingMachineController controller = new SimpleVendingMachineController();
    private int selectedProduct;
    private CoinBundle change;


    @Override
    public void displayProducts() {
        System.out.println("-----------------------------------");
        System.out.println("     SNACK VENDING MACHINE          ");
        System.out.println("           WELCOME          ");
        System.out.println("-----------------------------------");
        System.out.println("\n *PRODUCTS AVILABLE:\n");
        System.out.println("\t   Kind: Price");
        System.out.println("\t-----------------");
        for(Product product: Product.values()){
            if(!Product.EMPTY.equals(product)) {
                System.out.println("\t" + product.getSelectionNumber() + ". " + product.name() + ": " + product.getPrice());
            }
        }
        System.out.println("-----------------------------------\n");
        System.out.print(" *Please select your product: ");


    }

    @Override
    public void selectProduct(int product) {
        this.selectedProduct = product;
    }

    @Override
    public void displayEnterCoinsMessage() {
        System.out.println(" Please enter coins as follows: ");
        System.out.println(" num of 5 cents coins,num of 10 cents coins,num of 20 cents coins,num of 50 cents coins,num of 100 cents coins\n");
        System.out.println(" Example: If you would like to enter 2 ten cents coins: 0,0,2,0,0\n");
        System.out.println(" Please enter coins:");

    }

    @Override
    public void enterCoins(int... coins) {
        VendingMachineRequest request = new VendingMachineRequest(selectedProduct, coins);
        change = controller.calculateChange(request);

    }

    @Override
    public void displayChangeMessage() {
        System.out.println("                                              ");
        System.out.println("Your change is :"+ change.getTotal()+"cents split as follows: ");
        System.out.println("    100 cents coins: "+ change.number100CentsCoins);
        System.out.println("    50 cents coins: "+ change.number50CentsCoins);
        System.out.println("    20 cents coins: "+ change.number20CentsCoins);
        System.out.println("    10 cents coins: "+ change.number10CentsCoins);
        System.out.println("    5 cents coins: "+ change.number5CentsCoins);

    }
}