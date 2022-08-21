package com.examen.nach.configuration;
import com.examen.nach.bean.BeanConnectDb;
import com.examen.nach.bean.IBeanConnectDb;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GeneralConfigurationBean {
    @Bean
    public IBeanConnectDb connectionDB(){
        return new BeanConnectDb();
    }
}
