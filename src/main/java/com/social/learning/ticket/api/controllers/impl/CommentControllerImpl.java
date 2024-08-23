package com.social.learning.ticket.api.controllers.impl;

import com.social.learning.ticket.api.controllers.CommentController;
import com.social.learning.ticket.api.dto.CommentDto;
import com.social.learning.ticket.api.services.CommentService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comments")
@RequiredArgsConstructor
public class CommentControllerImpl implements CommentController {

  private final CommentService commentService;

  @Override
  @GetMapping(value = "/tickets/{ticketId}")
  public List<CommentDto> listComments(Long ticketId) {
    return commentService.listComments( ticketId );
  }

}
