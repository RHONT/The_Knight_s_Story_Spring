package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ParamKnight_In_The_Dark")
@Scope("prototype")
public class ParamKnight_In_The_Dark {
    @Value("${knight_in_the_dark}")
    int[] array;
}
