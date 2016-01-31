/**
 * 
 */

package com.goeuro.dto;


/**
 * 
 * @author gopalmondal
 * Date: 31-JAN-2016
 */
public class GeoPosition {
	private String latitude;
	private String longitude;

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}

	public String toString() {
		return "GeoPosition [latitude=" + latitude + ", longitude=" + longitude
				+ "]";
	}
}
