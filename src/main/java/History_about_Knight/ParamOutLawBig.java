package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("ParamOutLowBig")
@Scope("prototype")
public class ParamOutLawBig {
    @Value("${outlowbig.name}")
    String name;
    @Value("${outlowbig.head}")
    int head;
    @Value("${outlowbig.torso}")
    int torso;
    @Value("${outlowbig.hands}")
    int hands;
    @Value("${outlowbig.leags}")
    int leags;
    @Value("${outlowbig.attack}")
    int attack;
}