import java.awt.image.*;
import javax.swing.*;
import java.awt.*;
import javax.imageio.spi.*;
import javax.imageio.*;
import java.io.*;
import com.sun.imageio.spi.*;
import javax.imageio.ImageIO;
import javax.imageio.ImageWriter;
import javax.imageio.stream.ImageOutputStream;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Iterator;
import javax.imageio.*;
import javax.imageio.ImageIO;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import com.sun.image.codec.jpeg.*;



public  class encryption implements ActionListener
  {
    JFrame f,op,op2;
    JTextArea ta;
    JTextField tf;
    FileDialog fd;
    JButton br,ec,eb;
    JLabel jl1,jl2,jl3,jl4,jl5;
    JScrollPane js1;
    String key="0123456789qwertyuiopasdfghjklzxcvbnm ";
    Dialog d;     
    BufferedImage bf2,ti,tii,bf;

encryption()
{
f=new JFrame("ENCRYPTION(Sender)");
 f.setState(f.ICONIFIED);
 f.setState(f.NORMAL);
  f.setResizable(false);
f.setSize(500, 750);
f.setLocation(400, 10);
f.setVisible(true);
f.setLayout(null);
ta=new JTextArea();
br=new JButton("Browse");
ec=new JButton("Encrypt");
eb=new JButton("Embedd");
jl1=new JLabel("Plain Text");
jl2=new JLabel("Encrypted Image");
tf=new JTextField();
js1=new JScrollPane(ta);
jl4=new JLabel("Select  an image(.PNG)");
jl5=new JLabel("(special sym not allowed)");

js1.setBounds(155,20,200,100);
jl1.setBounds(50,20,100,50);
jl2.setBounds(50,10,100,504);
jl3=new JLabel();
jl4.setBounds(25,600,200,50);
jl5.setBounds(1,40,160,50);

br.setBounds(280, 640, 100, 25);
ec.setBounds(370,100,125,25);
tf.setBounds(80, 640, 200, 25);
eb.setBounds(350,680,120,30);

f.add(js1);    
f.add(br);    
f.add(ec); 
f.add(eb);   
f.add(jl1);    
f.add(jl4);
f.add(tf); 
f.add(jl5);

eb.addActionListener(this);
br.addActionListener(this);
ec.addActionListener(this);

f.setState(f.ICONIFIED);

f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
     
public void actionPerformed(ActionEvent ae)
{ 
  String cmd=ae.getActionCommand();
   if(cmd.equals("Browse"))
    {
        fd=new FileDialog(f,"Select an Image");
        fd.setVisible(true);
        tf.setText(fd.getDirectory()+""+fd.getFile());
     }
    if(cmd.equals("Encrypt"))
       {
             String msg=ta.getText();
               
             if(!(ta.getText().equals("")))
                  {    
                     try{   if(msg.length()>500) {JOptionPane.showMessageDialog(f,"Max length of message is 500");}
                          
                              encry();}   catch(Exception e){}                        
                    }   
             else{JOptionPane.showMessageDialog(f,"Enter the message ");} }    
        
     if(cmd.equals("Embedd")){
            try{   if(!(tf.getText().equals(""))) { embedd(); JOptionPane.showMessageDialog(f,"Embedding process successfully completed");}
                    else{JOptionPane.showMessageDialog(f,"Select input image");}
                    } catch(Exception e){}
                                                        }

}

int getJValue(char c)
{
 
 for(int i=0;i<key.length();i++)
 if(c==key.charAt(i)) return i;
return 0;
}   

void encry()throws Exception
  {
    
    
     f.remove(jl3);
String msg=ta.getText();
              
bf=new BufferedImage(40,504,5);
 
  for(int i=0;i<msg.length();i++)
  {
    switch(msg.charAt(i))
     {
      case '0': bf.setRGB(0,i,new Color(255,0,0).getRGB());
               break;
      case '1': bf.setRGB(1,i,new Color(0,255,0).getRGB());
               break;
      case '2': bf.setRGB(2,i,new Color(0,0,255).getRGB());
               break;
      case '3': bf.setRGB(3,i,new Color(25,25,0).getRGB());
               break;
      case '4': bf.setRGB(4,i,new Color(25,0,25).getRGB());
               break;
      case '5': bf.setRGB(5,i,new Color(0,25,25).getRGB());
               break;
      case '6': bf.setRGB(6,i,new Color(50,50,0).getRGB());
               break;
      case '7': bf.setRGB(7,i,new Color(50,0,50).getRGB());
               break;
      case '8': bf.setRGB(8,i,new Color(0,50,50).getRGB());
               break;
      case '9': bf.setRGB(9,i,new Color(75,75,0).getRGB());
               break;
      case 'Q':
      case 'q': bf.setRGB(10,i,new Color(0,75,75).getRGB());
               break;
       case 'W':
      case 'w': bf.setRGB(11,i,new Color(75,0,75).getRGB());
               break;
      case 'E':
      case 'e': bf.setRGB(12,i,new Color(100,100,0).getRGB());
               break;
      case 'R':
      case 'r': bf.setRGB(13,i,new Color(100,0,100).getRGB());
               break;
      case 'T':
      case 't': bf.setRGB(14,i,new Color(0,100,100).getRGB());
               break;
      case 'Y':
      case 'y': bf.setRGB(15,i,new Color(125,125,0).getRGB());
               break;
      case 'U':
      case 'u': bf.setRGB(16,i,new Color(125,0,125).getRGB());
               break;
      case 'I':
      case 'i': bf.setRGB(17,i,new Color(0,125,125).getRGB());
               break;
      case 'O':
      case 'o': bf.setRGB(18,i,new Color(150,150,0).getRGB());
               break;
      case 'P':
      case 'p': bf.setRGB(19,i,new Color(0,150,150).getRGB());
               break;
      case 'A':
      case 'a': bf.setRGB(20,i,new Color(150,0,150).getRGB());
               break;
      case 'S':
      case 's': bf.setRGB(21,i,new Color(200,200,0).getRGB());
               break;
      case 'D':
      case 'd': bf.setRGB(22,i,new Color(200,0,200).getRGB());
               break;
      case 'F':
      case 'f': bf.setRGB(23,i,new Color(0,200,200).getRGB());
               break;
      case 'G':
      case 'g': bf.setRGB(24,i,new Color(245,0,245).getRGB());
               break;
       case 'H':
       case 'h': bf.setRGB(25,i,new Color(245,245,0).getRGB());
               break;
      case 'J':
      case 'j': bf.setRGB(26,i,new Color(0,245,245).getRGB());
               break;
      case 'K':
      case 'k': bf.setRGB(27,i,new Color(225,225,0).getRGB());
               break;
      case 'L':
      case 'l': bf.setRGB(28,i,new Color(225,0,225).getRGB());
               break; 
      case 'Z':
      case 'z': bf.setRGB(29,i,new Color(0,225,225).getRGB());
               break;
      case 'X':
      case 'x': bf.setRGB(30,i,new Color(135,0,135).getRGB());
               break;
      case 'C':
      case 'c': bf.setRGB(31,i,new Color(135,125,0).getRGB());
               break;
      case 'V':
      case 'v': bf.setRGB(32,i,new Color(145,135,125).getRGB());
               break;
      case 'B':
      case 'b': bf.setRGB(33,i,new Color(125,0,135).getRGB());
               break;
      case 'N':
      case 'n': bf.setRGB(34,i,new Color(200,145,100).getRGB());
                break;
      case 'M':
      case 'm': bf.setRGB(35,i,new Color(25,0,250).getRGB());
               break;
       default: bf.setRGB(36,i,new Color(25,25,25).getRGB());
               break;
       }
     }

// ImageIO.write(bf,"jpg",new FileOutputStream(new File("encrypted.jpg")));
// f.remove(jl3);
jl3=new JLabel();
jl3.setBounds(200,124,50,504);
 jl3.setIcon(new ImageIcon(bf));
f.add(jl2);
f.add(jl3);
f.setState(f.ICONIFIED);
//f.add(jl3);
 f.setState(f.NORMAL);
 }

 public static void main(String aa[]) throws Exception

{  
   
  new encryption();
   
}


void embedd() throws Exception
{
 ImageIcon tii=new ImageIcon(tf.getText());
 int counter=0;
 bf2=new BufferedImage(tii.getIconWidth(),tii.getIconHeight(),5);
 ti=new BufferedImage(tii.getIconWidth(),tii.getIconHeight(),5);
 Graphics g = ti.getGraphics();
    g.drawImage(tii.getImage(), 0, 0, null);
    g=bf2.getGraphics();
    int counter1=0;
   g.drawImage(tii.getImage(),0,0,null);
   counter=0;


for(int i=0,ii=0,jj=0;i<40;i++)
for(int j=0;j<504;j++)
{


if(jj+15>=tii.getIconHeight()) {jj=0;ii++;}

ti.setRGB(ii,jj,new Color(new Color(ti.getRGB(ii,jj)).getRed(),new Color(ti.getRGB(ii,jj)).getGreen(),new Color(ti.getRGB(ii,jj)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getAlpha()>>6),new Color(ti.getRGB(ii,jj)).getAlpha()).getRGB());
ti.setRGB(ii,jj+1,new Color(new Color(ti.getRGB(ii,jj+1)).getRed(),new Color(ti.getRGB(ii,jj+1)).getGreen(),new Color(ti.getRGB(ii,jj+1)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getAlpha()>>4&3),new Color(ti.getRGB(ii,jj+1)).getAlpha()).getRGB());
ti.setRGB(ii,jj+2,new Color(new Color(ti.getRGB(ii,jj+2)).getRed(),new Color(ti.getRGB(ii,jj+2)).getGreen(),new Color(ti.getRGB(ii,jj+2)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getAlpha()>>2&3),new Color(ti.getRGB(ii,jj+2)).getAlpha()).getRGB());
ti.setRGB(ii,jj+3,new Color(new Color(ti.getRGB(ii,jj+3)).getRed(),new Color(ti.getRGB(ii,jj+3)).getGreen(),new Color(ti.getRGB(ii,jj+3)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getAlpha()&3),new Color(ti.getRGB(ii,jj+3)).getAlpha()).getRGB());
ti.setRGB(ii,jj+4,new Color(new Color(ti.getRGB(ii,jj+4)).getRed(),new Color(ti.getRGB(ii,jj+4)).getGreen(),new Color(ti.getRGB(ii,jj+4)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getRed()>>6),new Color(ti.getRGB(ii,jj+4)).getAlpha()).getRGB());
ti.setRGB(ii,jj+5,new Color(new Color(ti.getRGB(ii,jj+5)).getRed(),new Color(ti.getRGB(ii,jj+5)).getGreen(),new Color(ti.getRGB(ii,jj+5)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getRed()>>4&3),new Color(ti.getRGB(ii,jj+5)).getAlpha()).getRGB());
ti.setRGB(ii,jj+6,new Color(new Color(ti.getRGB(ii,jj+6)).getRed(),new Color(ti.getRGB(ii,jj+6)).getGreen(),new Color(ti.getRGB(ii,jj+6)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getRed()>>2&3),new Color(ti.getRGB(ii,jj+6)).getAlpha()).getRGB());
ti.setRGB(ii,jj+7,new Color(new Color(ti.getRGB(ii,jj+7)).getRed(),new Color(ti.getRGB(ii,jj+7)).getGreen(),new Color(ti.getRGB(ii,jj+7)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getRed()&3),new Color(ti.getRGB(ii,jj+7)).getAlpha()).getRGB());
ti.setRGB(ii,jj+8,new Color(new Color(ti.getRGB(ii,jj+8)).getRed(),new Color(ti.getRGB(ii,jj+8)).getGreen(),new Color(ti.getRGB(ii,jj+8)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getGreen()>>6),new Color(ti.getRGB(ii,jj+8)).getAlpha()).getRGB());
ti.setRGB(ii,jj+9,new Color(new Color(ti.getRGB(ii,jj+9)).getRed(),new Color(ti.getRGB(ii,jj+9)).getGreen(),new Color(ti.getRGB(ii,jj+9)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getGreen()>>4&3),new Color(ti.getRGB(ii,jj+9)).getAlpha()).getRGB());
ti.setRGB(ii,jj+10,new Color(new Color(ti.getRGB(ii,jj+10)).getRed(),new Color(ti.getRGB(ii,jj+10)).getGreen(),new Color(ti.getRGB(ii,jj+10)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getGreen()>>2&3),new Color(ti.getRGB(ii,jj+10)).getAlpha()).getRGB());
ti.setRGB(ii,jj+11,new Color(new Color(ti.getRGB(ii,jj+11)).getRed(),new Color(ti.getRGB(ii,jj+11)).getGreen(),new Color(ti.getRGB(ii,jj+11)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getGreen()&3),new Color(ti.getRGB(ii,jj+11)).getAlpha()).getRGB());
ti.setRGB(ii,jj+12,new Color(new Color(ti.getRGB(ii,jj+12)).getRed(),new Color(ti.getRGB(ii,jj+12)).getGreen(),new Color(ti.getRGB(ii,jj+12)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getBlue()>>6),new Color(ti.getRGB(ii,jj+12)).getAlpha()).getRGB());
ti.setRGB(ii,jj+13,new Color(new Color(ti.getRGB(ii,jj+13)).getRed(),new Color(ti.getRGB(ii,jj+13)).getGreen(),new Color(ti.getRGB(ii,jj+13)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getBlue()>>4&3),new Color(ti.getRGB(ii,jj+13)).getAlpha()).getRGB());
ti.setRGB(ii,jj+14,new Color(new Color(ti.getRGB(ii,jj+14)).getRed(),new Color(ti.getRGB(ii,jj+14)).getGreen(),new Color(ti.getRGB(ii,jj+14)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getBlue()>>2&3),new Color(ti.getRGB(ii,jj+14)).getAlpha()).getRGB());
ti.setRGB(ii,jj+15,new Color(new Color(ti.getRGB(ii,jj+15)).getRed(),new Color(ti.getRGB(ii,jj+15)).getGreen(),new Color(ti.getRGB(ii,jj+15)).getBlue()>>2<<2|(new Color(bf.getRGB(i,j)).getBlue()&3),new Color(ti.getRGB(ii,jj+15)).getAlpha()).getRGB());

jj+=16;
}
Iterator imageWriters = ImageIO.getImageWritersByFormatName("PNG");
    ImageWriter imageWriter = (ImageWriter) imageWriters.next();
String sss[]=ImageIO.getReaderFormatNames();

ImageWriteParam iwp = imageWriter.getDefaultWriteParam();

IIOImage image = new IIOImage(ti, null, null);

    File file = new File("output.png");
    ImageOutputStream ios = ImageIO.createImageOutputStream(file);
    imageWriter.setOutput(ios);
    imageWriter.write(null,image,iwp);

op=new JFrame("OUTPUT");
JLabel opl=new JLabel();
op.setLayout(null);
opl.setIcon(new ImageIcon(ti));

opl.setBounds(10,10,opl.getIcon().getIconWidth(),opl.getIcon().getIconHeight());
op.setSize(opl.getIcon().getIconWidth(),opl.getIcon().getIconHeight());
op.add(opl);
op.setVisible(true);
 op.setResizable(false);
op.setState(f.ICONIFIED);
 op.setState(f.NORMAL);

op2=new JFrame("INPUT IMAGE");
ImageIcon ip=new ImageIcon(tf.getText());
JLabel ipl=new JLabel();
op2.setLayout(null);
ipl.setIcon(ip);
ipl.setBounds(0,0,opl.getIcon().getIconWidth(),opl.getIcon().getIconHeight());
op2.setSize(opl.getIcon().getIconWidth(),opl.getIcon().getIconHeight());
op2.add(ipl);
op2.setVisible(true);
op2.setLocation(50,500);
 op2.setResizable(false);
op2.setState(f.ICONIFIED);
 op2.setState(f.NORMAL);

}

}