package com.tfassih.overwatch_actual;

import org.opensky.model.*;
import org.opensky.api.OpenSkyApi;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class Overwatch_ActualApplication {
    public OpenSkyApi api = new OpenSkyApi();
    public static void main(String[] args) {
        SpringApplication.run(Overwatch_ActualApplication.class, args);
    }
    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx) throws IOException {
        OpenSkyStates os = api.getStates(0, null,
                new OpenSkyApi.BoundingBox(28.948028963126784,
                                            30.905033555847265,
                                            -91.40915506380026,
                                            -88.67282752368656));
        return args -> {
            System.out.println(os.getStates().toString());
            String[] aircraft = ctx.getBeanDefinitionNames();
            Arrays.sort(aircraft);
            for(String bname : aircraft){
                System.out.println(bname);
            }
        };
    }

}
