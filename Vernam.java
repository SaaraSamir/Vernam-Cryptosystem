/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vernam;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Scanner;

/**
 *
 * @author alqods
 */
public class Vernam {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
       /* System.out.println(encrypt("welcometoworld","cryptographyan"));
         System.out.println(decrypt(encrypt("welcometoworld","cryptographyan"),"cryptographyan"));
        */
          File encryption_file = new File("encryptText.txt");        
            encryptfile(encryption_file);

        File decryption_file = new File("encrypt.txt");       
            decryptfile(decryption_file);

    }
 static String encrypt(String plain,String key){
     String plainbit=new BigInteger(plain.getBytes()).toString(2);
     String keybit=new BigInteger(plain.getBytes()).toString(2);
     String c="";
     String ctext ;
     for(int i=0;i<plainbit.length();i++){
         if(plainbit.charAt(i)==keybit.charAt(i)){
             c+="0";
         }else{
             c+="1";
         }
     }
     ctext= new String(new BigInteger(c,2).toByteArray());     
     return ctext;
 }   
 static String decrypt(String cypher,String key){
     String plainbit=new BigInteger(cypher.getBytes()).toString(2);
     String keybit=new BigInteger(cypher.getBytes()).toString(2);
     String p="";
     String ptext ;
     for(int i=0;i<plainbit.length();i++){
         if(plainbit.charAt(i)==keybit.charAt(i)){
             p+='0';
         }else{
             p+='1';
         }
     }
     ptext= new String(new BigInteger(p,2).toByteArray()); 
     
     return ptext;
 }   
 static void encryptfile(File plainTextFile) throws IOException {

        Scanner scanner = new Scanner(plainTextFile);

        File output = new File("encrypt.txt");
        PrintWriter pw = new PrintWriter(output);

        while (scanner.hasNext()) {
            pw.println(encrypt(scanner.nextLine(),"cryptographyan"));
        }

        pw.flush();
        pw.close();
    }

    static void decryptfile(File cipherTextFile) throws IOException {

        Scanner input = new Scanner(cipherTextFile);

        File output = new File("decrypt.txt");
        PrintWriter pw = new PrintWriter(output);

        while (input.hasNext()) {
            pw.println(decrypt(input.nextLine(),"cryptographyan"));
        }

        pw.flush();
        pw.close();
    }

}
