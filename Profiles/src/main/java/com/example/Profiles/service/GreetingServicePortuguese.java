package com.example.Profiles.service;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("portuguese")
public class GreetingServicePortuguese implements GreetingsService{
        @Override
        public String sayHello(String name){
            return "Olá " + name;
        }
}
