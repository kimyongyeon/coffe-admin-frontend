package tech.jhipster.samples.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.jhipster.samples.blog.domain.Authority;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, String> {}
