package com.example.suthayakumar.testapputhaya.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class SessionDataManager {

	private static final String SHAREDPREF_NAME = "intent";

	public static final String[] catalogKeys = {"Adresse", "Tél1", "Tél2", "Heure de passage",
			"Indice coordonnées", "Club Thiriet"};

	private static final String[] CLIENT10 = {"12547", "00:00\n00:00", "GROBON Delphine", "V", "31 AVENUE DES STE CROIX\n01120 DAGNEUX", "04 78 06 25 48", "04 78 06 25 42", "00:00-00:00", "5", "37pt-1.85€", "12/2018"};
	private static final String[] CLIENT11 = {"45873", "00:00\n00:00", "PARCEL Daniel", "A", "10 CHEMIN DES PRÉS SEIGNEUR\n01120 MONTLUEL", "04 78 06 25 48", "04 78 06 25 42", "00:00-00:00", "5", "20pt-1.00€", "12/2018"};
	private static final String[] CLIENT12 = {"98562", "00:00\n00:00", "VALLEE Nelly", "V", "25 RUE DES MARAIS\n01120 LA BOISSE", "04 78 06 17 57", null, "00:00-00:00", "5", "67pt-3.35€", "12/2018"};
	private static final String[] CLIENT13 = {"58632", "00:00\n00:00", "KOLLY Edith", "A", "3 RUE DE LA FABRIQUE\n01120 MONTLUEL", "04 78 06 55 13", null, "00:00-00:00", "5", "61pt-3.05€", "12/2018"};
	private static final String[] CLIENT14 = {"36474", "00:00\n00:00", "GAILLARD Monique", "A", "7 LE COTEAU DES PRÉS\n01120 DAGNEUX", "04 72 25 90 17", null, "00:00-00:00", "5", "46pt-2.30€", "12/2018"};
	private static final String[] CLIENT15 = {"36564", "00:00\n00:00", "CANTIN Basile", "V", "17 BOULEVARD DES PRÉS\n01120 MONTLUEL", "04 84 35 90 87", null, "00:00-00:00", "5", "25pt-1.50€", "12/2018"};
	private static final String[] CLIENT16 = {"58631", "00:00\n00:00", "PIGUILLEM Jean", "L", "168 RUE DE L'EGLISE\n01120 THIL", "04 78 06 55 47", null, "00:00-00:00", "5", "113pt-5.65€", "12/2018"};
	private static final String[] CLIENT17 = {"36274", "00:00\n00:00", "SÉRIÉ Gérard", "L", "7 LOT DE PETIT BOIS\n01120 LA BOISSE", "06 84 15 78 32", null, "00:00-00:00", "5", "46pt-2.30€", "12/2018"};
	private static final String[] CLIENT18 = {"11784", "00:00\n00:00", "MARDINIAN Grégoire", "L", "354 RUE DU CANAL\n01120 THIL", "07 84 01 00 34", null, "00:00-00:00", "5", "234pt-11.70€", "12/2018"};


	public static final String[][] catalog = {CLIENT10, CLIENT11, CLIENT12, CLIENT11, CLIENT12,
			CLIENT13, CLIENT14, CLIENT15, CLIENT16, CLIENT17, CLIENT18};

	public static final String CLIENT_ID = "clientId";

	private SharedPreferences sharedPreferences;

	private SessionDataManager() {
		sharedPreferences = DataManager.getContext().getSharedPreferences(SHAREDPREF_NAME, Context.MODE_PRIVATE);
	}

	private static class Holder {
		private final static SessionDataManager instance = new SessionDataManager();
	}

	public static SessionDataManager getInstance() {
		return Holder.instance;
	}

	public void save(String key, int val){
		Log.d(SessionDataManager.class.getName(), "- key : "+ key + " / value : "+ val);
		sharedPreferences.edit().putInt(key, val).apply();
	}

	public String getString(String key){
		return sharedPreferences.getString(key, null);
	}

	public int getInt(String key){
		return sharedPreferences.getInt(key, -1);
	}

	public void reset(){
		sharedPreferences.edit().clear().apply();
	}
}
