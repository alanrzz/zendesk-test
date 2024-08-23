package com.social.learning.ticket.api.services;

import static java.util.stream.Collectors.toList;

import com.social.learning.ticket.api.dto.CarreraDto;
import com.social.learning.ticket.api.entities.Carrera;
import com.social.learning.ticket.api.exceptions.ResourceNotFoundException;
import com.social.learning.ticket.api.repositories.CarreraRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class CarreraService {

  private final CarreraRepository carreraRepository;
  private final ConvertService convertService;

  public List<CarreraDto> findAll() {
    log.debug("START findAll()");
    return carreraRepository.findAll().parallelStream()
        .map( convertService::convertToDto ).collect( toList() );
  }

  public CarreraDto findById(Long id) {
    log.debug("START findById({})", id);
    return convertService.convertToDto( findOrFail( id ) );
  }

  public CarreraDto create(CarreraDto carreraDto) {
    log.debug("START create({})", carreraDto.getId());
    try {
      Carrera carrera = carreraRepository.save( convertService.convertToEntity( carreraDto ) );
      return convertService.convertToDto( carrera );
    } catch (DataIntegrityViolationException ex) {
      throw new DataIntegrityViolationException( "La solicitud es inválida" );
    }
  }

  public CarreraDto edit(Long id, CarreraDto carreraDto) {
    log.debug("START edit({},{})", id, carreraDto.getNombre());
    findOrFail( id );
    Carrera carrera = this.convertService.convertToEntity( carreraDto );
    carrera.setId( id );
    return this.convertService.convertToDto( carreraRepository.save( carrera ) );
  }

  public void delete(Long id) {
    log.debug("START delete({})", id);
    carreraRepository.delete( findOrFail(id) );
  }

  private Carrera findOrFail(Long id) {
    log.debug("START findOrFail({})", id);
    return carreraRepository.findById( id ).orElseThrow(() -> new ResourceNotFoundException( "Carrera no encontrada" ));
  }

}
