package com.social.learning.ticket.api.services;

import com.social.learning.ticket.api.dto.CarreraDto;
import com.social.learning.ticket.api.entities.Carrera;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConvertService {

  private final ModelMapper mapper = new ModelMapper();

  public Carrera convertToEntity(CarreraDto carreraDto) {
    log.debug("START convertToEntity({})", carreraDto.getNombre());
    return mapper.map( carreraDto, Carrera.class );
  }

  public CarreraDto convertToDto(Carrera carrera) {
    log.debug("START convertToDto({})", carrera.getNombre());
    return mapper.map( carrera, CarreraDto.class );
  }

}
