package creationalPattern.simpleFatory;

/**
 * @author Fitz
 * @create 2020-10-06-9:09 下午
 */
public class ShoeFactory {

    public static Shoe createShoeObject(String shoeName) {
        if (shoeName.equals("Nike")) {
            return new NikeShoe();
        }
        if (shoeName.equals("Adidas")) {
            return new AdidasShoe();
        }
        return null;
    }

}
