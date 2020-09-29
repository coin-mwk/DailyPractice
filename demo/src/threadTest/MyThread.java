package threadTest;


import java.util.concurrent.Callable;

/**
 * @author Fitz
 * @create 2020-09-29-4:42 下午
 */
public class MyThread implements Callable<Double>{

    public String mesordName = "";
    public double price = 0.0d;

    public MyThread(String mesordName) {
        this.mesordName = mesordName;
    }

    public String getMesordName() {
        return mesordName;
    }

    public void setMesordName(String mesordName) {
        this.mesordName = mesordName;
    }

    @Override
    public Double call() throws Exception {
        if (mesordName.equals("加工")){
            //计算加工成本
            price = 12.0d;
            System.out.println("正在进行加工成本！");
            System.out.println("加工成本为：" + price);

        }else if (mesordName.equals("核算")) {
            //计算核算成本
            price = 11.0d;
            System.out.println("正在进行核算成本！");
            System.out.println("核算成本为：" + price);
        }

        return price;
    }





}
