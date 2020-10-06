package creationalPattern.simpleFatory;

/**
 * @author Fitz
 * @create 2020-10-06-9:12 下午
 */
public class ShoeTest {
    public static void main(String[] args) {
        Shoe nike = ShoeFactory.createShoeObject("Nike");
        nike.produce();
        Shoe adidas = ShoeFactory.createShoeObject("Adidas");
        adidas.produce();
    }
}

