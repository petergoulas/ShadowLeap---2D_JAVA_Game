import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Sprite {
	
	private Image image;
	private float x;
	private float y;
	
	/** constructor */
	public Sprite(Image imageSrc, float x, float y) {
		this.image = imageSrc;
		this.x = x;
		this.y = y;
	}
		
		public void update(Input input, int delta) {
		}
	
	/** draw the image centered */
	public void render() {
		image.drawCentered(x,y);
	}
	
	/** Should be called when one sprite makes contact with another. not used now */
	public void contactSprite(Sprite other) {
	}
	
	/** get image */
	public Image getImage() {
		return image;
	}
	
	/** set image */
	public void setImage(Image image) {
		this.image = image;
	}
	
	/** getter for X */
	public float getX() {
		return x;
	}

	/** setter for x */
	public void setX(float x) {
		this.x = x;
	}
	
	/** getter for y */
	public float getY() {
		return y;
	}
	
	/** setter for y */
	public void setY(float y) {
		this.y = y;
	}
}
