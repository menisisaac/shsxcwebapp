package com.shsxctf.admin;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.shsxctf.admin.services.FileStorageService;

@SpringBootApplication
public class AdminApplication implements CommandLineRunner{
	@Resource
	FileStorageService storageService;
	public static void main(String[] args) {
		SpringApplication.run(AdminApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		storageService.deleteAll();
		storageService.init();
	}

}
