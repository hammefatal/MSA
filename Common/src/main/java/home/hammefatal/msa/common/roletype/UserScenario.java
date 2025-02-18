package home.hammefatal.msa.common.roletype;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface UserScenario {

    @AliasFor(annotation = Component.class)
    String value() default "";

}
