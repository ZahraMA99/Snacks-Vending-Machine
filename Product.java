package snacksVendingMachine;

public enum Product {
    REEZES(1,18), LAYS(2,10), DONUTS(3,50), LOACKER(4,120), MALTESERS(5,100), EMPTY(0,0);

    private int selectionNumber;
    private int price;

    Product(int selectionNumber, int price){
        this.selectionNumber = selectionNumber;
        this.price = price;
    }

    public int getSelectionNumber(){
        return selectionNumber;
    }

    public int getPrice(){
        return this.price;
    }

    public static Product valueOf(int numberSelected){
        for(Product product: Product.values()){
            if(numberSelected == product.getSelectionNumber()){
                return product;
            }
        }
        return EMPTY;
    }    
    
}