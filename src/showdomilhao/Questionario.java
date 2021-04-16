package showdomilhao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

public class Questionario {
     private ArrayList<Perguntas> questoes = new ArrayList<Perguntas>();
     private ArrayList<Jogador> jogadores = new ArrayList<Jogador>();
     String logado;
     Perguntas x;
     int npergunta = 0;
     
     
     public Perguntas Perguntar(){
         Perguntas x = null;
         
             x=questoes.get(npergunta);
             npergunta++;
            return x;
     }
     
     public void embaralhaQuestoes(){
         Collections.shuffle(questoes);
     }
     
     
     public boolean verResposta(int x, int resposta){
        if(x == resposta){
            for(int i=0; i<jogadores.size(); i++){
                if(jogadores.get(i).getUsuario().equals(logado)){
                jogadores.get(i).acerto();
                }
            }
            return true;
        }
        else{
            
            return false;
        } 
    }
     
     public boolean testaPontos(){
          int tpontos;
           for(int i=0; i<jogadores.size(); i++){
              if(jogadores.get(i).getUsuario().equals(logado)){
               tpontos = jogadores.get(i).getPontuacao();
               if(tpontos == 20000){
                   return true;
               }
               else{
                   return false;
               }
           }
         }
         return false;
     }
           
    
     
     public boolean fazerLogin(String usuario, String email){
         for(int i=0; i<jogadores.size(); i++){
             if( (jogadores.get(i).getUsuario().equals(usuario)) && (jogadores.get(i).getEmail().equals(email))){
                 logado = jogadores.get(i).getUsuario();
               return true;
          }     
        }
            return false;
     }
     
     public boolean verificarCadastro(String usuario, String email){
         for(int i=0; i<jogadores.size(); i++){
             if( jogadores.get(i).getUsuario().equals(usuario) ){
               return true;
          }     
        }
            return false;
     }
     
     public void cadastro(String usuario, String email){
         Jogador x = new Jogador(usuario, email);
         jogadores.add(x);
         
     }
     
     public void rankear(){
         Collections.sort(jogadores);
     }
    
     public int pularPergunt(int pulos){
         if(pulos >0){
             pulos --;
             return pulos;
         }
         else{
           return -1;
         }
     }
     
     public void retornaLogin(String retorno) {
        this.logado = retorno;
    }
     
     public void recebePerguntas(String arq){
         questoes.clear();
         try{
             Scanner scan = new Scanner(new File(arq));
             while(scan.hasNextLine()){
                 String str = scan.nextLine();
                 String[] tokens = str.split(";");
                 Perguntas x = new Perguntas (tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], Integer.valueOf(tokens[5]), tokens[6]);
                 questoes.add(x);
             }
             scan.close();
         }catch(FileNotFoundException e){
             System.out.println(e.getMessage());
         }
     }
     
     public void salvaBinario(){
         try{
            FileOutputStream fos = new FileOutputStream(new File("jogadores.bin"));
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            
            oos.writeObject(jogadores);
            
            oos.close();
            fos.close();
         }catch(IOException e){
             e.printStackTrace();
         }
     }
     
     public void carregaBinario(){
         jogadores.clear();
         try{
             FileInputStream fis = new FileInputStream(new File("jogadores.bin"));
             ObjectInputStream ois = new ObjectInputStream(fis);
             
             jogadores = (ArrayList<Jogador>)ois.readObject();
             
             ois.close();
             fis.close();
         }catch(IOException e){
             e.printStackTrace();
         }catch (ClassNotFoundException e) {
             e.printStackTrace();
         }
     }    
     
        public Object[] pegaLista(){
		return this.jogadores.toArray();
	}
        
        public String retornaLogin(){
            return logado;
        }
        
        public String returnInfo(String info){
        int pontos;
        String email;
        String infos;
            for(int i=0; i<jogadores.size(); i++){
             if(jogadores.get(i).getUsuario().equals(info) ){
                 pontos = jogadores.get(i).getPontuacao();
                 email = jogadores.get(i).getEmail();
                 infos = "Email: "+email+" Pontuação: "+pontos;
                 return infos;
                 }
              }
                  return null;
         }

        public void dessistir(){
            for(int i=0; i<jogadores.size(); i++){
                if(jogadores.get(i).getUsuario().equals(logado)){
                jogadores.get(i).dessistir();
               }
        } 
    }
        
        public void perdeu(){
          for(int i=0; i<jogadores.size(); i++){
              if(jogadores.get(i).getUsuario().equals(logado)){
               jogadores.get(i).perdeu();
               }
        } 
      }
        
}
