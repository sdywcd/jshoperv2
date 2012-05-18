package com.jshop.android.location;

import java.util.ArrayList;

import android.graphics.drawable.Drawable;

import com.google.android.maps.ItemizedOverlay;
import com.google.android.maps.OverlayItem;

public class JshopItemizedOverlay extends ItemizedOverlay{
	private ArrayList<OverlayItem> mOverlays = new ArrayList<OverlayItem>();
	public JshopItemizedOverlay(Drawable defaultMarker){
		super(boundCenterBottom(defaultMarker));
	}
	public void addOverlay(OverlayItem overlay){
		mOverlays.add(overlay);
		populate();
	}
	@Override
	protected OverlayItem createItem(int i){
		return mOverlays.get(i);
	}
	@Override
	public int size(){
		return mOverlays.size();
	}
}
