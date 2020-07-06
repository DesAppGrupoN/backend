package unq.dapp.ComprandoEnCasa.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.BeforeClass;


public abstract class ArchitectureTest {
    static final String DOMAIN_PACKAGE = "unq.dapp.ComprandoEnCasa.model..";
    static final String PERSISTENCE_PACKAGE = "unq.dapp.ComprandoEnCasa.persistence..";
    static final String SERVICES_PACKAGE = "unq.dapp.ComprandoEnCasa.services..";
    static final String WEB_SERVICE_PACKAGE = "unq.dapp.ComprandoEnCasa.webService..";

    static JavaClasses classes;

    @BeforeClass
    public static void setUp() {
        classes = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
                .importPackages("unq.dapp.ComprandoEnCasa");
    }
}
