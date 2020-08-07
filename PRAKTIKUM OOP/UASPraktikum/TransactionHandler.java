import java.lang.reflect.Field;

public class TransactionHandler {

    private Buyer buyer;
    private Product product;
    private Courier courier;


    public TransactionHandler(Buyer buyer, Product product, Courier courier) {
        this.buyer = buyer;
        this.product = product;
        this.courier = courier;
    }

    public void execute() throws TransactionFailedException {
        try {
            Field saldoField = this.buyer.getClass().getDeclaredField("saldo");
            saldoField.setAccessible(true);
            int saldo = saldoField.getInt(this.buyer);
            int hargaTotal = this.product.getPrice() + this.courier.checkPrice(product.getPosition(), buyer.getPosition());
            if(saldo >= hargaTotal) {
                Field stockField = this.product.getClass().getDeclaredField("stock");
                stockField.setAccessible(true);
                int stock =  stockField.getInt(this.product);
                if(stock > 0) {
                    this.buyer.substractSaldo(hargaTotal);
                    this.product.decrementStock();
                    this.courier.addToQueue(this.product, this.buyer, this.product);
                }
                else {
                    throw new ProductOutOfStockException("Produk habis");
                }
            }
            else {
                throw new NotEnoughMoneyException(String.format("membutuhkan uang %d sedangkan saldo hanya %d", hargaTotal, saldo));
            }
            
        }
        catch (ProductOutOfStockException productOutOfStockException) {
            throw new TransactionFailedException("Transaksi gagal");
        }
        catch (NotEnoughMoneyException notEnoughMoneyException) {
            System.out.println(notEnoughMoneyException.getMessage());
        }
        catch (Exception exception) {

        }
    }
}