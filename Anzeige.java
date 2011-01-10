import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Anzeige extends JPanel {
	
	private final int MARGIN = 10;
	private final int PADDING = 10;
	
	protected void paintComponent (Graphics h) {
		final Graphics2D g = (Graphics2D)h;
		g.setRenderingHints(new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON));
		
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		int i = 0;
		for (Car car : Ampel.cars) {
			g.setColor(Color.DARK_GRAY);
			g.drawOval(MARGIN + i*PADDING, MARGIN + i*PADDING, getWidth()-2*MARGIN-2*i*PADDING, getHeight()-2*MARGIN-2*i*PADDING);
			g.setColor(Color.WHITE);
			g.drawArc(MARGIN + i*PADDING, MARGIN + i*PADDING, getWidth()-2*MARGIN-2*i*PADDING, getHeight()-2*MARGIN-2*i*PADDING, (int)Math.toDegrees(car.phi), -2);
			if (car.stopping) {
				g.setColor(Color.red);
				g.drawArc(MARGIN + i*PADDING, MARGIN + i*PADDING, getWidth()-2*MARGIN-2*i*PADDING, getHeight()-2*MARGIN-2*i*PADDING, (int)Math.toDegrees(car.phi)-1, -1);
			}
			
			g.setColor(Ampel.isGreen ? Color.green : Color.RED);
			g.drawLine(getWidth()-MARGIN/2-i*PADDING, getHeight()/2, getWidth()-3*MARGIN/2-i*PADDING, getHeight()/2);
			
			g.setColor(Color.GRAY);
			g.drawString("v: "+Math.round(car.velocity)+" m/s", getWidth()/4+i*120, getHeight()/3+0*30);
			g.drawString("dTL: "+Math.round(car.distanceToLight)+" m", getWidth()/4+i*120, getHeight()/3+1*30);
			g.drawString("tTL: "+(car.timeToLight < 1000 ? Math.round(car.timeToLight)+" s" : "inf"), getWidth()/4+i*120, getHeight()/3+2*30);
			g.drawString("E: "+Math.round(car.energyUsed)+" J", getWidth()/4+i*120, getHeight()/3+3*30);
			g.drawString("Laps: "+Math.floor(car.phi2/2/Math.PI), getWidth()/4+i*120, getHeight()/3+4*30);
			g.drawString("Eff: "+Math.round(car.phi2/2/Math.PI*100)/100.0, getWidth()/4+i*120, getHeight()/3+5*30);
			
			i++;
		}
		
		g.setColor(Ampel.isGreen ? Color.green : Color.RED);
		g.drawString((int)Ampel.timeLeft+" s", getWidth()-4*MARGIN-i*PADDING, getHeight()/2);
	}
}
