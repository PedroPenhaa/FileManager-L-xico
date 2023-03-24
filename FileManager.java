package analisador;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Douglas
 */
public class FileManager {
    
	ArrayList<String> test;
	
	final static String identif = "[a-zA-Z]([a-zA-Z0-9])*";
	final static String numero = "[0-9]+";
	final static String espaco = "[\t]+";
	final static String novalinha = "[\n]";
		
	public FileManager() {
		test = this.stringReader("./arq/avaliacao.simples");
		for(String line : test) {
			String split[] = line.split(" ");
			compara(split);
		}
	}
		
	public static void main(String[] args){
		FileManager f = new FileManager();
	}
	
	public void compara(String split[]) {
		for(String sp : split) {
						
			if(sp.equals("programa")) {
			 System.out.printf(sp + " - palavra_reservada: T_PROGRAMA\n", sp);
			}
			else if(sp.equals("inicio")) {
				 System.out.printf(sp + " - palavra_reservada: T_INICIO\n", sp);
			}
			else if(sp.equals("fimprograma")) {
				 System.out.printf(sp + " - palavra_reservada: T_FIM\n", sp);
			}
			
						
			else if(sp.equals("se")) {
				 System.out.printf(sp + " - palavra_reservada: T_SE\n", sp);
			}
			else if(sp.equals("entao")) {
				 System.out.printf(sp + " - palavra_reservada: T_ENTAO\n", sp);
			}
			else if(sp.equals("senao")) {
				 System.out.printf(sp + " - palavra_reservada: T_SENAO\n", sp);
			}
			else if(sp.equals("fimse")) {
				 System.out.printf(sp + " - palavra_reservada: T_FIMSE\n", sp);
			}
			
						
			else if(sp.equals("enquanto")) {
				 System.out.printf(sp + " - palavra_reservada: T_ENQTO\n", sp);
			}
			else if(sp.equals("fimenquanto")) {
				 System.out.printf(sp + " - palavra_reservada: T_FIMENQTO\n", sp);
			}			
			else if(sp.equals("leia")) {
				 System.out.printf(sp + " - palavra_reservada: T_LEIA\n");
			}
			else if(sp.equals("escreva")) {
				 System.out.printf(sp + " - palavra_reservada: T_ESCREVA\n", sp);
			}
			else if(sp.equals("faca")) {
				 System.out.printf(sp + " - palavra_reservada: T_FACA\n", sp);
			}
						
			
			else if(sp.equals("+")) {
				 System.out.printf(sp + " - operador_aritimético: T_MAIS\n", sp);
			}
			else if(sp.equals("-")) {
				 System.out.printf(sp + " - operador_aritimético: T_MENOS\n", sp);
			}
			else if(sp.equals("*")) {
				 System.out.printf(sp + " - operador_aritimético: T_VEZES\n", sp);
			}
			else if(sp.equals("/")) {
				 System.out.printf(sp + " - operador_aritimético: T_DIV\n", sp);
			}
			
				
			else if(sp.equals(">")) {
				 System.out.printf(sp + " - operador_aritimético: T_MAIOR\n", sp);
			}
			else if(sp.equals("<")) {
				 System.out.printf(sp + " - operador_aritimético: T_MENOR\n", sp);
			}
			else if(sp.equals("=")) {
				 System.out.printf(sp + " - operador_aritimético: T_IGUAL\n", sp);
			}
			
			
			
			else if(sp.equals("e")) {
				 System.out.printf(sp + " - palavra_reservada: T_E\n", sp);
			}
			else if(sp.equals("ou")) {
				 System.out.printf(sp + " - palavra_reservada: T_OU\n", sp);
			}
			else if(sp.equals("nao")) {
				 System.out.printf(sp + " - palavra_reservada: T_NAO\n", sp);
			}
			
			
			else if(sp.equals("<-")) {
				 System.out.printf(sp + " - palavra_reservada: T_ATRIB\n", sp);
			}
			else if(sp.equals("(")) {
				 System.out.printf(sp + " - palavra_reservada: T_ABRE\n", sp);
			}
			else if(sp.equals(")")) {
				 System.out.printf(sp + " - palavra_reservada: T_FECHA\n", sp);
			}
			
			
			else if(sp.equals("inteiro")) {
				 System.out.printf(sp + " - palavra_reservada: T_INTEIRO\n", sp);
			}
			else if(sp.equals("logico")) {
				 System.out.printf(sp + " - palavra_reservada: T_LOGICO\n", sp);
			}
			else if(sp.equals("V")) {
				 System.out.printf(sp + " -  palavra_reservada: T_V\n", sp);
			}
			else if(sp.equals("F")) {
				 System.out.printf(sp + " -  palavra_reservada: T_F\n", sp);
			}
			
			
			else if(sp.matches(espaco)) {
			}
			else if(sp.matches(novalinha)) {
			}
			else if(sp.matches(identif)) {
				 System.out.printf(sp + " -  palavra_reservada: T_IDENTIF\n", sp);
			}
			else if(sp.matches(numero)) {
				 System.out.printf(sp + " -  palavra_reservada: T_NUMERO\n", sp);
			}
			
			
			
			else if(sp.equals("//")) {
				 System.out.printf("Comentário Linha");
			}
			else if(sp.equals("/*")) {
				 System.out.printf("Inicio comentário bloco");
			}
			else if(sp.equals("*/")) {
				 System.out.printf("Fim comentário bloco");
			}
			
			else if(sp.equals(".")) {
				 System.out.printf("ERRO LÉXICO");
			}
			
	
			
		}
	}
	
	
	
	/*method to read the archive lines - returns arraylist<string> and the argument is the archive path*/
    public static ArrayList<String> stringReader (String path){ 
    	/*creating variable*/
        BufferedReader buffRead = null;
        
        /*try to read the archive*/
        try {
        	/*initializing the buffer*/
            buffRead = new BufferedReader(new FileReader(path));
            
            /*creating the arraylist of txt lines*/
            ArrayList<String> text = new ArrayList<>();
            
            /*reading the first line of the txt and storing it in variable line*/
            String line = buffRead.readLine();
            
            /*while still have lines not null in the txt*/
            while (line != null) {
            	/*add the line to the arraylist*/
                text.add(line);
                
                /*read another line*/
                line = buffRead.readLine();
            }
            /*close the stream and release all the system resources associated with the stream operations.*/
            buffRead.close();
            
            /*returns the arraylist*/
            return text;
        } catch (FileNotFoundException ex) { /*exception if the archive was not found in the path given*/
        	/*used to log messages for a specific system or application component*/
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) { /*java exception that occurs when an IO (input/output) operation fails.*/
        	/*used to log messages for a specific system or application component*/
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } finally { /*execute code even with exception*/
            try {
            	/*try closing the stream*/
                buffRead.close();
            } catch (IOException ex) {/*java exception that occurs when an IO (input/output) operation fails.*/
            	/*used to log messages for a specific system or application component*/
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }   
    
    /*NOT GONNA BE USED*/
    public static void writer (String path, String text){ 
        BufferedWriter buffWrite = null; 
        try {
            buffWrite = new BufferedWriter(new FileWriter(path));
            buffWrite.append(text);
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffWrite.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    } 
    
    /*NOT GONNA BE USED*/
    public static void writerAppend (String path, String text){ 
        BufferedWriter buffWrite = null; 
        try {
            buffWrite = new BufferedWriter(new FileWriter(path, true));
            buffWrite.append(text);
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                buffWrite.close();
            } catch (IOException ex) {
                Logger.getLogger(FileManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }    
    
}
