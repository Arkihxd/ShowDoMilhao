package showdomilhao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import static javax.swing.JOptionPane.showMessageDialog;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class JanelaCadastro extends JPanel{
    
 private JLabel lbUsuario;    
 private JTextField tfUsuario;       
 private JLabel lbEmail;
 private JTextField tfEmail; 
 private JButton btOk;
 JDialog janela1;
 public JanelaCadastro(JDialog janela1,Questionario jogo ){
     
        this.janela1=janela1;
        this.setSize(260,182); 
	this.setLayout(new FlowLayout());
        
        this.lbUsuario = new JLabel("Usuario:");  
	this.add(this.lbUsuario);              
	this.tfUsuario = new JTextField("",20);  
	this.add(tfUsuario);
        lbUsuario.setForeground(new Color(1, 173, 170));
        
        this.lbEmail = new JLabel("Email:");  
	this.add(this.lbEmail);              
	this.tfEmail = new JTextField("",20);  
	this.add(tfEmail);
        lbEmail.setForeground(new Color(1, 173, 170));
        
        this.btOk = new JButton("Ok"); 
        btOk.setBackground(new Color(1, 173, 170));
        btOk.setForeground(new Color(255, 255, 255));
	this.btOk.addActionListener(new ActionListener(){ 

	@Override
	public void actionPerformed(ActionEvent e) {            
                    
                boolean verificarCadastro;
                if(tfUsuario.getText().isEmpty()){
                     showMessageDialog(null, "Digite um Usuario valido...");
                }
                else{
                verificarCadastro=jogo.verificarCadastro(tfUsuario.getText(),tfEmail.getText());
                if(verificarCadastro==true){    
                    showMessageDialog(null, "Usuario ja existe");
                    limpar();
                }
                else{
                    showMessageDialog(null, "Cadastrado com sucesso");
                    jogo.cadastro(tfUsuario.getText(),tfEmail.getText());
                    jogo.salvaBinario();
                    janela1.dispose();
                }
                }
		
	}
			
	});
	this.add(btOk);
        
        
 }
 
    void limpar(){
        tfUsuario.setText("");
        tfEmail.setText("");
    }

}