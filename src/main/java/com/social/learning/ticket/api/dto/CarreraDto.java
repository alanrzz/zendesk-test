package com.social.learning.ticket.api.dto;

import com.social.learning.ticket.api.enums.ModalidadEstudio;
import com.social.learning.ticket.api.enums.NivelAcademico;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDto {

  private Long id;
  private String nombre;
  private String descripcion;
  private Integer duracion;
  private String facultad;
  private NivelAcademico nivelAcademico;
  private Boolean activo;
  private String requisitos;
  private LocalDate fechaInicio;
  private LocalDate fechaFin;
  private ModalidadEstudio modalidadEstudio;

}
