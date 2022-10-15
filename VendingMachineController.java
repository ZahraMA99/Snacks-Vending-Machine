package snacksVendingMachine;

public interface VendingMachineController {

    CoinBundle calculateChange(VendingMachineRequest request);
}
