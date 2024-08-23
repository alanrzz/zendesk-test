package com.social.learning.ticket.api.controllers;

import com.social.learning.ticket.api.dto.CommentDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import org.springframework.web.bind.annotation.PathVariable;

@Tag(name = "Comments", description = "Operaciones relacionadas con los comentarios.")
public interface CommentController {

  @Operation(summary = "Consulta de todos los comentarios de un ticket.")
  List<CommentDto> listComments(@PathVariable("ticketId") Long ticketId) throws Exception;

}
