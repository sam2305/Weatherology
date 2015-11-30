package com.weatherology.services.users;


/** Favorite class contains all favorite information
 * @author Musa V. Ahmed
 */
public class Favorite{
	/** Nickname for favorite */
	protected String name;
	/** Five digit zip code */
	protected int zip;

	/** Constructor for Favorite initialized name and zip
	 * @param name Nickname for favorite
	 * @param zip Zip code of favorite
	 */
	public Favorite(String name, int zip) {
		this.name = name;
		this.zip = zip;
	}
	
	/** Returns nickname of favorite
	 * @return name String of favorite name
	 */
	public String getName() {
		return this.name;
	}
	
	/** Returns zip of favorite
	 * @return zip Five digit zip code of favorite
	 */
	public int getZip() {
		return this.zip;
	}
	
	/** Sets nickname of favorite
	 * @param name String of favorite name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/** Sets zip fo favorite
	 * @param zip Five digit zip code of favorite
	 */
	public void setZip(int zip) {
		this.zip = zip;
	}
	
	public boolean equals(Object obj) {
		if (! (obj instanceof Favorite))
			return false;
		
		Favorite favorite = (Favorite) obj;
		if (this.name.equals(favorite.name) &&
			this.zip == favorite.zip)
			return true;
		
		return false;
	}
}
