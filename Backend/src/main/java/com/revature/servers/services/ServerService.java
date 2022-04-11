package com.revature.servers.services;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

import com.revature.servers.model.Server;

public interface ServerService {
    Server create(Server server);
    Server ping(String ipAddress) throws UnknownHostException, IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
