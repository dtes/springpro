package spc.ripper.quoters;

import spc.ripper.quoters.annotations.PostProxy;

public class T1000 extends TerminatorQuoter implements Quoter {

    @Override
    @PostProxy
    public void sayQuote() {
        System.out.println("I'm liquid");
    }
}
