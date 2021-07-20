package com.mycompany.iksoks;

import java.util.Scanner;

public class NewMainIksOks {
    
    static boolean gameOver=false;

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);       
        char[][] matrica = new char[3][3];          
        //              kreiram matricu 3x3
            praznjenjeMatrice(matrica);
        //              popunjavam matricu sa - znakom kako bi kontrolisao dali je polje prazno
            System.out.println("Igrac broj 1, molim vas unesite ime:");
            String p1=s.next();
            System.out.println("Igrac broj 2, molim vas unesite ime:");
            String p2=s.next();
        //              Ubacujem imena igraca
            boolean player=true;
        //        Kreiram boolean za player kako bi kad zavrsi petlju usao u else da bi p2 odigrao potez
        //        Kreiram boolean za gameOver kako bi ako je igra zavrsena prebacio gameOver u true pa onda ne bi usao u while petlju
            while(!gameOver){
                if(player) {
		System.out.println(p1 + " je sad na potezu");
		} else {
		System.out.println(p2 + " je sad na potezu");
		}
                
            char odigraniZnak='-';
            
            if(player){
                odigraniZnak='X';
            }else{
                odigraniZnak='O';
            }
            int red=0;
            int kolona=0;
        //  Stavio sam while(true) kako bi non stop vrteo 
        //  ako se unese polje koje je van matrice 
        //  ili koje je vec odigrano, 
        //  ako je nista od ovoga dolazi do break i prekida petlju
            while(true){
                System.out.println("Unesite red polja (0,1,2 su opcije)");
                red=s.nextInt();
                System.out.println("Unesite kolonu polja (0,1,2 su opcije)");
                kolona=s.nextInt();
                if(red<0 || kolona<0 || red>2 || kolona>2){
                    System.out.println("Ta polja su van okvira, ne mozete ih odabrati");      
                }
                else if(matrica[red][kolona]!='-'){
                    System.out.println("Neko je vec odigrao ovo polje, odaberite drugo polje");
                }else{
                    break;
                }
            }            
            matrica [red][kolona]=odigraniZnak;
            
            if(proveraJelNekoPobedio(matrica)=='X'){
                System.out.println(p1+" je pobedio/la");
                gameOver=true;
                crtanjeMatrice(matrica);
                daliZeliOpetDaIgra(matrica);
                praznjenjeMatrice(matrica);
                
            }else if(proveraJelNekoPobedio(matrica)=='O'){
                System.out.println(p2+" je pobedio/la");
                gameOver=true;
                crtanjeMatrice(matrica);
                daliZeliOpetDaIgra(matrica);
                praznjenjeMatrice(matrica);
            
            }else if(matricaJePuna(matrica)){
                System.out.println("Igra je gotova, rezultat je nereseno");
                gameOver=true;
                crtanjeMatrice(matrica);
                daliZeliOpetDaIgra(matrica);
                praznjenjeMatrice(matrica);
                
            }else{
                player=!player;
                crtanjeMatrice(matrica);
            }

            }
            
//            POMOCNE METODE
    }
    public static void crtanjeMatrice(char[][] matrica){
        for(int i = 0; i<3;i++){
        System.out.println(" - - -");
        for(int j = 0; j<3;j++){
            if(j<2){
            System.out.print("|"+matrica[i][j]);
            }
            else{
            System.out.println("|"+matrica[i][j]+"|");
            }
        }
        System.out.println(" - - -");
        }
    }
    public static char proveraJelNekoPobedio(char[][] matrica){
	for(int i = 0; i < 3; i++) {
            if(matrica[i][0] == matrica[i][1] && matrica[i][1] == matrica[i][2] && matrica[i][0] != '-') {
                return matrica[i][0];
            }
        }
        for(int j = 0; j < 3; j++) {
            if(matrica[0][j] == matrica[1][j] && matrica[1][j] == matrica[2][j] && matrica[0][j] != '-') {
                return matrica[0][j];
            }
        }
        if(matrica[0][0] == matrica[1][1] && matrica[1][1] == matrica[2][2] && matrica[0][0] != '-') {
                return matrica[0][0];
        }
        if(matrica[2][0] == matrica[1][1] && matrica[1][1] ==  matrica[0][2] && matrica[2][0] != '-') {
                return matrica[2][0];
            }
        return ' ';
    }
    
    public static boolean matricaJePuna(char[][] matrica) {
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                    if(matrica[i][j] == '-') {
                            return false;
                    }
            }
        }
    return true;
    }
    
    public static void daliZeliOpetDaIgra(char[][] matrica){
        System.out.println("Dali zelite opet da igrate:Da/Ne");
        Scanner s = new Scanner(System.in); 
        String odgovor=s.next();
            if(odgovor.equalsIgnoreCase("Da")){
                gameOver = false;
            }
    }
    
    public static void praznjenjeMatrice(char[][] matrica){
          for(int i = 0; i<3; i++){
                for(int j = 0; j<3; j++){
                matrica [i][j]= '-';
                }
            }
    }

}
    


