package com.social.learning.ticket.api.services;

import com.social.learning.ticket.api.dto.CommentDto;
import com.social.learning.ticket.api.dto.MetaDto;
import com.social.learning.ticket.api.dto.ResponseDto;
import com.social.learning.ticket.api.dto.SlimTicketDto;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
@Slf4j
public class CommentService {

  private final WebClient.Builder webClientBuilder;

  @Value("${zendesk-api.token}")
  private String apiToken;
  @Value("${zendesk-api.email}")
  private String email;
  @Value("${zendesk-api.url}")
  private String baseUrl;
  @Value("${zendesk-api.new-comment}")
  private String newComment;

  public List<CommentDto> listComments(Long ticketId) {
    log.debug("START listComments({})", ticketId);
    List<CommentDto> comments =  webClientBuilder.build()
        .get()
        .uri( baseUrl + "/tickets/{ticketId}/comments.json", ticketId )
        .headers( httpHeaders -> httpHeaders.addAll( getHttpHeaders( email, apiToken ) ) )
        .retrieve()
        .bodyToMono( new ParameterizedTypeReference<MetaDto>() {} )
        .map( metaDto -> Optional.ofNullable( metaDto.getComments() ).orElse( Collections.emptyList() ) )
        .block();
    addComment( ticketId, newComment );
    return comments;
  }

  private void addComment(Long ticketId, String body) {
    log.debug("START addComment({},{})", ticketId, body);
    CommentDto commentDto = CommentDto.builder().body( body ).build();
    SlimTicketDto slimTicketDto = SlimTicketDto.builder().comment( commentDto ).build();
    webClientBuilder.build()
        .put()
        .uri(baseUrl + "/tickets/{ticketId}.json", ticketId)
        .headers( httpHeaders -> httpHeaders.addAll( getHttpHeaders( email, apiToken ) ) )
        .bodyValue( ResponseDto.builder().ticket( slimTicketDto ).build() )
        .retrieve().bodyToMono( SlimTicketDto.class )
        .block();
  }

  private HttpHeaders getHttpHeaders(String email, String apiToken) {
    HttpHeaders httpHeaders = new HttpHeaders();
    httpHeaders.setContentType( MediaType.APPLICATION_JSON );
    httpHeaders.setBasicAuth( Base64.getEncoder().encodeToString( (email + "/token:" + apiToken).getBytes() ) );
    return httpHeaders;
  }

}
