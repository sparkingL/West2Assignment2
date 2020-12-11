
public class IngredientSortOutException extends RuntimeException {

    public IngredientSortOutException() {
        super("果汁或啤酒售完");
    }

    public IngredientSortOutException(String message){
        super(message);
    }

}
