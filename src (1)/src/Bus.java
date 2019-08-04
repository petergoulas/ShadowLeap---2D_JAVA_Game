import org.newdawn.slick.Image;
import org.newdawn.slick.Input;

public class Bus extends Sprite {
	
	private static final float SPEED = 1f;
    /** tile size */
    public static final int TILE_SIZE = 48;
    /** screen width, in pixels */
    public static final int SCREEN_WIDTH = 1024;
    /** obstacle's speed */
    public static final double OBSTACLE_SPEED = 0.15;
	private final String name = "Bus";
	private String dir;

	/** imagesrc  */
	public Bus(Image imageSrc, float x, float y) {
		super(imageSrc, x, y);
	}
	
	
	/** update the directions of the busses */
	public void update(Input input, int delta) {
		
		float x = getX();
		float y = getY();
		
		/** check direction and change according to coordinates */
		if (this.dir.equals("left")) {
			if (x < -TILE_SIZE) {
				System.out.println(x);
				setX(SCREEN_WIDTH);
			}
			else {
				setX((float) (x - OBSTACLE_SPEED * delta));
			}
		}
		else {
			if (x > SCREEN_WIDTH) {
				System.out.println(x);
				setX(-TILE_SIZE);
			}
			else {
				setX((float) (x + OBSTACLE_SPEED * delta));
				
			}
		}
	
	}
	/** get image and render */
	public void render() {
		getImage().draw(getX(), getY());
	}
	
	/** get name return name */
	public String getName() {
		return this.name;
	}
	
	/** set direction of bus */
	public void setDirection(String dir) {
		this.dir = dir;
	}
	
}
