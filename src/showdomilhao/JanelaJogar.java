package showdomilhao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


public class JanelaJogar extends JPanel {
    JDialog janela;
    private Questionario jogo;
    private JButton btalt1;
    private JButton btalt2;
    private JButton btalt3;
    private JButton btalt4;
    private JButton btdessistir;
    private JButton btpular;
    private JButton lbusuario;
    private JLabel lbPergunta;
    private JPanel painelnorte;
    private JPanel painelcentro;
    private JPanel painelsul;
    private JPanel flowpainel;
    private JLabel imagem;
    public int pulos=3;
    public String logado;
    Perguntas x;
    public JanelaJogar(JDialog janela, Questionario jogo){
        this.jogo = jogo;
        this.janela=janela;
        this.setSize(744,434); 
	this.setLayout(new FlowLayout());
        int op = janela.getDefaultCloseOperation();
        janela.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        jogo.embaralhaQuestoes();
        logado = jogo.retornaLogin();
        
        jogo.perdeu();
        this.setLayout(new BorderLayout(2,2));
        
        painelnorte = new JPanel();
        painelcentro = new JPanel();
        painelsul = new JPanel();
        flowpainel = new JPanel();
        
        painelnorte.setLayout(new GridLayout(1,3));
        painelcentro.setLayout(new GridLayout(1,1));
        painelsul.setLayout(new GridLayout(2,4));
        
     
        
        lbPergunta = new JLabel();
        painelcentro.add(lbPergunta);

  
       
        btalt1 = new JButton();
        painelsul.add(btalt1);
        this.add(painelsul,BorderLayout.SOUTH);
        
        btalt2 = new JButton();
        painelsul.add(btalt2);
        this.add(painelsul,BorderLayout.SOUTH);
        
        btalt3 = new JButton();
        painelsul.add(btalt3);
        this.add(painelsul,BorderLayout.SOUTH);
        
        btalt4 = new JButton();
        painelsul.add(btalt4);
        this.add(painelsul,BorderLayout.SOUTH);
        
        lbusuario = new JButton("LOGADO COMO: [ "+logado+" ]");
        lbusuario.setForeground(Color.WHITE);
        lbusuario.setBackground(new Color(1, 173, 170));
        
        painelnorte.add(lbusuario);
        this.add(painelnorte,BorderLayout.NORTH);
        
        btdessistir = new JButton();
        painelnorte.add(btdessistir);
        this.add(painelnorte,BorderLayout.NORTH);
        
        btpular = new JButton();
        painelnorte.add(btpular);
        this.add(painelnorte,BorderLayout.NORTH);
      
        
        flowpainel.add(lbPergunta);
        this.add(flowpainel,BorderLayout.CENTER);
        
         imagem = new JLabel();
        Icon icone = new ImageIcon("background.jpg");
        this.imagem = new JLabel("",icone,SwingConstants.LEFT);
        flowpainel.add(imagem);
        this.add(flowpainel,BorderLayout.CENTER);
        
        flowpainel.setBackground(new Color(255, 255, 255));
     
        
        jogarGame();  
        
        // ALTERNATIVA 1
        btalt1.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                    verResp(1);   
                     
            }
			
	});
        
       
        //ALTERNATIVA 2
        btalt2.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                    verResp(2);
                   
            }
			
	});
        
        
       
         //ALTERNATIVA 3
        btalt3.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                    verResp(3);  
                    
            }
			
	});
        
       
        //ALTERNATIVA 4
        btalt4.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                    verResp(4);
                   
            }
			
	});
        // PULAR
        btpular.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                if(pulos>0){
                pulos = jogo.pularPergunt(pulos);
                 jogarGame();
                }
                else{
                    showMessageDialog(null, "Você nao tem mais pulos");
                }
            }
			
	});  
        
         btdessistir.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                    jogo.dessistir();
                    jogo.salvaBinario();
                    showMessageDialog(null, "Você dessistiu leva metade do dinheiro");
                    logado = null;
                    jogo.retornaLogin(logado);
                    janela.dispose();
                    
            }
			
	});
        
        lbusuario.addActionListener(new ActionListener(){  
            @Override
            public void actionPerformed(ActionEvent e) {
                String infos;
                    infos = jogo.returnInfo(logado);
                     showMessageDialog(null,infos);
                   
            }
			
	});
        
    }
     
        public void jogarGame(){
         this.x = jogo.Perguntar();
        
        
        lbPergunta.setText(x.getPergunta());
        lbPergunta.setFont(new Font("Arial", Font.BOLD, 20));
        lbPergunta.setForeground(Color.BLACK);
        
        btalt1.setText(x.alternativas.get(0));
        btalt1.setForeground(Color.WHITE);
        btalt1.setBackground(new Color(1, 173, 170));
        
        btalt2.setText(x.alternativas.get(1));
        btalt2.setForeground(Color.WHITE);
        btalt2.setBackground(new Color(1, 173, 170));
        
        btalt3.setText(x.alternativas.get(2));
        btalt3.setForeground(Color.WHITE);
        btalt3.setBackground(new Color(1, 173, 170));
        
        btalt4.setText(x.alternativas.get(3));
        btalt4.setForeground(Color.WHITE);
        btalt4.setBackground(new Color(1, 173, 170));
        
        btpular.setText("Pular Pergunta("+String.valueOf(pulos)+")");
        btpular.setForeground(Color.WHITE);
        btpular.setBackground(new Color(1, 173, 170));
        
        btdessistir.setText("Dessistir do jogo");
        btdessistir.setForeground(Color.WHITE);
        btdessistir.setBackground(new Color(1, 173, 170));
        
    }
        
        
    
    public void verResp(int resposta){        
        boolean resp = jogo.verResposta( x.getResposta(), resposta);
        boolean tpontos= jogo.testaPontos();

        
        if(resp == true){
            showMessageDialog(null, "Resposta Correta");
            jogo.salvaBinario();
            jogarGame();
        }
        else{
            showMessageDialog(null, "Resposta errada. A correta era a altertiva: " +x.getResposta()+ ", infelizmente você perdeu tudo");
            jogo.perdeu();
            jogo.salvaBinario();
            logado = null;
            jogo.retornaLogin(logado);
            janela.dispose();
        }
        if(tpontos == true){
            showMessageDialog(null, "Parabens, você ganhou R$:20.000");
            jogo.salvaBinario();
            logado = null;
            jogo.retornaLogin(logado);
            janela.dispose();
        }
        
    }
    

    
}
