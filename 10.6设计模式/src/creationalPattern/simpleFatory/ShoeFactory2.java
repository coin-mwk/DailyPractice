package creationalPattern.simpleFatory;


/**
 * @author Fitz
 * @create 2020-10-06-9:33 下午
 */
public class ShoeFactory2 {

    public static Object getClass(Class<? extends Shoe> clazz) {
        Object obj = null;
        try {
            obj = Class.forName(clazz.getName()).newInstance();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
