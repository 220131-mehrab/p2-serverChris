package com.revature.servers.services;

import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Collection;

import com.revature.servers.model.Server;

/***
 * This ServerService interface has the following interface for the application
 *
 * <ul>
 *     <li>Create a server</li>
 *     <li>Ping a server</li>
 *     <li>Get a server</li>
 *     <li>Update the server</li>
 *     <li>Delete a server</li>
 *     <li>Get the list of the server</li>
 * </ul>
 *
 */

public interface ServerService {
    Server create(Server server);
    Server ping(String ipAddress) throws UnknownHostException, IOException;
    Collection<Server> list(int limit);
    Server get(Long id);
    Server update(Server server);
    Boolean delete(Long id);
}
