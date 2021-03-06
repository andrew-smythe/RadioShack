package gameObjects;

import settings.Configs;
import board.*;

/**
 * The Jovian Command Cruiser which can move changing its direction randomly
 * every turn and saps the ship's power.
 * @author Laurens van Wingerden, Vitalii Egorchatov
 */
public class JovianCommandCruiser 
	extends JovianWarship{

	/**
	 * REQUIRES: The Jovian's current sector and the ship as a target.
	 * MODIFIES: This.
	 * EFFECTS: Creates an instance of Jovian Command Cruiser and puts it into a sector;
	 * sets the cruiser's label and initial speed; passes the ship as a target.
	 * @param sector The current Jovian Command Cruiser's sector.
	 * @param ship The reference to the ship.
	 */
	public JovianCommandCruiser(Sector sector, Ship ship) {
		super(sector, ship);
		label = Configs.JCC;
	}
	
	/**
	 * PURPOSE: This has been hit by other SpaceObject so it destroys itself 
	 * if the object is an Antimatter Pod and object's bumped() called so that they can 
	 * deal with this particular impact;
	 * EFFECTS: Destroys the command cruiser only by an Antimatter Pod.
	 * @param object The object that collided with this.
	 */
	@Override
	public void bump(SpaceObject object) {
		object.bumped(this);
		if(object instanceof AntimatterPod){
			selfDestruct();
		}
	}
	
	/**
	 * PURPOSE: Nothing happens because this.move() doesn't allow to bump into anything.
	 * @param object The object that collided with this.
	 */
	@Override
	public void bumped(SpaceObject object) {
		
	}	
}

