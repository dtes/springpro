package spc.ripper.quoters;

import org.springframework.beans.factory.InitializingBean;
import spc.ripper.annotations.DeprecatedClass;
import spc.ripper.annotations.InjectRandomInt;
import spc.ripper.annotations.PostProxy;
import spc.ripper.annotations.Profiling;

import javax.annotation.PostConstruct;

@Profiling
@DeprecatedClass(newImpl = T1000.class)
public class TerminatorQuoter implements Quoter, InitializingBean {

    @InjectRandomInt(min = 2, max = 6)
    private int repeat;
    private String message;

    public TerminatorQuoter() {
        System.out.println("Phase 1");
        System.out.println(repeat);
    }

    // unpredictable order
    @PostConstruct
    public void phase2() {
        System.out.println("phase 2");
        System.out.println(repeat);
    }

    // unpredictable order
    @PostConstruct
    public void phase20() {
        System.out.println("phase 2.0");
    }

    // unpredictable order
    @PostConstruct
    public void phase200() {
        System.out.println("phase 2.0.0");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("phase 2.1");
    }

    public void phase22() {
        System.out.println("phase 2.2");
        //sayQuote();
    }

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("phase 3");
        for (int i = 0; i < repeat; i++) {
            System.out.println("message: " + message);
        }
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
