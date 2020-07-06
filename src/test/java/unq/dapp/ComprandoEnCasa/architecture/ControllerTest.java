package unq.dapp.ComprandoEnCasa.architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

public class ControllerTest extends ArchitectureTest {

    @Test
    public void controllerClassesShouldBeAnnotatedWithRestControllerAnnotation() {
        ArchRule rule = ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Controller")
                .should().beAnnotatedWith(RestController.class);
        rule.check(classes);
    }

    @Test
    public void noClassesWithRestControllerAnnotationShouldResideOutsideOfWebServicesPackage() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Controller.class)
                .or().areAnnotatedWith(RestController.class)
                .should().resideOutsideOfPackage(WEB_SERVICE_PACKAGE);
        rule.check(classes);
    }

}
