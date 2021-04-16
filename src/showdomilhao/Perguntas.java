package showdomilhao;

import java.util.ArrayList;


public class Perguntas {
    private String pergunta;
    ArrayList<String> alternativas = new ArrayList<String>();
    private int resposta;
    private String dificuldade;

    
    Perguntas(String pergunta, String op1, String op2, String op3, String op4, int resposta ,String dificuldade){
        this.pergunta=pergunta;
        alternativas.add(op1);
        alternativas.add(op2);
        alternativas.add(op3);
        alternativas.add(op4);
        this.resposta=resposta;
        this.dificuldade=dificuldade;  
           
    }

    
    public String getPergunta() {
        return pergunta;
    }

   
    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

   
    public ArrayList<String> getAlternativas() {
        return alternativas;
    }

   
    public void setAlternativas(ArrayList<String> alternativas) {
        this.alternativas = alternativas;
    }

   
    public int getResposta() {
        return resposta;
    }

    
    public void setResposta(int resposta) {
        this.resposta = resposta;
    }

   
    public String getDificuldade() {
        return dificuldade;
    }

    
    public void setDificuldade(String dificuldade) {
        this.dificuldade = dificuldade;
    }

    
    public String toString(){
        return ""+pergunta+"\n1-"+alternativas.get(0)+ "\n2-"+alternativas.get(1)+ "\n3-"+alternativas.get(2)+ "\n4-"+alternativas.get(3)+ "\nResp: "+resposta;
    }
    
    
    

}
