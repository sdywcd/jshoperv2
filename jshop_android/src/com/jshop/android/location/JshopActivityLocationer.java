package com.jshop.android.location;

import java.util.List;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.ZoomControls;

import com.google.android.maps.GeoPoint;
import com.google.android.maps.MapActivity;
import com.google.android.maps.MapController;
import com.google.android.maps.MapView;
import com.google.android.maps.Overlay;
import com.google.android.maps.OverlayItem;
import com.jshop.android.index.R;

public class JshopActivityLocationer extends MapActivity{
	private MapView mapView;
	private ZoomControls mZoom;
	private LocationManager locationManager;
	
	private List<Overlay> mapOverlays;
	private Drawable drawable;
	private JshopItemizedOverlay itemizedOverlay;
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.jshop_activity_locate);
		mapView = (MapView)findViewById(R.id.mapview);
		mZoom = (ZoomControls) mapView.getZoomControls();
		MapController controller = mapView.getController();
		GeoPoint point = locate(controller);
		
		mapOverlays = mapView.getOverlays();
		drawable = this.getResources().getDrawable(R.drawable.icon);
		mapOverlays = mapView.getOverlays();
		itemizedOverlay = new JshopItemizedOverlay(drawable);
		OverlayItem overlayitem = new OverlayItem(point,"","");
		
		itemizedOverlay.addOverlay(overlayitem);
		mapOverlays.add(itemizedOverlay);
	}
	
	@Override
	protected boolean isRouteDisplayed(){
		return false;
	}
	
	 private final LocationListener locationListener = new LocationListener()
	    {
	        public void onLocationChanged(Location location)
	        {
	           // updateWithNewLocation(location);
	        }

	        public void onProviderDisabled(String provider)
	        {
	           // updateWithNewLocation(null);
	        }

	        public void onProviderEnabled(String provider)
	        {

	        }

	        public void onStatusChanged(String provider, int status, Bundle extras)
	        {

	        }
	    };
	
	private GeoPoint locate(MapController controller){
		locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
		String provider = LocationManager.GPS_PROVIDER;
		Location location = locationManager.getLastKnownLocation(provider);
		double lat=0.0;
		double lng=0.0;
		while(location == null){
			locationManager.requestLocationUpdates(provider, 1000, 1, locationListener); 
		}
		if(location != null){
			lat = location.getLatitude();
			lng = location.getLongitude();
		}
		GeoPoint point = new GeoPoint((int) (lat * 1E6),(int) (lng * 1E6));
		controller.animateTo(point);
		return point;
	}
}
