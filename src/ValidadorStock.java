public class ValidadorStock  extends Thread{

    private String producto;

    public ValidadorStock(String producto){
        this.producto = producto;
    }

    @Override
    public void run(){
        verificarStock(producto);
    }

    private void verificarStock(String producto){
        System.out.println("Consultando stock a la BD");
        System.out.println("procesando logica");
        System.out.println("Stock verificado para " + producto);
    }
}
