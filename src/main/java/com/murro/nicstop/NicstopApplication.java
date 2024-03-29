package com.murro.nicstop;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

import org.jline.reader.EndOfFileException;
import org.jline.reader.LineReader;
import org.jline.reader.LineReaderBuilder;
import org.jline.reader.UserInterruptException;
import org.jline.terminal.TerminalBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;



/*      ___
 *__  __\_/ ___ ___ _____ __ ____       ____     ____
 *| |/  | |/ __|   |_   _|_ | |\ \     |_  |   |  _ |
 *|  /| | | |___\ \  | | |_|| |/_/       | | _ | |_||
 *|_| |_|_|\___|___| |_|___ |_|          |_||_||____|
*/


@SpringBootApplication
public class NicstopApplication {
    
    public static final String VERSION_TITLE_PATH = 
            "application_version_title.txt";
    
    public static void printVersion(){
        try{
            Scanner input = new Scanner(new File(VERSION_TITLE_PATH));
            while (input.hasNextLine())
            {
               System.out.println(input.nextLine());
            }
        }
        catch(FileNotFoundException ex){
            System.err.println(VERSION_TITLE_PATH + " not found");
        }
        
    }

    public static void main(final String[] args) {
        printVersion();
        final ConfigurableApplicationContext context = 
            SpringApplication.run(NicstopApplication.class, args);




        try {
            final LineReader lineReader = LineReaderBuilder.builder()
                    .terminal(TerminalBuilder.builder().build())
                    .build();

            System.out.println("Введите Q для остановки приложения...");

            while (true) {
                final String line = lineReader.readLine();
                if ("Q".equalsIgnoreCase(line.trim())) {
                    System.out.println("Остановка приложения...");
                    context.close();
                    break;
                }
            }
        } 
        catch (IOException | EndOfFileException | UserInterruptException ex) {
            System.err.println(ex);
        }


    }

}
