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
        System.out.println(" *Please enter coins as follows: ");
        System.out.println("\tSample for pay way: {(5cents, 10cents, 20cents, 50cents, 100cents)  => (0,0,1,0,0):total=20cents, => (2,0,0,0,0):total=10+10=20cents}");
        System.out.println("\tPayment Ways: -Coins  -Card  -Notes");
        System.out.print("\tEnter Coins: ");

    }

    @Override
    public void enterCoins(int... coins) {
        VendingMachineRequest request = new VendingMachineRequest(selectedProduct, coins);
        change = controller.calculateChange(request);

    }

    @Override
    public void displayChangeMessage() {
        System.out.println("\n *Your Change is: "+ change.getTotal());
        for(Product product: Product.values()){
            if(change.getTotal() - product.getPrice() > 0) {
                System.out.println(" Return Amount: " + (change.getTotal() - product.getPrice()) + " Successful purchase, Happy Day!");
            }else if(change.getTotal() - product.getPrice() == 0) {
                System.out.println(" Return Amount: " + (change.getTotal() - product.getPrice()) + " Successful purchase, Happy Day!");

            }else {
                System.out.println(" Money not enough! Enter new amount ..");
            }
        }

    }
}



//System.out.println("    100 cents coins: "+ change.number100CentsCoins);
//System.out.println("    50 cents coins: "+ change.number50CentsCoins);
//System.out.println("    20 cents coins: "+ change.number20CentsCoins);
//System.out.println("    10 cents coins: "+ change.number10CentsCoins);
//System.out.println("    5 cents coins: "+ change.number5CentsCoins);