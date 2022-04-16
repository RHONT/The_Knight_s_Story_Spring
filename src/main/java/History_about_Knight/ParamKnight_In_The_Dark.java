package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ParamKnight_In_The_Dark")
@Scope("prototype")
public class ParamKnight_In_The_Dark {
    @Value("${knight_in_the_dark.name}")
    String name;
    @Value("${knight_in_the_dark.head}")
    int head;
    @Value("${knight_in_the_dark.torso}")
    int torso;
    @Value("${knight_in_the_dark.hands}")
    int hands;
    @Value("${knight_in_the_dark.leags}")
    int leags;
    @Value("${knight_in_the_dark.attack}")
    int attack;
}
