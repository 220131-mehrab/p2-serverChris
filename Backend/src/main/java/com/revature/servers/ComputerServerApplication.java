package com.revature.servers;

import com.revature.servers.enumeration.Status;
import com.revature.servers.model.Server;
import com.revature.servers.repository.ServerRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ComputerServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComputerServerApplication.class, args);
	}

	CommandLineRunner run(ServerRepo serverRepo){
		return args -> {
			serverRepo.save(new Server(null, "192.168.1.160", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server/image/business3.png", Status.SERVER_UP));
			serverRepo.save(new Server(null, "192.168.1.190", "Ubuntu Linux", "16 GB", "Company PC", "http://localhost:8080/server/image/donate.png", Status.SERVER_DOWN));
			serverRepo.save(new Server(null, "192.168.1.140", "Ubuntu Linux", "16 GB", "Personal PC", "http://localhost:8080/server/image/finance.png", Status.SERVER_DOWN));
		};
	}

}
