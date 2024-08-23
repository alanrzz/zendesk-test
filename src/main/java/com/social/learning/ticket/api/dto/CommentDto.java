package com.social.learning.ticket.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentDto {

  private List<AttachmentDto> attachments;
  private Long audit_id;
  private Long author_id;
  private String body;
  private String created_at;
  private String html_body;
  private Long id;
  private Object metadata;
  private String plain_body;
  @JsonProperty("public")
  private Boolean isPublic;
  private String type;
  private List<String> uploads;
  private Object via;

}
