package assignment2;

import org.geotools.referencing.CRS;
import org.opengis.referencing.FactoryException;
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.crs.CoordinateReferenceSystem;
import org.opengis.referencing.operation.MathTransform;

public class CoordinatesTransformer {

	public static void main (String[] args) {
		
		CoordinateReferenceSystem wgs84 = null;
		try {
			wgs84 = CRS.decode("EPSG:4326", true);
		} catch (NoSuchAuthorityCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		CoordinateReferenceSystem utm33 = null;
		try {
			utm33 = CRS.decode("EPSG:32633", true);
		} catch (NoSuchAuthorityCodeException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			MathTransform wgs84Toutm33n = CRS.findMathTransform(wgs84, utm33);
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}//main
}//class
