package History_about_Knight;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@Component("ParamOutLawBridge")
@Scope("prototype")
public class ParamOutLawBridge {
    @Value("${outlowbridge}")
    int[] array;
}