package com.examen.nach;

import com.examen.nach.bean.IBeanConnectDb;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NachApplication implements CommandLineRunner {

    private IBeanConnectDb iBeanConnectDb;

    public static void main(String[] args) {
        SpringApplication.run(NachApplication.class, args);
    }

    public NachApplication(IBeanConnectDb iBeanConnectDb) {
        this.iBeanConnectDb = iBeanConnectDb;
    }

    @Override
    public void run(String... args) {
		this.iBeanConnectDb.prueba();
    }
}
