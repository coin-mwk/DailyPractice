package fitz.java;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author Fitz
 * @create 2020-09-01-8:53 上午
 */


interface Human {
    void eat(String food) ;
    String belief();
}


class SuperMan implements Human {


    @Override
    public void eat(String food) {
        System.out.println("我喜欢吃"+food);
    }

    @Override
    public String belief() {
        String str = "我说蝙蝠侠是我的信仰你信吗！";
        return str;
    }
}

/**
* 要想实现动态代理需要解决的问题：
* 1、如何根据加载到内存中的被代理类，动态的创建一个代理类及其对象
* 2、当通过代理类的对象调用方法时，如何动态的去调用被代理类中的同名方法
 *
 */
class NewProxyFactory {
    //调用此方法，返回一个代理类的对象，解决问题一
    public static Object getInstance(Object obj) {
        MyInvocationHandler myInvocationHandler = new MyInvocationHandler();
        myInvocationHandler.bind(obj);
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),myInvocationHandler);

    }
}

class MyInvocationHandler implements InvocationHandler {
    Object obj; //需要使用被代理类的对象进行赋值
    public void bind(Object obj) {
        this.obj = obj;
    }
    //当我们通过代理类的对象调用方法A时，就会自动的调用如下的方法invoke()
    //将被代理类要执行的方法A的功能声明在invoke()方法中
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //method即为代理类对象调用的方法，此方法也作为被代理类要调用的方法
        Object o = method.invoke(obj, args);
        return o;

    }
}

public class ProxyTest {

    public static void main(String[] args) {
        SuperMan superMan = new SuperMan();
        Human is = (Human) NewProxyFactory.getInstance(superMan);
        System.out.println(is.belief());
        is.eat("牛排");
        NikeFactory nikeFactory = new NikeFactory();
        CloseFactory nike = (CloseFactory) NewProxyFactory.getInstance(nikeFactory);
        nike.produceClose();


    }
}
