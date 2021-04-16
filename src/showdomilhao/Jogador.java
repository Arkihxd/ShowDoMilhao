package showdomilhao;

import java.io.Serializable;

        
public class Jogador implements Serializable, Comparable<Jogador> {
    private String usuario;
    private String email;
    private int pontuacao;
    
    Jogador(String usuario, String email){
        this.usuario=usuario;
        this.email=email;
        this.pontuacao=0;
    }


   
    public String getUsuario() {
        return usuario;
    }

   
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

   
    public int getPontuacao() {
        return pontuacao;
    }

    
    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public void acerto(){
        this.pontuacao=this.pontuacao+1000;
    }
    
    public void dessistir(){
        this.pontuacao=this.pontuacao/2;
    }
    
     public void perdeu(){
        this.pontuacao=0;
    }
    
   
    public int compareTo(Jogador auxJogador){       
        if(this.pontuacao < auxJogador.getPontuacao()){
            return 1;
        }
        else if(this.pontuacao > auxJogador.getPontuacao()){
            return -1;
        }
        else{
            return 0;
        }
    }
    
    public String toString(){
        return "Nome:"+usuario+" Pontuaçao:"+pontuacao;
    }
    
    
}
