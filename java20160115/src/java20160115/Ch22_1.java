package java20160115;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.List;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ch22_1 extends Frame implements ActionListener,TextListener,ItemListener{

	static Ch22_1 frm=new Ch22_1();
//	static List lst=new List();
	static TextField txf1=new TextField("");
	static TextField txf2=new TextField("");
	static Button btn1=new Button("Get IP");
	static Button btn2=new Button("Get hostname");

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		frm.setLayout(null);
		frm.setTitle("Inet Address 練習");
		frm.setSize(300,400);
//		frm.setBackground(Color.yellow);
		txf1.setBounds(50,35,150,25);
//		lst.setBounds(20,70,100,65);
		btn1.setBounds(50,80,60,25);
		btn2.setBounds(128,80,60,25);      
		txf2.setBounds(50,130,150,25);
		
//		lst.addItemListener(frm);
		txf1.addTextListener(frm);
		txf2.addTextListener(frm);
		btn1.addActionListener(frm);
		btn2.addActionListener(frm);
		
		txf1.setText("0.0.0.0");
		
//		frm.add(lst);
		frm.add(txf1);
		frm.add(txf2);
		frm.add(btn1);
		frm.add(btn2);    
		frm.setVisible(true);

	}


	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void textValueChanged(TextEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Button btn=(Button) e.getSource();
		InetAddress addr;
		if(btn==btn1)
		{
			if(!(txf2.getText().equals("")))
			{
				try{
					addr = InetAddress.getByName(txf2.getText());
					String ip1 = addr.getHostAddress();
					txf1.setText(ip1);
				}catch(UnknownHostException e1){
					System.out.println("error");
				}
//				lst.add(txf.getText());
//				txf.setText("");
			}
		}else if(btn==btn2)
		{         
//			if(lst.getItemCount()>0)
//			{
//				String item=lst.getSelectedItem();
//				if(item!=null)
//					lst.remove(item);
//			}
		}

	}

}
