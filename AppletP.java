import java.applet.Applet;
import java.awt.Graphics;
/*
< applet code=”AppletP.class” width= “300” height =”300” bgcolor=”green”>
</applet>
*/
public class AppletP extends Applet
{
	public void paint(Graphics g){
	g.drawString("Welcome to Applet",100,150);
	}
}
