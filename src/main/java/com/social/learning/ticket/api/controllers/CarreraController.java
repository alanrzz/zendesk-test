package com.social.learning.ticket.api.controllers;

import com.social.learning.ticket.api.dto.CarreraDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@Tag(name = "Carreras", description = "Operaciones relacionadas con las carreras.")
public interface CarreraController {

  @Operation(summary = "Consulta de todas las carreras.")
  List<CarreraDto> findAll() throws Exception;

  @Operation(summary = "Consulta de una carrera por id.")
  CarreraDto findById(@PathVariable("id") Long id) throws Exception;

  @Operation(summary = "Creación de una carrera.")
  CarreraDto create(@Valid @RequestBody CarreraDto carreraDto) throws Exception;

  @Operation(summary = "Actualización de información de una carrera.")
  CarreraDto edit(@PathVariable("id") Long id, @Valid @RequestBody CarreraDto carreraDto) throws Exception;

  @Operation(summary = "Eliminación de una carrera.")
  void delete(@PathVariable("id") Long id) throws Exception;

}
