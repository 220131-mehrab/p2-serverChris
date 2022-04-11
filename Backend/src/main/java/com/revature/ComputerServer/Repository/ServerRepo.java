package com.revature.ComputerServer.Repository;

import com.revature.ComputerServer.Model.Server;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ServerRepo extends JpaRepository<Server, Long>{
    Server findByIpAddress(String ipAddress);
}
