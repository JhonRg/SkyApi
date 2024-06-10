package skyapi.hexagonal.out.persistence.adapter;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import skyapi.hexagonal.application.common.MangaTestCase;
import skyapi.hexagonal.out.persistence.api.MangaRepositoryJpaAdapter;
import skyapi.hexagonal.domain.model.Manga;

import java.util.List;

import static org.mockito.Mockito.*;

public class MangaPersistenceAdapterTest extends MangaTestCase {

    private MangaRepositoryJpaAdapter repository;
    private MangaPersistenceAdapter tested;

    @BeforeEach
    void setUp(){
        repository = mock(MangaRepositoryJpaAdapter.class);
        tested = new MangaPersistenceAdapter(repository);
    }

    /**
     * Test 01:
     *  Consultar la lista de mangas guardados
     * Expect:
     *      1- Se realiza una llamada al repositorio para traer la lista de mangas
     * Result:
     *      1- Se devuelve una lista de todos los mangas de la base de datos.
     */
    @Test
    public void getAllMangas_succed(){
        List<Manga> mangas = getListOfMangas(10);

        when(repository.getAllMangas()).thenReturn(mangas);

        List<Manga> retrievedMangas = tested.getAllMangas();

        verify(repository, times(1)).getAllMangas();

        Assertions.assertEquals(mangas, retrievedMangas);
    }
}
