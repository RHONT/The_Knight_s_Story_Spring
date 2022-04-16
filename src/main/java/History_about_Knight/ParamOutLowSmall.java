package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("ParamOutLowSmall")
@Scope("prototype")
public class ParamOutLowSmall {
    @Value("${outlowsmall}")
    int[] array;
}


