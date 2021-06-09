package tech.jhipster.samples.blog;

import static com.tngtech.archunit.lang.syntax.ArchRuleDefinition.noClasses;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.jupiter.api.Test;

class ArchTest {

	@Test
	void servicesAndRepositoriesShouldNotDependOnWebLayer() {
		JavaClasses importedClasses = new ClassFileImporter()
			.withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
			.importPackages("tech.jhipster.samples.blog");

		noClasses()
			.that()
			.resideInAnyPackage("tech.jhipster.samples.blog.service..")
			.or()
			.resideInAnyPackage("tech.jhipster.samples.blog.repository..")
			.should()
			.dependOnClassesThat()
			.resideInAnyPackage("..tech.jhipster.samples.blog.web..")
			.because("Services and repositories should not depend on web layer")
			.check(importedClasses);
	}
}
