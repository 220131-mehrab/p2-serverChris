package com.revature.servers.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import com.revature.servers.enumeration.Status;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/***
 * This concrete Server class has the following fields for functionality use
 *
 * <ul>
 *     <li>Server Id</li>
 *     <li>Server Name</li>
 *     <li>Server Memory Storage</li>
 *     <li>Server/System type</li>
 *     <li>Server Image Url</li>
 *     <li>Server Status</li>
 * </ul>
 *
 */

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Server {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    @NotEmpty(message = "IP Address cannot be empty or null")
    
    private String ipAddress;
    private String name;
    private String memory;
    private String type;
    private String imageUrl;
    private Status status;

}
