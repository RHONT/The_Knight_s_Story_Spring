package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("ParamOutLawBridge")
@Scope("prototype")
public class ParamOutLawBridge {
    @Value("${outlowbridge.name}")
    String name;
    @Value("${outlowbridge.head}")
    int head;
    @Value("${outlowbridge.torso}")
    int torso;
    @Value("${outlowbridge.hands}")
    int hands;
    @Value("${outlowbridge.leags}")
    int leags;
    @Value("${outlowbridge.attack}")
    int attack;
}