package me.karunarathne.ProgrammingQuestions ;

class PrintColor {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
}

public class Prints {
    static void println (String stuff, String color) {
        System.out.println (color + stuff) ;
    }

    static void print (String stuff, String color) {
        System.out.print (color + stuff);
    }

    static void printTitle () {
        String title = """  
                                                 
                							Console
                    ██████╗  ██╗   ██╗ ██████╗  ██╗   ██╗ ██╗    ██╗  █████╗
                    ██╔══██╗ ██║   ██║ ██╔══██╗ ██║   ██║ ██║    ██║ ██╔══██╗
                    ██████╔╝ ██║   ██║ ██████╔╝ ██║   ██║ ██║ █╗ ██║ ███████║
                    ██╔══██╗ ██║   ██║ ██╔══██╗ ██║   ██║ ██║███╗██║ ██╔══██║
                    ██████╔╝ ╚██████╔╝ ██║  ██║ ╚██████╔╝ ╚███╔███╔╝ ██║  ██║
                    ╚═════╝   ╚═════╝  ╚═╝  ╚═╝  ╚═════╝   ╚══╝╚══╝  ╚═╝  ╚═╝
                    All rights reserved			               		    V 1.2
                    Dilshan M. Karunarathne 				 7 th March, 2022
                    www.karunarathne.me
                    github.io/dilshankarunarathne
                """;

        println (title, PrintColor.PURPLE) ;
    }

    static void printFooter () {
        String footer = """
                                                                            
                           +@@%.              +@          *@@@:               
                         -@%: =@@            @@.        :@#   @@               
                        +@      -@         -@@          @      *@               
                                 %@      +@@             @@     @:              
                           .:     @     @@*#@@          @@%@     @              
                         #@@@@@   @=   @     @@         @@ @     @  @@@@       
                        *@@@@@@@  @#  @:      @ @@@@.    @@@-    @ *@ =@#      
                        @@    .@  @%  @       @+   @    @*       @ +   @@       
                        @      @ .@%  @      .@+  *%   %@        @     @@       
                        @     .@ @@%  @      @@   @    @@       @@     @@       
                        @@@@ @@ :@@%  @@-  *@@@  .@     @#    =@@  @   @@       
                        *@ @ @.+@@@%   @@@@@@@   @@     @@@@@@@@.  +@:@@-      
                         %@@ .@@@ #%    @@@@.    @@      .@@@@#     @@@+        
                         :+       #%             @@                             
                        *@#@      #%             @@@                            
                        @  .  #@@##%              @@@@                          
                        @* .@@@-:@@%               ..                           
                         %@@:     =%                                            
                
                """ ;
        println (footer, PrintColor.RED);
    }
}