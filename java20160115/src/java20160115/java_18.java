package java20160115;

import java.awt.Color;
import java.awt.FileDialog;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class java_18 extends Frame implements TextListener, ActionListener, ItemListener {
	static java_18 frm = new java_18();
	static TextArea txa;
	static String fname_r = "";

	static MenuBar mb = new MenuBar();
	static Menu menu1 = new Menu("File");
	static Menu menu2 = new Menu("Font");
	static MenuItem mi1_1 = new MenuItem("Open file");
	static MenuItem mi1_2 = new MenuItem("Save file");
	static MenuItem mi1_3 = new MenuItem("Save as..");
	static MenuItem mi1_4 = new MenuItem("Exit");
	static MenuItem mi2_1 = new MenuItem("PLAIN");
	static MenuItem mi2_2 = new MenuItem("BOLD");
	static MenuItem mi2_3 = new MenuItem("ITALIC");
	static MenuItem mi2_4 = new MenuItem("B + I");

	static FileDialog open_fdlg = new FileDialog(frm, "Open");
	static FileDialog save_fdlg = new FileDialog(frm, "Save", FileDialog.SAVE);

	char data[] = new char[128];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mb.add(menu1);
		mb.add(menu2);
		menu1.add(mi1_1);
		menu1.add(mi1_2);
		menu1.add(mi1_3);
		menu1.add(mi1_4);
		menu2.add(mi2_1);
		menu2.add(mi2_2);
		menu2.add(mi2_3);
		menu2.add(mi2_4);
		frm.setMenuBar(mb);

		txa = new TextArea("", 20, 46, TextArea.SCROLLBARS_NONE);
		// txa.setBounds(10,30,180,85);
		frm.setSize(400, 400);
		frm.setTitle("簡易記事本");
		frm.setLayout(new FlowLayout(FlowLayout.CENTER));
		txa.setBackground(Color.LIGHT_GRAY);

		txa.addTextListener(frm);
		mi1_1.addActionListener(frm);
		mi1_2.addActionListener(frm);
		mi1_3.addActionListener(frm);
		mi1_4.addActionListener(frm);
		mi2_1.addActionListener(frm);
		mi2_2.addActionListener(frm);
		mi2_3.addActionListener(frm);
		mi2_4.addActionListener(frm);

		frm.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});

		frm.add(txa);
		frm.setLocationRelativeTo(null);
		frm.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		final MenuItem mi = (MenuItem) e.getSource();

		// 讀檔
		if (mi == mi1_1) {
			open_file();
		// 存檔
		} else if (mi == mi1_2) {
			if (fname_r.equals("")){ //如果檔名為空, 改用save as file
				save_as();
				return;
			}else{
				save_file();		//否則直接存
			}
		// 另存新檔
		} else if (mi == mi1_3) {
			save_as();
			// 結束
		} else if (mi == mi1_4) {
			System.exit(0);
			// 字型- PLAIN, BOLD, ITALIC, BOLD+ITALIC
		} else if (mi == mi2_1) {
			txa.setFont(new Font("新細明體", Font.PLAIN, 18));
		} else if (mi == mi2_2) {
			txa.setFont(new Font("新細明體", Font.BOLD, 18));
		} else if (mi == mi2_3) {
			txa.setFont(new Font("新細明體", Font.ITALIC, 18));
		} else if (mi == mi2_4) {
			txa.setFont(new Font("新細明體", Font.BOLD | Font.ITALIC, 16));
		}
	}

	private void save_file() {
		// TODO Auto-generated method stub
		String strSave = txa.getText();
		FileWriter fw;

		try {
			fw = new FileWriter(fname_r);
			System.out.println("Save to "+fname_r);
			fw.write(strSave);
			fw.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("SAVE ERROR!");
			// e1.printStackTrace();
		}
	}

	private void open_file() {
		// TODO Auto-generated method stub
		open_fdlg.setVisible(true);
		fname_r = open_fdlg.getDirectory() + open_fdlg.getFile();
		System.out.println("Open "+fname_r);
		
		try {
			FileInputStream fi = new FileInputStream(fname_r);
			byte ba[] = new byte[fi.available()];
			fi.read(ba);
			txa.setText(new String(ba));
			fi.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("READ ERROR!!");
			// e1.printStackTrace();
		}
	}

	private void save_as() {
		// TODO Auto-generated method stub
		save_fdlg.setVisible(true);
		fname_r = save_fdlg.getDirectory() + save_fdlg.getFile();
		System.out.println("Save as "+fname_r);

		try {
			FileOutputStream fo = new FileOutputStream(fname_r);
			String str = txa.getText();
			byte data[] = str.getBytes();
			fo.write(data);
			fo.close();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			System.out.println("SAVE AS FILE ERROR!");
//			e1.printStackTrace();
		}
	}

	@Override
	public void textValueChanged(TextEvent arg0) {
		// TODO Auto-generated method stub
		txa.getText();
		// System.out.println("textValueChanged!");
	}

	@Override
	public void itemStateChanged(ItemEvent arg0) {
		// TODO Auto-generated method stub

	}

}
