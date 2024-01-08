public class Filtros {
    public static Filtrable vendible(){
        return producto -> producto.getPrecio()>0;
    }

    public static Filtrable descartable(){
        return producto -> producto.getPrecio()==0;
    }

    public static Filtrable imperecedero() throws Exception{
        try{
            return producto -> producto.getCodigo().equals("10");
        }catch (Exception e){
            return (Filtrable) new Exception("No es imperecedero");
        }

    }
}
