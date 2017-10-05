package CWK4;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;



public class ColorButton extends JButton implements ActionListener {
    
	public static final long serialVersionUID = 1L;
	public int num, width, height = 0;
	public PsyagceMain inst;
	public Boolean showColour, showBlack;
	public Color buttonColour;
	
	public ColorButton(int num, PsyagceMain inst, int width, int height){
		this.num = num;
		this.inst = inst;
		this.width = width;
		this.height = height;
		showColour = false;
		showBlack = false;
	}
	
	public void flip(Boolean side){
		if(side == true)
			showColour = true;
		else
			showColour = false;
	}
	
	public void setColour(Color buttonColour){
		this.buttonColour = buttonColour;
	}
	
	public int getNum(){
		return num;
	}
	
	public void draw(){
		
		 setContentAreaFilled(false);
         setOpaque(true);
         
		if(showBlack != true){
			if(showColour != true){
				setBackground(Color.GRAY);
			}
			else{
				setBackground(buttonColour);
			}
		}
		else{
			setBackground(Color.BLACK);
		}
	}
	
	public void addListener(){
		 addActionListener(this);
		 
	}
	
	@Override
	public void actionPerformed(ActionEvent e){
		setVisible(true);
		inst.buttonClicked(num);
	}

}
