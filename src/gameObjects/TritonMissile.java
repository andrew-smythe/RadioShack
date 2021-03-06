package gameObjects;
import settings.Configs;
//import board.Quadrant;
import board.Sector;

/**
 * The Triton Missile weapon which can move straight and whether bump an object or get out of bounds.
 * @author Laurens van Wingerden, Vitalii Egorchatov
 */
public class TritonMissile 
	extends Weapon {
	
	/**
	 * REQUIRES: The ship's current sector and the direction of the shoot.
	 * MODIFIES: This.
	 * EFFECTS: Creates an instance of a missile and puts it into a sector
	 * next to the ship depending on the direction of the shot; sets the missile's label
	 * and initial direction and speed.
	 * @param sector The current ship's sector.
	 * @param direction The direction of the shot.
	 */
	public TritonMissile(Sector sector, int direction){
		super(sector, direction);
		label = Configs.TRT_MSSL;
	}
	
	/**
	 * MODIFIES: This. The missile's current sector or destroy the missile if it bumped something.
	 * EFFECTS: Checks what is in the next sector; destroys the missile if it has reached 
	 * the quadrant border; puts the missile into the next sector if it's empty; 
	 * bumps the object in the next sector if the next sector contains any.
	 */
	public void move(){
		Sector nextSector = quadrant.getNext(sector, velocity[0]);	
		if(nextSector == null){
			selfDestruct();
		} else {
			SpaceObject object = nextSector.getInhabitant();
			if(object != null) {
				object.bump(this);
			} else {
				setSector(nextSector);
			}
		} 		
	}
	
	/**
	 * PURPOSE: This has been hit by other SpaceObject so it destroys itself and object's 
	 * bumped() called so that they can deal with this particular impact
	 * EFFECTS: Destroys the missile.
	 * @param object The object that collided with this.
	 */
	@Override
	public void bump(SpaceObject object) {
		object.bumped(this);
		selfDestruct();
	}
	
	/**
	 * PURPOSE: A feedback message from the object this has collided with.
	 * EFFECTS: Destroys the missile;
	 * @param object The object that collided with this.
	 */
	@Override
	public void bumped(SpaceObject object) {
		selfDestruct();
	}
	
	
}
