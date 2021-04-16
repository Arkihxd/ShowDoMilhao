/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package showdomilhao;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;


/**
 *
 * @author Aluno
 */
public class JanelaMenu extends JFrame{
    
    private BorderLayout layout;
    private JButton btCadastrar;
    private JButton btRanking;
    private JButton btJogar;
    private Questionario jogo = new Questionario(); 
    private JLabel imagem;
    private JPanel painelnorte;
    private JPanel painelcentro;
    private JPanel painelsul;
    
    
    public JanelaMenu(){
        super("SHOW DO MILHÃO");
        jogo.carregaBinario();
        jogo.recebePerguntas("question.txt");
        jogo.rankear();
        
        this.setSize(744,434); // windows
        this.setSize(744,405); // linux
	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
        //this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		
        this.setLayout(new BorderLayout(2,2));
        
        painelnorte = new JPanel();
        painelcentro = new JPanel();
        painelsul = new JPanel();
        
        painelnorte.setLayout(new GridLayout(1,3));
        painelcentro.setLayout(new GridLayout(1,1));
        painelsul.setLayout(new GridLayout(1,2));
        
        JButton btCadastrar = new JButton("Cadastrar");
        painelnorte.add(btCadastrar);
        this.add(painelnorte,BorderLayout.NORTH);
        btCadastrar.setForeground(Color.WHITE);
        btCadastrar.setBackground(new Color(1, 173, 170));
        btCadastrar.setFont(new Font("Arial", Font.BOLD, 16));
 
        JButton btJogar = new JButton("Jogar");
        painelnorte.add(btJogar);
        this.add(painelnorte,BorderLayout.NORTH);
        btJogar.setForeground(Color.WHITE);
        btJogar.setBackground(new Color(1, 173, 170));
        btJogar.setFont(new Font("Arial", Font.BOLD, 16));

        JButton btRanking = new JButton("Ranking");
        painelnorte.add(btRanking);
        this.add(painelnorte,BorderLayout.NORTH);
        btRanking.setForeground(Color.WHITE);
        btRanking.setBackground(new Color(1, 173, 170));
        btRanking.setFont(new Font("Arial", Font.BOLD, 16));
        
        
        imagem = new JLabel();
        Icon icone = new ImageIcon("background.jpg");
        this.imagem = new JLabel("",icone,SwingConstants.LEFT);
        painelcentro.add(imagem);
        this.add(painelcentro,BorderLayout.CENTER);

	btCadastrar.addActionListener(new ActionListener(){  
	@Override
	public void actionPerformed(ActionEvent e) {
             JDialog janela = new JDialog(JanelaMenu.this, "Cadastro", true);
             janela.setContentPane(new JanelaCadastro(janela, jogo));
             janela.setSize(janela.getContentPane().size());
             janela.setVisible(true);
                     
           }	
	});

       
	btJogar.addActionListener(new ActionListener(){  
	@Override
        public void actionPerformed(ActionEvent e) {   
            JDialog janela2 = new JDialog(JanelaMenu.this, "Login", true);
            janela2.setContentPane(new JanelaLogin(janela2, jogo));
            janela2.setSize(janela2.getContentPane().size());
            janela2.setVisible(true);   
            
            String log;
            log = jogo.retornaLogin();
            if(log == null){
             
            }
            else{
            JDialog janela = new JDialog(JanelaMenu.this, "Jogar", true);
            janela.setContentPane(new JanelaJogar(janela, jogo));
            janela.setSize(janela.getContentPane().size());
            janela.setVisible(true);

             }                           
            }
			
	});
	
        
        
        
	btRanking.addActionListener(new ActionListener(){  
	@Override
	public void actionPerformed(ActionEvent e) {
              JDialog janela = new JDialog(JanelaMenu.this, "Ranking", true);
              janela.setContentPane(new JanelaRanking(janela, jogo));
              janela.setSize(janela.getContentPane().size());
              janela.setVisible(true);
				
	}
			
	});
        
       
			
	

        
      
    }
    
    
}
