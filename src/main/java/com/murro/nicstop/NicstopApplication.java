package com.murro.nicstop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/*      ___
 *__  __\_/ ___ ___ _____ __ ____       ____     ____
 *| |/  | |/ __|   |_   _|_ | |\ \     |_  |   |  _ |
 *|  /| | | |___\ \  | | |_|| |/_/       | | _ | |_||
 *|_| |_|_|\___|___| |_|___ |_|          |_||_||____|
*/


@SpringBootApplication
public class NicstopApplication {
    
    public static void printVersion(){
        System.out.println("""
                                 ___
                           __  __\\_/ ___ ___ _____ __ ____       ____     ____
                           | |/  | |/ __|   |_   _|_ | |\\ \\     |_  |   |  _ |
                           |  /| | | |___\\ \\  | | |_|| |/_/       | | _ | |_||
                           |_| |_|_|\\___|___| |_|___ |_|          |_||_||____|
           
                                   ____ __  __
                                   |  _ | |/  |
                                   | |_||  /| |
                                   |____|_| |_|
                           """);
    }

	public static void main(String[] args) {
                printVersion();
		SpringApplication.run(NicstopApplication.class, args);
	}

}
