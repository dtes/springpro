package spc.ripper.screensaver;

import javafx.util.Pair;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import static java.time.LocalDateTime.*;

public class PeriodicalScopeConfigurer implements Scope {

    private Map<String, Pair<LocalDateTime, Object>> map = new HashMap<>();

    @Override
    public Object get(String s, ObjectFactory<?> objectFactory) {
        if (map.containsKey(s)) {
            Pair<LocalDateTime, Object> pair = map.get(s);
            if (Duration.between(pair.getKey(), now()).getSeconds() > 3) {
                map.put(s, new Pair<>(now(), objectFactory.getObject()));
            }
        } else {
            map.put(s, new Pair<>(now(), objectFactory.getObject()));
        }
        return map.get(s).getValue();
    }

    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return null;
    }
}
