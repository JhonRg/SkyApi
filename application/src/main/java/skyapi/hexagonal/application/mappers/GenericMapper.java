package skyapi.hexagonal.application.mappers;

import org.springframework.beans.BeanUtils;

public interface GenericMapper<D, M> {
    static <D, M> void fromModelToDto(D dto, M model){
        BeanUtils.copyProperties(model, dto);
    }
    static <D, M> void fromDtoToModel(M model, D dto){
        BeanUtils.copyProperties(dto, model);
    }
}