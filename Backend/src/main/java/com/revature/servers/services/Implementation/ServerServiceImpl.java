package com.revature.servers.services.Implementation;

import java.io.IOException;
import java.net.InetAddress;
import java.util.Collection;
import java.util.Random;

import com.revature.servers.enumeration.Status;
import com.revature.servers.model.Server;
import com.revature.servers.services.ServerService;

import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.revature.servers.repository.ServerRepo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/***
 * This ServerServiceImpl class implements the ServerService interface
 *
 */


@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class ServerServiceImpl implements ServerService{

    private final ServerRepo serverRepo;

    /***
     *  Implementing create interface to save a new server to the Server database
     *
     */
    @Override
    public Server create(Server server) {
        log.info("Saving new server: {}", server.getName());
        server.setImageUrl(setServerImageUrl());
        return serverRepo.save(server);
    }

    /***
     *  Implementing list interface to fetch all servers from the database
     *
     */
    @Override
    public Collection<Server> list(int limit) {
        log.info("Fetching all servers");
        return serverRepo.findAll(PageRequest.of(0, limit)).toList();
    }

    /***
     *  Implementing get interface to fetch a server from the database by id
     *
     */
    @Override
    public Server get(Long id) {
        log.info("Fetching server by id: {}", id);
        return serverRepo.findById(id).get();
    }

    /***
     *  Implementing update interface to update the Server database
     *
     */
    @Override
    public Server update(Server server) {
        log.info("Updating server: {}", server.getName());
        return serverRepo.save(server);
    }


    /***
     *  Implementing delete interface to delete a server from the database by id
     *
     */
    @Override
    public Boolean delete(Long id) {
        log.info("Deleting server: {}", id);
        serverRepo.deleteById(id);
        return Boolean.TRUE;
    }

    /***
     *  Implementing ping interface to ping a server from the database by ipAddress
     *
     */
    @Override
    public Server ping(String ipAddress) throws IOException {
        log.info("Pinging server IP: {}", ipAddress);
        Server server = serverRepo.findByIpAddress(ipAddress);
        InetAddress address = InetAddress.getByName(ipAddress);
        server.setStatus(address.isReachable(10000) ? Status.SERVER_UP : Status.SERVER_DOWN);
        serverRepo.save(server);
        return server;
    }

    /***
     *  Implementing the image url and path
     *
     */
    private String setServerImageUrl() {
        String[] imageNames = {"business3.png", "donate.png", "finance.png"};

        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/server/image/" + imageNames[new Random().nextInt(4)]).toUriString();
    }
    
}
