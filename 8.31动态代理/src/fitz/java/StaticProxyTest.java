package fitz.java;

/**
 * @author Fitz
 * @create 2020-08-31-10:58 上午
 */

interface CloseFactory {

    void produceClose();
}



class ProxyFactory implements CloseFactory {

    private CloseFactory factory;

    public ProxyFactory(CloseFactory factory) {
        this.factory = factory;
    }

    @Override
    public void produceClose() {
        System.out.println("代理工厂准备原材料！");
        factory.produceClose();
        System.out.println("代理工厂完成了工作!");
    }
}

class NikeFactory implements CloseFactory
{

    @Override
    public void produceClose() {
        System.out.println("Nike生产了一匹衣服！");
    }
}


public class StaticProxyTest {
    public static void main(String[] args) {
        NikeFactory nikeFactory = new NikeFactory();
        ProxyFactory proxyFactory = new ProxyFactory(nikeFactory);
        proxyFactory.produceClose();
    }
}
