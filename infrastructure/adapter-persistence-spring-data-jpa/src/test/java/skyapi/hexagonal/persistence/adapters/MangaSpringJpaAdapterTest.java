package skyapi.hexagonal.persistence.adapters;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import skyapi.hexagonal.application.mappers.MangaMapper;
import skyapi.hexagonal.common.MangaTestCase;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.application.dto.MangaDTO;
import skyapi.hexagonal.persistence.jpa.adapters.MangaSpringJpaAdapter;
import skyapi.hexagonal.persistence.jpa.repositories.MangaRepository;

import javax.persistence.EntityExistsException;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class MangaSpringJpaAdapterTest extends MangaTestCase {

    private MangaRepository repository;
    private MangaSpringJpaAdapter tested;

    @BeforeEach
    void setUp(){
        repository = mock(MangaRepository.class);
        tested = new MangaSpringJpaAdapter(repository);
    }

    /**
     * Test 01:
     *  Guardar un nuevo manga en base de datos.
     *  Expect: 1- Comprobación de existencia del objeto que vamos a añadir
     *          2- Escritura en base de datos del objeto
     *  Result:
     *      El objeto devuelto en la escritura es igual al que queríamos guardar
     *
     */
    @Test
    public void create_succes(){
        Manga response;
        Manga manga = getMangaForTest();
        MangaDTO mangaToSave = MangaMapper.fromModelToDto(manga);

        //Mock the db response & prepare the data
        Mockito.when(repository.findById(mangaToSave.getId())).thenReturn(Optional.empty());
        Mockito.when(repository.save(any(Manga.class))).thenReturn(manga);
        //Call the method to test
        response = tested.create(manga);
        //Verify Expect
        verify(repository).findById(mangaToSave.getId());
        verify(repository).save(any(Manga.class));
        //Verify Results
        Assertions.assertEquals(manga, response);
    }
    /**
     * Test 02:
     *  Guardar un nuevo Manga en la base de datos
     *  Expect: 1- Comprobación de existencia del objeto que vamos a añadir
     *          2- No se escribe nada en base de datos
     *  Result:
     *      1a. Excepción: EntityExistsException con el id de nuestro manga.
     *
     */
    @Test
    public void create_shouldThrowEntityExistsException(){
        Manga savedManga = getMangaForTest();
        MangaDTO mangaToSave = MangaMapper.fromModelToDto(savedManga);

        when(repository.findById(mangaToSave.getId())).thenReturn(Optional.of(savedManga));
        EntityExistsException exception = assertThrows(EntityExistsException.class, () -> tested.create(savedManga));
        //Expect
        verify(repository).findById(mangaToSave.getId());
        verify(repository, never()).save(any(Manga.class));

        Assertions.assertEquals(exception.getMessage(), "Manga with id " + mangaToSave.getId() + " already exists");
    }
    /**
     * Test 03:
     *  Consultar la "información detallada" de un Manga
     *  Expect: 1- Búsqueda por id del Manga que buscamos
     *  Result:
     *       1- Se recupera la información detallada del manga
     *
     */
    @Test
    public void read_success(){

    }

}
