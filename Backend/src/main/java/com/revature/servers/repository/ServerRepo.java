package com.revature.servers.repository;

import com.revature.servers.model.Server;

import org.springframework.data.jpa.repository.JpaRepository;

/***
 * This ServerRepo interface extends Jpa Repository to locate the server by the following
 *
 * <ul>
 *     <li>Server IpAddress</li>
 * </ul>
 *
 */

public interface ServerRepo extends JpaRepository<Server, Long>{
    Server findByIpAddress(String ipAddress);
}
