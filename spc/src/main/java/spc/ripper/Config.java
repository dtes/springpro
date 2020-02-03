package spc.ripper;

import org.springframework.context.annotation.*;
import spc.ripper.screensaver.ColorFrame;

import java.awt.*;
import java.util.Random;

@Configuration
@ComponentScan(basePackages = "spc.ripper.screensaver")
public class Config {

    @Bean
    //@Scope("prototype")
    //@Scope(value = "prototype", proxyMode = ScopedProxyMode.TARGET_CLASS)
    @Scope("periodical")
    public Color color() {
        Random random = new Random();
        System.out.println("color");
        return new Color(random.nextInt(255), random.nextInt(255), random.nextInt(255));
    }

    @Bean
    public ColorFrame colorFrame() {
        return new ColorFrame() {
            @Override
            public Color getColor() {
                return color();
            }
        };
    }

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
        while (true) {
            Thread.sleep(100);
            context.getBean(ColorFrame.class).showOnRandomPlace();
        }
    }

}
