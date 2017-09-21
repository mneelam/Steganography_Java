import javax.imageio.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JMenuBar;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.FileDialog;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.image.*;
import java.io.IOException;
import java.net.URL;



public  class decryption implements ActionListener
  {
  JFrame f;
  JTextArea jt1;
  JButton dec,br,e;
  JLabel jl,jl1,jl2,jl3,jl4;
   JTextField tf;
    FileDialog fd;
      JScrollPane js;
    String s1="Enter Text";
   
 decryption()
{
     f=new JFrame("DECRYPTION(Receiver)");
      f.setLocation(400,10);

     jt1=new JTextArea();
     jt1.setEditable(false);
      jt1.setLineWrap(true);
     js=new JScrollPane(jt1);
    dec=new JButton("Extract");
    br=new JButton("Browse");
    e=new JButton("Decrypt");
    jl=new JLabel("Extracted Image");
   jl1=new JLabel("Extract the image..");  
   jl2=new JLabel("The decrypted Text is..");  
   jl3=new JLabel();
    jl4=new JLabel("Extracted Image");
    tf=new JTextField();
    
  

       f.setLayout(null);
      f.setVisible(true);
     f.setSize(500,780); 
     
      
      jl1.setBounds(25,20,200,50);
      jl2.setBounds(75,590,150,50);
      jl3.setBounds(200,90,100,504);
     js.setBounds(125,640,200,100);
     dec.setBounds(350,130,125,25); 
     br.setBounds(280, 60, 100, 25);
     tf.setBounds(90, 60, 200, 25);
     e.setBounds(340,550,100,30);

     f.add(js);
     f.add(dec);
     // f.add(br);
    f.add(jl);
    //f.add(tf);
     f.add(jl1);
       f.add(jl2);
       f.add(e);

  br.addActionListener(this);
dec.addActionListener(this);
 e.addActionListener(this);

  f.setResizable(false);
 f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}


void decrypt()throws Exception
{
int pixx=0,pixy=0;
int arr[]=new int[1000000];
for(int i=0;i<arr.length;i++) arr[i]=-1;
ImageIcon in=new ImageIcon("output.png");
int w=in.getIconWidth(),h=in.getIconHeight();
  BufferedImage bf=new BufferedImage(w,h,5);

  BufferedImage bf2=new BufferedImage(40,504,5);
Graphics g = bf.getGraphics();
int counter1=0;
    g.drawImage(in.getImage(), 0, 0, null);
int counter=0;
int pixelcounter=0;

for(int i=0,ii=0,jj=0;i<40;i++)
for(int j=0;j<504;j++)
{
  if(jj+15>=h) { jj=0;ii++; }
if(pixy>=504){ pixx++;pixy=0;}

 int alpha=0;
int red=0;
int green=0;
int blue=0;  
 for(int k=0;k<4;k++,jj++)
 alpha+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);
 for(int k=0;k<4;k++,jj++)
red+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);
 for(int k=0;k<4;k++,jj++)
 green+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);
 for(int k=0;k<4;k++,jj++)
 blue+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);

bf2.setRGB(i,j,new Color(red,green,blue).getRGB());

}

//ImageIO.write(bf2,"jpg",new FileOutputStream(new File("extracted.jpg")));
  String key="0123456789qwertyuiopasdfghjklzxcvbnm ";
  
    for(int i=0,ii=0,jj=0;i<40;i++)
for(int j=0;j<504;j++)
{
  if(jj+15>=h) { jj=0;ii++; }
if(pixy>=504){ pixx++;pixy=0;}
  int alpha=0;
int red=0;
int green=0;
int blue=0;  
 for(int k=0;k<4;k++,jj++)
 alpha+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);
 for(int k=0;k<4;k++,jj++)
red+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);
 for(int k=0;k<4;k++,jj++)
 green+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);
 for(int k=0;k<4;k++,jj++)
 blue+=(new Color(bf.getRGB(ii,jj)).getBlue()&3)<<(6-2*k);
                      
                  
if((alpha==255)&&(red==255)&&(green==0)&&(blue==0)) {counter++;arr[pixy]=0;}
else if((alpha==255)&&(red==0)&&(green==255)&&(blue==0)) {counter++;arr[pixy]=1;}
else if((alpha==255)&&(red==0)&&(green==0)&&(blue==255)) {counter++;arr[pixy]=2;}
else if((alpha==255)&&(red==25)&&(green==25)&&(blue==0)) {counter++;arr[pixy]=3;}
else if((alpha==255)&&(red==25)&&(green==0)&&(blue==25)) {counter++;arr[pixy]=4;}
else if((alpha==255)&&(red==0)&&(green==25)&&(blue==25)) {counter++;arr[pixy]=5;}
else if((alpha==255)&&(red==50)&&(green==50)&&(blue==0)) {counter++;arr[pixy]=6;}
else if((alpha==255)&&(red==50)&&(green==0)&&(blue==50)) {counter++;arr[pixy]=7;}
else if((alpha==255)&&(red==0)&&(green==50)&&(blue==50)) {counter++;arr[pixy]=8;}
else if((alpha==255)&&(red==75)&&(green==75)&&(blue==0)) {counter++;arr[pixy]=9;}
else if((alpha==255)&&(red==0)&&(green==75)&&(blue==75)) {counter++;arr[pixy]=10;}
else if((alpha==255)&&(red==75)&&(green==0)&&(blue==75)) {counter++;arr[pixy]=11;}
else if((alpha==255)&&(red==100)&&(green==100)&&(blue==0)) {counter++;arr[pixy]=12;}
else if((alpha==255)&&(red==100)&&(green==0)&&(blue==100)) {counter++;arr[pixy]=13;}
else if((alpha==255)&&(red==0)&&(green==100)&&(blue==100)) {counter++;arr[pixy]=14;}
else if((alpha==255)&&(red==125)&&(green==125)&&(blue==0)) {counter++;arr[pixy]=15;}
else if((alpha==255)&&(red==125)&&(green==0)&&(blue==125)) {counter++;arr[pixy]=16;}
else if((alpha==255)&&(red==0)&&(green==125)&&(blue==125)) {counter++;arr[pixy]=17;}
else if((alpha==255)&&(red==150)&&(green==150)&&(blue==0)) {counter++;arr[pixy]=18;}
else if((alpha==255)&&(red==0)&&(green==150)&&(blue==150)) {counter++;arr[pixy]=19;}
else if((alpha==255)&&(red==150)&&(green==0)&&(blue==150)) {counter++;arr[pixy]=20;}
else if((alpha==255)&&(red==200)&&(green==200)&&(blue==0)) {counter++;arr[pixy]=21;}
else if((alpha==255)&&(red==200)&&(green==0)&&(blue==200)) {counter++;arr[pixy]=22;}
else if((alpha==255)&&(red==0)&&(green==200)&&(blue==200)) {counter++;arr[pixy]=23;}
else if((alpha==255)&&(red==245)&&(green==0)&&(blue==245)) {counter++;arr[pixy]=24;}
else if((alpha==255)&&(red==245)&&(green==245)&&(blue==0)) {counter++;arr[pixy]=25;}
else if((alpha==255)&&(red==0)&&(green==245)&&(blue==245)) {counter++;arr[pixy]=26;}
else if((alpha==255)&&(red==225)&&(green==225)&&(blue==0)) {counter++;arr[pixy]=27;}
else if((alpha==255)&&(red==225)&&(green==0)&&(blue==225)) {counter++;arr[pixy]=28;}
else if((alpha==255)&&(red==0)&&(green==225)&&(blue==225)) {counter++;arr[pixy]=29;}
else if((alpha==255)&&(red==135)&&(green==0)&&(blue==135)) {counter++;arr[pixy]=30;}
else if((alpha==255)&&(red==135)&&(green==125)&&(blue==0)) {counter++;arr[pixy]=31;}
else if((alpha==255)&&(red==145)&&(green==135)&&(blue==125)) {counter++;arr[pixy]=32;}
else if((alpha==255)&&(red==125)&&(green==0)&&(blue==135)) {counter++;arr[pixy]=33;}
else if((alpha==255)&&(red==200)&&(green==145)&&(blue==100)) {counter++;arr[pixy]=34;}
else if((alpha==255)&&(red==25)&&(green==0)&&(blue==250)) {counter++;arr[pixy]=35;}
else if((alpha==255)&&(red==25)&&(green==25)&&(blue==25)) {counter++;arr[pixy]=36;}

pixy++;
}
StringBuffer sb=new StringBuffer(1000);
  //String s1="Enter Text";
   
 jl3.setIcon(new ImageIcon(bf2));
 f.add(jl3);

for(int i=0;arr[i]!=-1;i++)
{
     
   
   s1=sb.append(key.charAt(arr[i])).toString();;
     
 }
  
    
  

}
public void actionPerformed(ActionEvent ae)
 {
     String cmd=ae.getActionCommand();
  
   if(cmd.equals("Extract"))
      {
             try{
             decrypt(); 
                  f.setState(f.ICONIFIED);
                  f.setState(f.NORMAL);     
                 jl.setBounds(50,150,100,50);
             // else  {JOptionPane.showMessageDialog(f,"Select the image");}
                    }
     catch(Exception e){}

      }
    /*if(cmd.equals("Browse"))  
       {
         fd=new FileDialog(f,"Select an Image");
        fd.setVisible(true);
        tf.setText(fd.getDirectory()+""+fd.getFile());
        }*/

    if(cmd.equals("Decrypt"))
      {
              jt1.setText(s1);
          }
  }
 
 public static void main(String aa[]) throws Exception

{
     new decryption();
}
}