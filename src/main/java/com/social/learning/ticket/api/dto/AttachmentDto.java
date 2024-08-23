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
public class AttachmentDto {

  private String content_type;
  private String content_url;
  private Boolean deleted;
  private String file_name;
  private String height;
  private Long id;
  private Boolean inline;
  private Boolean malware_access_override;
  private String malware_scan_result;
  private String mapped_content_url;
  private Long size;
  private List<Object> thumbnails;
  private String url;
  private String width;

}
