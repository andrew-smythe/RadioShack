
public class Space {
 private final Quadrant quadrant[][] = new Quadrant[SpaceConfig.SPACE_SIZE][SpaceConfig.SPACE_SIZE];

/**
 * @return the quadrant
 */
public Quadrant[][] getQuadrant() {
	return quadrant;
}
/**
 * static Singleton instance
 */
private static Space instance;

/**
 * Private constructor for singleton
 */
private Space() {
}

/**
 * Static getter method for retrieving the singleton instance
 */
public static Space getInstance() {
	if (instance == null) {
		instance = new Space();
	}
	return instance;
}
 
}