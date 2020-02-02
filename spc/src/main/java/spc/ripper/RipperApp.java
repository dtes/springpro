package spc.ripper;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import spc.ripper.quoters.Quoter;
import spc.ripper.quoters.TerminatorQuoter;

public class RipperApp {
    public static void main(String[] args) throws InterruptedException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context-ripper.xml");
        //context.getBean(Quoter.class).sayQuote();
        /*while (true) {
            context.getBean(Quoter.class).sayQuote();
            Thread.sleep(300);
        }*/
    }
}
