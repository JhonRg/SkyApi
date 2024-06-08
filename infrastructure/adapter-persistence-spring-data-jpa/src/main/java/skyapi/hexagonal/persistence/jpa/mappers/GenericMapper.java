package skyapi.hexagonal.persistence.jpa.mappers;

import org.springframework.beans.BeanUtils;

/**
 *  TODO: Revisar el comportamiento. No debería volver una instancia modificada del objeto
 *  Tratar de corregir para mantener la inmutabilidad de los datos.
 */


public interface GenericMapper<E,M> {
    static <E, M> E fromModel(E entity, M model){
        BeanUtils.copyProperties(model, entity);
        return entity;
    }
    static <E, M> M toModel(M model, E entity){
        BeanUtils.copyProperties(entity, model);
        return model;
    }

}
