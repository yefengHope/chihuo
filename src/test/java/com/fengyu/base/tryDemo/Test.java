package com.fengyu.base.tryDemo;

/**
 * Created by HanFeng on 2017/9/9.
 */
public class Test {


}

class Annoyance extends Exception {
    private static final long serialVersionUID = -103283053329417495L;
}
class Sneeze extends Annoyance {
    private static final long serialVersionUID = 7151088875257651930L;
}

class Human {

    public static void main(String[] args)
            throws Exception {
        try {
            try {
                throw new Sneeze();
            }
            catch ( Annoyance a ) {
                System.out.println("Caught Annoyance");
                throw a;
            }
        }
        catch ( Sneeze s ) {
            System.out.println("Caught Sneeze");
            return ;
        }
        finally {
            System.out.println("Hello World!");
        }
    }
}