package showdomilhao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;


public class JanelaRanking extends JPanel {
    
    private JList ltRanking = new JList();
    private JButton btFechar;
    JDialog janela1;
    private Questionario jogo;
    
    public JanelaRanking(JDialog janela1,Questionario jogo){
        
        this.jogo = jogo;
        this.janela1=janela1;
        this.setSize(230,260);
	this.setLayout(new FlowLayout());
        jogo.rankear();
        
        DefaultListModel model = new DefaultListModel();
	for(Object o:jogo.pegaLista()){
		model.addElement(o);
	}
	ltRanking.setModel(model);
        
        ltRanking.setVisibleRowCount(10);
        ltRanking.setForeground(new Color(255, 255, 255));
        ltRanking.setBackground(new Color(1, 173, 170));
        ltRanking.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.add(new JScrollPane(ltRanking));
        
        this.btFechar = new JButton("Fechar"); 
        btFechar.setBackground(new Color(1, 173, 170));
        btFechar.setForeground(new Color(255, 255, 255));
	this.btFechar.addActionListener(new ActionListener(){ 

	@Override
	public void actionPerformed(ActionEvent e) {
                janela1.dispose();
	}
			
	});
	this.add(btFechar);
   
        
        
    }
    
}
