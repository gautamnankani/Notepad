import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;    
import javax.swing.border.LineBorder; 
class Pro_Notepad{
	public static void main(String args[]){
		show s=new show();
	}
}

class show implements ActionListener{
	JMenuBar mb;
	JMenu Menu,View,Format,Edit;
	JMenuItem New,Open,Save,SaveAs,Cut,Copy,Paste,Font,Zoom;
	JTextArea ta;
	JScrollBar sb;
	JScrollPane sp;
	show(){
		JFrame f=new JFrame("ProNotepad");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//f.setLayout();
		/////////////
		mb=new JMenuBar();
		Menu=new JMenu("Menu");
		Edit=new JMenu("Edit");
		Format=new JMenu("Format");
		View=new JMenu("View");
		New=new JMenuItem("New"); Open=new JMenuItem("Open"); Save=new JMenuItem("Save");
		SaveAs=new JMenuItem("SaveAs"); Cut=new JMenuItem("Cut"); Copy=new JMenuItem("Copy");
		Paste=new JMenuItem("Paste"); Font=new JMenuItem("Font"); Zoom=new JMenuItem("Zoom");
		ta=new JTextArea(200,50);
		sb=new JScrollBar();
		sp=new JScrollPane(ta);
		//////////////////////
		f.setSize(1000,800);
		f.setJMenuBar(mb);
		/////////////////
		
		mb.add(Menu);  mb.add(Edit);   mb.add(Format);   mb.add(View);
		Menu.add(New); Menu.add(Open); Menu.add(Save); Menu.add(SaveAs);
		Edit.add(Cut); Edit.add(Copy); Edit.add(Paste); 
		Format.add(Font);  View.add(Zoom);
		sp.setPreferredSize(new Dimension(100,100));
		//sp.add(ta);
		sp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		f.add(sp,BorderLayout.CENTER);
		//////////////////
		New.addActionListener(this);
		Open.addActionListener(this);
		Save.addActionListener(this);
		SaveAs.addActionListener(this);
		Cut.addActionListener(this);
		Copy.addActionListener(this);
		Paste.addActionListener(this);
		Font.addActionListener(this);
		Zoom.addActionListener(this);
		/////////////////
		//sb.setBounds(985,1,15,800);
		//f.pack();
		f.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==Cut)
			ta.cut();
		if(e.getSource()==Copy)
			ta.copy();
		if(e.getSource()==Paste)
			ta.paste();
		if(e.getSource()==New)
			new show();
		if (e.getSource() == Open) {
		//Create a file chooser
		final JFileChooser fc = new JFileChooser();
		//In response to a button click:
		int returnVal = fc.showOpenDialog(aComponent);
        int returnVal = fc.showOpenDialog(this);

        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fc.getSelectedFile();
            //This is where a real application would open the file.
            log.append("Opening: " + file.getName() + "." + newline);
        } else {
            log.append("Open command cancelled by user." + newline);
        }
        } 
	}
	
}