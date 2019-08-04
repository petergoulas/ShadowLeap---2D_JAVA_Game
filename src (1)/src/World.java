import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.gui.GUIContext;

import java.lang.Math;
import java.util.ArrayList;
public class World {
	
	/** create images */
	private Image image;
	private Image grassImage;
	private Image frogImage;
	private Image busImage;
	
	private Player frog;
	private Bus bus;
	
	/** constants */
    /** lane one of busses starting y position */
    public static final int LANE_ONE_Y= 432;
    /** lane two of busses starting y position */
    public static final int LANE_TWO_Y= 480;
    /** lane three of busses starting y position */
    public static final int LANE_THREE_Y = 528;
    /** lane four of busses starting y position */
    public static final int LANE_FOUR_Y = 576;
    /** lane four of busses starting y position */
    public static final int LANE_FIVE_Y = 624;
    /** lane four of busses starting x position */
    public static final int LANE_THREE_X = 64;
    /** lane four of busses starting x position */
    public static final int LANE_FOUR_X = 128;
    /** lane five of busses starting x position */
    public static final int LANE_FIVE_X = 250;
    /** lane two and four separation times */
    public static final int SEP_TIMES_2_4 = 5;
    /** lane three separation times */
    public static final int SEP_TIMES_3 = 12;
    /** frog starting x position */
    public static final int FROG_START_X = 512;
    /** frog starting y position */
    public static final int FROG_START_Y = 720;
    /** water start */
    public static final int WATER_START = 336;
    /** grass start 1 */
    public static final int GRASS_START_1 = 384;
    /** grass start 2 */
    public static final int GRASS_START_2 = 672;
    
    /** lane one and five separation times */
    public static final double SEP_TIMES_1_5 = 6.5;
    
    /** initialize doubles */
	private double sep1  = SEP_TIMES_1_5 * App.TILE_SIZE;
	private double sep2 = SEP_TIMES_2_4 * App.TILE_SIZE;
	private double sep3 = SEP_TIMES_3 * App.TILE_SIZE;
	private double sep4 = SEP_TIMES_2_4 * App.TILE_SIZE;
	private double sep5 = SEP_TIMES_1_5 * App.TILE_SIZE;
	
	/** assign values to starting position of frog */
	private float frogPositionX = FROG_START_X;
	private float frogPositionY = FROG_START_Y;
	
	
	/** assign values to bus lanes coordinates */
	private float busPositionX1 = App.TILE_SIZE;
	private float busPositionY1 = LANE_ONE_Y;
	
	private float busPositionX2 = 0;
	private float busPositionY2 = LANE_TWO_Y;
	
	private float busPositionX3 = LANE_THREE_X;
	private float busPositionY3 = LANE_THREE_Y;
	
	private float busPositionX4 = LANE_FOUR_X;
	private float busPositionY4 = LANE_FOUR_Y;
	
	private float busPositionX5 = LANE_FIVE_X;
	private float busPositionY5 = LANE_FIVE_Y;
	
	
	/** create new arraylist bus */
	private ArrayList<Bus> busses = new ArrayList<Bus>();
	
	public World() {
		/** Perform initialisation logic  for later */
	}
	
	 /** load new images */
	 public void init(GameContainer gc)
	            throws SlickException {
		 image = new Image("assets/water.png");
		 grassImage = new Image("assets/grass.png");
		 frogImage = new Image("assets/frog.png");
		 busImage = new Image("assets/bus.png");
		frog = new Player(frogImage, frogPositionX,frogPositionY);
		
		/** lane 1 show the busses */
		while (busPositionX1 <= App.SCREEN_WIDTH) {
			bus = new Bus(busImage, busPositionX1, busPositionY1);
			bus.setDirection("left");
			busses.add(bus);  // Add bus object into the arraylist
			busPositionX1 += sep1;
		}
		
		/** lane 2 show the busses */
		while (busPositionX2 <= App.SCREEN_WIDTH) {
			bus = new Bus(busImage, busPositionX2, busPositionY2);
			bus.setDirection("right");
			busses.add(bus);  // Add bus object into the arraylist
			busPositionX2 += sep2;
		}
		
		/** lane 3 show the busses */
		while (busPositionX3 <= App.SCREEN_WIDTH) {
			bus = new Bus(busImage, busPositionX3, busPositionY3);
			bus.setDirection("left");
			busses.add(bus);  // Add bus object into the arraylist
			busPositionX3 += sep3;
		}
		
		/** lane 4 show the busses */
		while (busPositionX4 <= App.SCREEN_WIDTH) {
			bus = new Bus(busImage, busPositionX4, busPositionY4);
			bus.setDirection("right");
			busses.add(bus);  // Add bus object into the arraylist
			busPositionX4 += sep4;
		}
		
		/** lane 5 show the busses */
		while (busPositionX5 <= App.SCREEN_WIDTH) {
			bus = new Bus(busImage, busPositionX5, busPositionY5);
			bus.setDirection("left");
			busses.add(bus);  // Add bus object into the arraylist
			busPositionX5 += sep5;
		}
	 }
	 
	/** update position and check if frog is killed by a bus */
	public void update(Input input, int delta) {
		for (Bus bus : busses) {
			if (Math.abs(frog.getX() - bus.getX()) < App.TILE_SIZE && Math.abs(frog.getY() - bus.getY()) < App.TILE_SIZE) {
			/* killed by the bus */
				System.exit(0);
			}
			/** update bus */
			bus.update(input, delta);
		}
		/** update frog */
		frog.update(input, delta);	
	}
	
	/** render graphics */
	public void render(Graphics g) throws SlickException {
		renderBackground(g);
		
		/** good command to check where the frog is. Keeping it for the next phase of the project */
		//g.drawString("Frog's position: X: " +  frogPositionX + "\nFrog's Position Y: "+ frogPositionY,  400,20);
		
		/** frog render */
		frog.render();
		
		/** render busses */
		for (Bus bus : busses) {
			bus.render();
		}
	}
	
	/** render background graphics */
	private void renderBackground(Graphics g) {
		float i,k;
		
		/** loop for the water tiles */
		for (i=App.TILE_SIZE; i<=WATER_START; i+=App.TILE_SIZE) {
			for (k=0; k<=App.SCREEN_WIDTH; k+=App.TILE_SIZE) {
				g.drawImage(image, k, i);
			}
		}
		
		 /** loops for grass tiles */
		for (i=GRASS_START_1; i<=GRASS_START_1; i+=App.TILE_SIZE) {
			for (k=0; k<=App.SCREEN_WIDTH; k+=App.TILE_SIZE) {
				g.drawImage(grassImage, k, i);
			}
		}
		for (i=GRASS_START_2; i<=GRASS_START_2; i+=App.TILE_SIZE) {
			for (k=0; k<=App.SCREEN_WIDTH; k+=App.TILE_SIZE) {
				g.drawImage(grassImage, k, i);
			}
		}
	}
}
