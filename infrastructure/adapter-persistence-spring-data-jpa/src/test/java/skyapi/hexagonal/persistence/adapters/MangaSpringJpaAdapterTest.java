package skyapi.hexagonal.persistence.adapters;

import jakarta.persistence.EntityExistsException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import skyapi.hexagonal.common.MangaTestCase;
import skyapi.hexagonal.domain.model.Manga;
import skyapi.hexagonal.persistence.jpa.adapters.MangaSpringJpaAdapter;
import skyapi.hexagonal.persistence.jpa.entities.MangaEntity;
import skyapi.hexagonal.persistence.jpa.mappers.GenericMapper;
import skyapi.hexagonal.persistence.jpa.mappers.MangaMapper;
import skyapi.hexagonal.persistence.jpa.repositories.MangaRepository;

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
        Manga response = Manga.builder().build();
        Manga mangaToSave = getMangaForTest();
        MangaEntity entity = MangaMapper.fromModelToEntity(mangaToSave);
        //Mock the db response & prepare the data
        Mockito.when(repository.findById(mangaToSave.getId())).thenReturn(Optional.empty());
        Mockito.when(repository.save(any(MangaEntity.class))).thenReturn(entity);
        //Call the method to test
        response = tested.create(mangaToSave);
        //Verify Expect
        verify(repository).findById(entity.getId());
        verify(repository).save(any(MangaEntity.class));
        //Verify Results
        Assertions.assertEquals(mangaToSave, response);
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
        Manga mangaToSave = getMangaForTest();
        MangaEntity entity = MangaMapper.fromModelToEntity(mangaToSave);
        when(repository.findById(mangaToSave.getId())).thenReturn(Optional.of(entity));
        EntityExistsException exception = assertThrows(EntityExistsException.class, () -> tested.create(mangaToSave));
        //Expect
        verify(repository).findById(mangaToSave.getId());
        verify(repository, never()).save(any(MangaEntity.class));

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
