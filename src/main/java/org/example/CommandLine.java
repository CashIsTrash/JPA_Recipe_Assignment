package org.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
public class CommandLine implements CommandLineRunner {


    @Autowired
    public CommandLine() {
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {


    }
}
