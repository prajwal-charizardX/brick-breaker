import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
//import java.lang.Math.*;


class MapGenerator {
	
	public int map [][];
	public int brickWidth;
	public int brickHeight;
	public int lvl;
	
	// this constructor creates the bricks
	public MapGenerator (int row, int col, int a, int b, int level) {
		map = new int [row][col];
		for (int i = 0; i < map.length; i++) { 
			for (int j=0; j< map[0].length;j++) {
				map[i][j] = 1;
			}
		}
		
		lvl = level;
		brickWidth = a/col;
		brickHeight = b/row;
	}


	
	// this method draws the bricks
	public void draw(Graphics2D g) {

		if(lvl == 1){
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j< map[0].length;j++) {
					if(map[i][j] > 0) {
						if (Math.abs(j-i) % 3 == 0) {
							g.setColor(new Color(0XFF2400));
						} else if (Math.abs(j-i) % 3 == 1) {
							g.setColor(Color.CYAN);
						} else if (Math.abs(j-i) % 3 == 2) {
							g.setColor(new Color(0X32CD32));
						}
						
						/*
						if (i % 3 == 0) {
							g.setColor(new Color(0XFF2400));
						} else if (i % 3 == 1) {
							g.setColor(Color.CYAN);
						} else if (i % 3 == 2) {
							g.setColor(new Color(0X32CD32));
						}
						*/

						//g.setColor(Color.decode(randomValue)); // brick color

						g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);

						g.setStroke(new BasicStroke(4));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					}
				}
				
			}
		}

		else if(lvl == 2){
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j< map[0].length;j++) {
					if(map[i][j] > 0) {

						if(j==3)
							continue;
						
						if (Math.abs(j-i) % 3 == 0) {
							g.setColor(new Color(0XFF2400));
						} else if (Math.abs(j-i) % 3 == 1) {
							g.setColor(Color.CYAN);
						} else if (Math.abs(j-i) % 3 == 2) {
							g.setColor(new Color(0X32CD32));
						}
						
						/*
						if (i % 3 == 0) {
							g.setColor(new Color(0XFF2400));
						} else if (i % 3 == 1) {
							g.setColor(Color.CYAN);
						} else if (i % 3 == 2) {
							g.setColor(new Color(0X32CD32));
						}
						*/

						//g.setColor(Color.decode(randomValue)); // brick color
						/*if(j<3){
							g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
						}
						
						else {
							g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
						}*/
						g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
						g.setStroke(new BasicStroke(4));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					}
				}
				
			}
		}

		else if(lvl == 3){
			for (int i = 0; i < map.length; i++) {
				for (int j = 0; j< map[0].length;j++) {
					if(map[i][j] > 0) {

						if(j==3)
							continue;
						if(i==3)
							continue;
						
						if (Math.abs(j-i) % 3 == 0) {
							g.setColor(new Color(0XFF2400));
						} else if (Math.abs(j-i) % 3 == 1) {
							g.setColor(Color.CYAN);
						} else if (Math.abs(j-i) % 3 == 2) {
							g.setColor(new Color(0X32CD32));
						}
						
						/*
						if (i % 3 == 0) {
							g.setColor(new Color(0XFF2400));
						} else if (i % 3 == 1) {
							g.setColor(Color.CYAN);
						} else if (i % 3 == 2) {
							g.setColor(new Color(0X32CD32));
						}
						*/

						//g.setColor(Color.decode(randomValue)); // brick color
						/*if(j<3){
							g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
						}
						
						else {
							g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
						}*/
						g.fillRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
						g.setStroke(new BasicStroke(4));
						g.setColor(Color.BLACK);
						g.drawRect(j*brickWidth + 80, i*brickHeight + 50, brickWidth, brickHeight);
					}
				}
				
			}
		}

		
	}
	
	// this sets the value of brick to 0 if it is hit by the ball
	public void setBrickValue(int value, int row, int col) {
		map[row][col] = value;
	}

}

class GamePlay extends JPanel implements KeyListener, ActionListener  {
	private boolean play = true;
	private int score = 0;
	
	private int totalBricks = 28;
	
	private Timer timer;
	private int delay = 10;
	
	private int playerX = 310; // initial x-coordinate of the paddle
	
	private int ballposX = 110;
	private int ballposY = 500;
	private int ballXdir = -2;
	private int ballYdir = -3;

	private int lvl = 1;
	
	private MapGenerator map;
	

	public GamePlay() {
		map = new MapGenerator(4, 7, 540, 200, 1);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
		timer = new Timer(delay, this);
		timer.start();
	}

	public void paint(Graphics g) {
		
		//background color
		g.setColor(Color.lightGray);
		g.fillRect(1, 1, 692, 592);
		
		map.draw((Graphics2D)g);
		
		g.fillRect(0, 0, 3, 592);
		g.fillRect(0, 0, 692, 3);
		g.fillRect(691, 0, 3, 592);
		
		g.setColor(Color.BLUE);
		g.fillRect(playerX, 550, 100, 12);
		
		g.setColor(Color.DARK_GRAY);  // ball color
		g.fillOval(ballposX, ballposY, 20, 20);
		
		g.setColor(Color.black);
		g.setFont(new Font("MV Boli", Font.BOLD, 25));
		g.drawString("Score: " + score, 520, 30);
		
		
		if (totalBricks <= 0) { // if all bricks are destroyed then you win
			play = false;
			ballXdir = 0;
			ballYdir = 0;

			g.setColor(Color.WHITE);
			g.fillOval(160,255,400,130);

			g.setColor(new Color(0XFF6464));
			g.setFont(new Font("MV Boli", Font.BOLD, 30));
			g.drawString("You Won, Score: " + score, 210, 300);
			
			g.setFont(new Font("MV Boli", Font.BOLD, 20));
			g.drawString("Press Enter to Continue to next level", 180, 350);

			lvl=2;
		}
		
		if(ballposY > 570) { // if ball goes below the paddle then you lose 
			play = false;
			ballXdir = 0;
			ballYdir = 0;
			
			g.setColor(Color.WHITE);
			g.fillOval(160,240,400,130);

			g.setColor(Color.RED);
			g.setFont(new Font("MV Boli", Font.BOLD, 30));
			g.drawString("Game Over, Score: " + score, 190, 300);
			
			g.setFont(new Font("MV Boli", Font.BOLD, 20));
			g.drawString("Press Enter to Restart", 230, 350);

			lvl = 1;
				
		} 
		g.dispose();
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {

		int changeX=0;
		int changeY=0;

		timer.start();
		if(play) {
			// Ball - Pedal  interaction 
			if(new Rectangle(ballposX, ballposY, 20, 20).intersects(new Rectangle(playerX, 550, 100, 8))) {
				ballYdir = - ballYdir;
			}

			for( int i = 0; i<map.map.length; i++) { // Ball - Brick interaction
				for(int j = 0; j<map.map[0].length; j++) {  // map.map[0].length is the number of columns
					if(map.map[i][j] > 0) {
						int brickX = j*map.brickWidth + map.brickWidth;
						int brickY = i*map.brickHeight + map.brickHeight;
						int brickWidth= map.brickWidth;
						int brickHeight = map.brickHeight;
						
						Rectangle rect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
						Rectangle ballRect = new Rectangle(ballposX, ballposY, 20,20);
						Rectangle brickRect = rect;
						
						if(ballRect.intersects(brickRect) ) {
							map.setBrickValue(0, i, j);
							totalBricks--;
							score+=5;
							
							if(ballposX + 19 <= brickRect.x || ballposX +1 >= brickRect.x + brickRect.width) {
								changeX = 1 ;
								//ballXdir = -ballXdir;
							}
								
							else {
								changeY = 1 ;
								//ballYdir = -ballYdir;
							}
						}
						
					}
					
				}
			}

			if(changeX==1) {
				ballXdir = -ballXdir;
			}

			if(changeY==1) {
				ballYdir = -ballYdir;
			}
			
			ballposX += ballXdir;
			ballposY += ballYdir;
			if(ballposX < 0) { // if ball hits the left wall then it bounces back
				ballXdir = -ballXdir;
			}
			if(ballposY < 0) {  // if ball hits the top wall then it bounces back
				ballYdir = -ballYdir;
			}
			if(ballposX > 670) { // if ball hits the right wall then it bounces back
				ballXdir = -ballXdir;  
			
			}
			
		}
		
		
		repaint();

	}
	

	@Override
	public void keyTyped(KeyEvent arg0) {
		
	}
	
	@Override
	public void keyPressed(KeyEvent arg0) {
		if(arg0.getKeyCode() == KeyEvent.VK_RIGHT) { // if right arrow key is pressed then paddle moves right
			if(playerX >= 600) {
				playerX = 600;
			} else {
				moveRight();
					
			}
		}
		if(arg0.getKeyCode() == KeyEvent.VK_LEFT) { // if left arrow key is pressed then paddle moves left
			if(playerX < 10) {
				playerX = 10;
			} else {
				moveLeft();
					
			}
		}
		
		if(arg0.getKeyCode() == KeyEvent.VK_ENTER) { // if enter key is pressed then game restarts
			if(!play) {
				
				if(lvl==1) {
					play = true;
					ballposX = 110;
					ballposY = 500;
					ballXdir = -1;
					ballYdir = -2;
					score = 0;
					totalBricks = 28;
					map = new MapGenerator(4,7, 540, 200, 1);
				}
				
				else if(lvl==2) {
					play = true;
					ballposX = 110;
					ballposY = 500;
					ballXdir = -1;
					ballYdir = -2;
					totalBricks = 42;
					map = new MapGenerator(6, 7, 540, 300, 2);
				}

				else if(lvl==3) {
					play = true;
					ballposX = 110;
					ballposY = 500;
					ballXdir = -1;
					ballYdir = -2;
					totalBricks = 42;
					map = new MapGenerator(7, 7, 540, 350, 3);
				}

				repaint();
			}
		}
		
	}	
		
	public void moveRight() { // paddle moves right by 30 pixels
		play = true;
		playerX += 30;
	}
	public void moveLeft() { // paddle moves left by 30 pixels
		play = true;
		playerX -= 30;
	}
		
	

	@Override
	public void keyReleased(KeyEvent arg0) {
		
	}


}

public class Main {

	public static void main(String[] args) {
		JFrame obj = new JFrame();
		GamePlay gamePlay = new GamePlay();
		obj.setBounds(10, 10, 700, 600);
		obj.setTitle("Brick Breaker");
		obj.setResizable(false);
		obj.setVisible(true);
		obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		obj.add(gamePlay);
		
	}

}
