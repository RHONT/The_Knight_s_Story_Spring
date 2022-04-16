package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("ParamKnight")
@Scope("prototype")
public class ParamKnight {
    @Value("${knight}")
    int[] array;

}