package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("ParamBear")
@Scope("prototype")
public class ParamBear {
    @Value("${bear.name}")
    String name;
    @Value("${bear.head}")
    int head;
    @Value("${bear.torso}")
    int torso;
    @Value("${bear.hands}")
    int hands;
    @Value("${bear.leags}")
    int leags;
    @Value("${bear.attack}")
    int attack;
}