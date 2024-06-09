package skyapi.hexagonal.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import skyapi.hexagonal.domain.model.Manga;

public interface MangaRepository extends JpaRepository<Manga, Long> {
}
