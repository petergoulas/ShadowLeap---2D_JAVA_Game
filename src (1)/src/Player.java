import org.newdawn.slick.*;

public class Player extends Sprite {
	/** constants */
    /** tile size */
    public static final int TILE_SIZE = 48;
    /** water's location */
    public static final int WATER_LOCATION = 336;
    /** speed of player */
	private static final float SPEED = 1f;
	private final String name = "Player";
	
	/** image src x and y constract */
	public Player(Image imageSrc, float x, float y) {
		super(imageSrc, x, y);
	}
	
	
	/** if it touches water then stop the game */
	public void update(Input input, int delta) {
		/** get x and y */
		float x = getX();
		float y = getY();
		
		/** if it touches water stop the game */
		if (input.isKeyDown(Input.KEY_ESCAPE)) {
			System.exit(0);
		}
		
		/** use arrow keys to determine what is happening to the frog */
		if (input.isKeyPressed(Input.KEY_UP)) {
			/** if the frog hits the water, EXIT */
			if (y-TILE_SIZE == WATER_LOCATION) {
				System.exit(0);
			} else {
				setY(y- TILE_SIZE * SPEED); 
			}
		}
		
		/** use arrow keys to determine what is happening to the frog */
		if (input.isKeyPressed(Input.KEY_DOWN)) {
			setY(y+ TILE_SIZE * SPEED);
		}
		if (input.isKeyPressed(Input.KEY_LEFT)) {
			setX(x- TILE_SIZE * SPEED);
			
		}
		if (input.isKeyPressed(Input.KEY_RIGHT)) {
			setX(x + TILE_SIZE * SPEED);
		}
		
		/** Restrictions for x */
		if (getX() < 0) {
			setX(0);
		}
		if (getX() > (App.SCREEN_WIDTH - TILE_SIZE)) {
			setX(App.SCREEN_WIDTH - TILE_SIZE);
		}
		
		/** restrictions for y */
		if (getY() < 0) {
			setY(0);
		}
		if (getY() > App.SCREEN_HEIGHT - TILE_SIZE) {
			setY(App.SCREEN_HEIGHT - TILE_SIZE);
		}
	}
	/** render  get image and draw */
	public void render() {
		getImage().draw(getX(), getY());
	}
	
}
