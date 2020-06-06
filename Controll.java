package LifeGame;

import java.awt.Component;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Controll {
    Controll() {
    	JFrame jframe=new JFrame();
    	jframe.setSize(425,460);
    	JPanel jpanel=new JPanel();
    	jpanel.setBounds(0,0,400,400);
    	int count=0;
    	Cell [][]cell=new Cell[16][16];
    	cell=Map.initial();
    	Map.getLiving(cell);
    	jframe.setTitle("这是第"+count+"次演化");
    	jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	jframe.setLocationRelativeTo(null);
    	jframe.add(jpanel);
    	jframe.setVisible(true);
    	Graphics g=jpanel.getGraphics();
    	for(int i=0;i<16;i++) {
    		for(int j=0;j<16;j++) {
    			g.drawRect(i*25, j*25, 25, 25);
    		}
    	}
    	for(int i=0;i<16;i++) {
    		for(int j=0;j<16;j++) {
    			if(cell[i][j].getStatus()==1) {
    				g.fillRect(i*25, j*25, 25, 25);
    			}
    			else {
    				g.drawRect(i*25, j*25, 25, 25);
    			}
    		}
    	}
    	long d1= System.currentTimeMillis();
    	while(true) {
    		long d2= System.currentTimeMillis();
    		if(d2-d1>200) {
    			int change;
    			d1=d2;
    			jframe.repaint();
    			change=Map.update(cell);
    			Map.getLiving(cell);
    			for(int i=0;i<16;i++) {
    	    		for(int j=0;j<16;j++) {
    	    			g.drawRect(i*25, j*25, 25, 25);
    	    		}
    	    	}
    			for(int i=0;i<16;i++) {
    				for(int j=0;j<16;j++) {
    					if(cell[i][j].getStatus()==1) {
    	    				g.fillRect(i*25, j*25, 25, 25);
    	    			}
    	    			else {
    	    				g.drawRect(i*25, j*25, 25, 25);
    				    }
    				}
    			}
    		    count++;
    		    jframe.setTitle("这是第"+count+"次演化");
    			if(change==16*16) break;
    			if(count>1000) break;
    	    }	    	
      }
    	JOptionPane.showMessageDialog(jframe, "在第"+count+"次演化达到平衡", "提示", JOptionPane.PLAIN_MESSAGE);
    }
}

