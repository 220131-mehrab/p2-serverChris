package com.revature.servers.repository;

import com.revature.servers.model.Server;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long>{
    Server findByIpAddress(String ipAddress);
}
