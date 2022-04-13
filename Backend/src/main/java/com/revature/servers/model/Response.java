package com.revature.servers.model;

import java.time.LocalDateTime;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

import org.springframework.http.HttpStatus;

import lombok.Data;
import lombok.experimental.SuperBuilder;


/***
 * This concrete Response class has the following protected fields to be passed as json fields
 *
 * <ul>
 *     <li>timeStamp </li> for time response
 *     <li>Server statusCode</li>
 *     <li>Http status</li>
 *     <li>Reason</li>
 *     <li>Message</li>
 *     <li>Developer Message</li>
 *     <li>Data</li> to map out the Server Class response
 * </ul>
 *
 */

@Data
@SuperBuilder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {

    protected LocalDateTime timeStamp;
    protected int statusCode;
    protected HttpStatus status;
    protected String reason;
    protected String message;
    protected String developerMessage;
    protected Map<?, ?> data;
    
}
