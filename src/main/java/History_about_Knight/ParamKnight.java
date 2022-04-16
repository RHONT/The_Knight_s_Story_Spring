package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("ParamKnight")
@Scope("prototype")
public class ParamKnight {
    @Value("${knight.head}")
    int head;
    @Value("${knight.torso}")
    int torso;
    @Value("${knight.leags}")
    int leags;
    @Value("${knight.hands}")
    int hands;
    @Value("${knight.attack}")
    int attack;
}