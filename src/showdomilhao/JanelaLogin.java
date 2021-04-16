
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


public class JanelaLogin extends JPanel {
    private JLabel lbUsuario;    
    private JTextField tfUsuario;       
    private JLabel lbEmail;
    private JTextField tfEmail; 
    private JButton btOk;
    private JPanel flowpainel;
    JDialog janela1;
 public JanelaLogin(JDialog janela1,Questionario jogo ){
     
        this.janela1=janela1;
        this.setSize(260,182); 
	this.setLayout(new FlowLayout());
        flowpainel = new JPanel();
        
        this.lbUsuario = new JLabel("Usuario:");  
	this.add(this.lbUsuario);  
        lbUsuario.setBackground(new Color(1, 173, 170));
	this.tfUsuario = new JTextField("",20);  
        lbUsuario.setForeground(new Color(1, 173, 170));
	this.add(tfUsuario);
        
        this.lbEmail = new JLabel("Email:");  
	this.add(this.lbEmail);             
        lbEmail.setBackground(new Color(1, 173, 170));
	this.tfEmail = new JTextField("",20);  
        lbEmail.setForeground(new Color(1, 173, 170));
	this.add(tfEmail);
        
        this.btOk = new JButton("Ok"); 
        btOk.setBackground(new Color(1, 173, 170));
        btOk.setForeground(new Color(255, 255, 255));
	this.btOk.addActionListener(new ActionListener(){ 

	@Override
	public void actionPerformed(ActionEvent e) {
                boolean login;
                if(tfUsuario.getText().isEmpty()){
                    showMessageDialog(null, "Digite um Usuario valido...");
                }
                else{
		login = jogo.fazerLogin(tfUsuario.getText(),tfEmail.getText());
                
                if(login == true){
                     showMessageDialog(null, "Logado com sucesso");
                     janela1.dispose();
                     
                }
                else{
                    showMessageDialog(null, "Usuario ou email incorreto");
                    limpar();
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
