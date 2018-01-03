package assignment2;

import org.geotools.geometry.jts.JTS; //for JTS.transform method
import org.geotools.geometry.jts.JTSFactoryFinder; //for JTS.FactoryFinder method
import org.geotools.referencing.CRS; //for CRS methods
import org.opengis.referencing.crs.CoordinateReferenceSystem; //for defining CRS
import org.opengis.referencing.operation.MathTransform; //for CRS transform function
import org.opengis.referencing.FactoryException; 
import org.opengis.referencing.NoSuchAuthorityCodeException;
import org.opengis.referencing.operation.TransformException;
import com.vividsolutions.jts.geom.Coordinate; //for reading coordinate
import com.vividsolutions.jts.geom.Point; //for creating point

public class CoordinatesTransformer {

	public static void main (String[] args) throws TransformException {
		
		/* 
		 * We used method from CRS class that return a Coordinate Reference System 
		 * for the specified code to created variable. That way we have defined CRS 
		 * with name, that we need for transformation
		*/
		
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
		
		/*
		 * ready short code that change source CRS into target CRS
		 */
		
		MathTransform wgs84Toutm33n = null;
		try {
			wgs84Toutm33n = CRS.findMathTransform(wgs84, utm33);
		} catch (FactoryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		com.vividsolutions.jts.geom.GeometryFactory jtsGf = JTSFactoryFinder.getGeometryFactory();
		
		//create point with define variable from assignment
		Point pointInWgs84 = (Point) jtsGf.createPoint(new Coordinate(13.060209, 47.788901));
		
		//transform point from original CRS into new one through created function wgs84Toutm33n
		Point pointInUtm33n = (Point) JTS.transform(pointInWgs84, wgs84Toutm33n);
		
		System.out.println(pointInUtm33n);
	}//main
}//class
