package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ParamOutLowSmall")
@Scope("prototype")
public class ParamOutLowSmall {
    @Value("${outlowsmall.name}")
    String name;
    @Value("${outlowsmall.head}")
    int head;
    @Value("${outlowsmall.torso}")
    int torso;
    @Value("${outlowsmall.hands}")
    int hands;
    @Value("${outlowsmall.leags}")
    int leags;
    @Value("${outlowsmall.attack}")
    int attack;
}


