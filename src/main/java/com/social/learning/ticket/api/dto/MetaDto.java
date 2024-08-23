package com.social.learning.ticket.api.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MetaDto {

  private List<CommentDto> comments;
  private Long next_page;
  private Long previous_page;
  private Long count;

}
