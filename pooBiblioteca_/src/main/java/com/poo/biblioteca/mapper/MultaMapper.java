package com.poo.biblioteca.mapper;

import com.poo.biblioteca.dto.MultaDto;
import com.poo.biblioteca.model.Multa;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MultaMapper {
    MultaMapper INSTANCE = Mappers.getMapper(MultaMapper.class);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "validade", target = "validade")
    @Mapping(source = "reserva.id", target = "reservaId") // Se necessário
    MultaDto entityToDto(Multa multa);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "valor", target = "valor")
    @Mapping(source = "validade", target = "validade")
    @Mapping(source = "reservaId", target = "reserva.id") // Se necessário
    Multa dtoToEntity(MultaDto multaDto);
}
