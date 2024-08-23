package com.social.learning.ticket.api.controllers.impl;

import com.social.learning.ticket.api.controllers.CarreraController;
import com.social.learning.ticket.api.dto.CarreraDto;
import com.social.learning.ticket.api.services.CarreraService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/carreras")
@RequiredArgsConstructor
public class CarreraControllerImpl implements CarreraController {

  private final CarreraService carreraService;

  @Override
  @GetMapping
  public List<CarreraDto> findAll() {
    return this.carreraService.findAll();
  }

  @Override
  @GetMapping(value = "{id}")
  public CarreraDto findById(Long id) {
    return this.carreraService.findById( id );
  }

  @Override
  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CarreraDto create(CarreraDto carreraDto) {
    return this.carreraService.create( carreraDto );
  }

  @Override
  @PutMapping(value= "{id}")
  public CarreraDto edit(Long id, CarreraDto carreraDto) {
    return this.carreraService.edit( id, carreraDto );
  }

  @Override
  @DeleteMapping(value= "{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  public void delete(Long id) {
    this.carreraService.delete( id );
  }

}
