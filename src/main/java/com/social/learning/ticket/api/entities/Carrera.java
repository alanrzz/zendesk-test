package com.social.learning.ticket.api.entities;

import com.social.learning.ticket.api.enums.ModalidadEstudio;
import com.social.learning.ticket.api.enums.NivelAcademico;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "carreras")
public class Carrera implements Serializable {

  @Serial
  private static final long serialVersionUID = 7436053047717849840L;

  @Id
  @Column(name = "id", unique = true, nullable = false)
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", nullable = false)
  private String nombre;

  @Column(name = "description")
  private String descripcion;

  @Column(name = "duration")
  private Integer duracion;

  @Column(name = "faculty")
  private String facultad;

  @Column(name = "level")
  private NivelAcademico nivelAcademico;

  @Column(name = "status")
  private Boolean activo;

  @Column(name = "requirements")
  private String requisitos;

  @Column(name = "start_date")
  private LocalDate fechaInicio;

  @Column(name = "end_date")
  private LocalDate fechaFin;

  @Column(name = "modality")
  private ModalidadEstudio modalidadEstudio;

}
