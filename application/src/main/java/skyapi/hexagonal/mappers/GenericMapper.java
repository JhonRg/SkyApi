package skyapi.hexagonal.mappers;

import org.springframework.beans.BeanUtils;

public interface GenericMapper<D, M> {
    static <D, M> D fromModelToDto(D dto, M model){
        BeanUtils.copyProperties(model, dto);
        return dto;
    }
    static <D, M> M fromDtoToModel(M model, D dto){
        BeanUtils.copyProperties(dto, model);
        return model;
    }
}