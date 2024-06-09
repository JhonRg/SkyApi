package skyapi.hexagonal.mappers;

import org.springframework.beans.BeanUtils;

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