package skyapi.hexagonal.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import skyapi.hexagonal.persistence.jpa.entities.MangaEntity;

public interface MangaRepository extends JpaRepository<MangaEntity, Long> {
}
