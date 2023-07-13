import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

	public class Unidade2 extends JFrame implements ActionListener{
	
	
	private JLabel lblPrecoLitro,lblQuantidadeLitro,lblResultado;
	private JTextField txtPrecoLitro,txtQuantidadeLitro;
	private JButton btnResultado,btnLimpar,btnFechar;
	private GridBagConstraints restricoes = new GridBagConstraints();
	private JPanel pnlDados,pnlBotoes,pnlResultado,pnlUnidade2;
	
	public Unidade2()
	{
		this.setTitle("Calculadora Combustível");
		this.setLocation(600,350);
		this.setSize(700,300);
		this.setResizable(false);
		
		Font f = new Font("SansSerif", Font.PLAIN,20);
		
		lblPrecoLitro=new JLabel("Preço do litro da gasolina: R$",JLabel.RIGHT);
		lblPrecoLitro.setFont(f);
		txtPrecoLitro=new JTextField(20);
		txtPrecoLitro.setFont(f);
		txtPrecoLitro.setToolTipText("Digíte aqui o valor do litro da gasolina");
		
		lblQuantidadeLitro=new JLabel("Quantidade de litros de gasolina",JLabel.RIGHT);
		lblQuantidadeLitro.setFont(f);
		txtQuantidadeLitro=new JTextField(20);
		txtQuantidadeLitro.setFont(f);
		txtQuantidadeLitro.setToolTipText("Digíte aqui a quantidade de gasolina em litros");
		
		btnResultado=new JButton("Resultado");
		btnResultado.setFont(f);
		btnResultado.setToolTipText("Clique aqui para calcular o valor a ser pago");
		btnResultado.setMnemonic('D');
		btnResultado.addActionListener(this);
		
		btnLimpar=new JButton("Limpar");
		btnLimpar.setFont(f);
		btnLimpar.setToolTipText("Clique aqui para limpar os dados informados");
		btnLimpar.setMnemonic('L');
		btnLimpar.addActionListener(this);
		
		btnFechar=new JButton("Fechar");
		btnFechar.setFont(f);
		btnFechar.setToolTipText("Clique aqui para fechar o software");
		btnFechar.setMnemonic('F');
		btnFechar.addActionListener(this);
		
		lblResultado=new JLabel("Resultado:",JLabel.RIGHT);
		lblResultado.setFont(f);
		
		restricoes.fill=GridBagConstraints.BOTH;
		restricoes.insets=new Insets(8,8,8,8);
		
		pnlDados = new JPanel(new GridBagLayout());
		addGridBag(0,0,lblPrecoLitro,pnlDados);
		addGridBag(1,0,txtPrecoLitro,pnlDados);
		addGridBag(0,1,lblQuantidadeLitro,pnlDados);
		addGridBag(1,1,txtQuantidadeLitro,pnlDados);
		
		pnlBotoes = new JPanel(new GridBagLayout());
		addGridBag(0,0,btnResultado,pnlBotoes);
		addGridBag(1,0,btnLimpar,pnlBotoes);
		addGridBag(2,0,btnFechar,pnlBotoes);
		
		pnlResultado = new JPanel(new GridBagLayout());
		addGridBag(0,0,lblResultado,pnlResultado);
		
		pnlUnidade2 = new JPanel(new GridBagLayout());
		addGridBag(0,0,pnlDados,pnlUnidade2);
		addGridBag(0,1,pnlBotoes,pnlUnidade2);
		addGridBag(0,2,pnlResultado,pnlUnidade2);
		
		Container P=getContentPane();
		P.add(pnlUnidade2);
		
	}
	
	public void addGridBag(final int x,final int y,final Component obj,final JPanel pnl)
	{
		restricoes.gridx=x;
		restricoes.gridy=y;
		pnl.add(obj, restricoes);
	
	}
	
	
	public void actionPerformed(ActionEvent evento)
	{
		Object origem=evento.getSource();
		if (origem == btnResultado)
		{
			float precoLitro,quantidadeLitro,resultado;
			try
			{
				precoLitro = Float.parseFloat(txtPrecoLitro.getText());
				try
				{
					quantidadeLitro = Float.parseFloat(txtQuantidadeLitro.getText());
					resultado = precoLitro * quantidadeLitro;
					lblResultado.setText("Resultado " + resultado);
				}catch (Exception erro)
				{
					JOptionPane.showMessageDialog(null, "A quantidade de litros é inválida",
					"Quantidade de litros" ,JOptionPane.ERROR_MESSAGE);
					txtQuantidadeLitro.requestFocus();
					txtQuantidadeLitro.selectAll();
				}
			}catch (Exception erro)
			{
				JOptionPane.showMessageDialog(null, "O valor do litro informado é inválido",
				"Preço do litro" ,JOptionPane.ERROR_MESSAGE);
				txtPrecoLitro.requestFocus();
				txtPrecoLitro.selectAll();
			}
		}else if (origem == btnLimpar)
		{
			txtPrecoLitro.setText("");
    		txtQuantidadeLitro.setText("");
    		lblResultado.setText("Resultado:");
    		txtPrecoLitro.requestFocus();
			
		}else if (origem == btnFechar)
		{
			System.exit(0);
		}
	}

	public static void main(String[] args) {
		Unidade2 unidade = new Unidade2();
		unidade.setVisible(true);

	}
}
	