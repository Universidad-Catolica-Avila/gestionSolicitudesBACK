package com.ucav.gestionSolicitudesBACK.utils;

public final class Constants {
	private Constants() {
	}

	public static final String PROFILE_PROD = "prod";
	public static final String PROFILE_NOT_PROD = "!" + PROFILE_PROD;
	public static final String PROFILE_HEROKU = "heroku";
	public static final String PROFILE_NOT_HEROKU = "!" + PROFILE_HEROKU;
	public static final String PROFILE_TEST = "test";
	public static final String PROFILE_IT = "integration-test";
	public static final String PROFILE_DOCKER = "docker";

	// API SMOWLS
	public static final String USER_SMOWL = "ESUCAVILA";
	public static final String PASS_SMOWL = "38ca41f2a78f62b0aa4bb02d2b4b3780f53c79d8";
	public static final String API_SMOWL = "https://results-api.smowltech.net/index.php/v2/";
	public static final String API_SMOWL_SETREFERENCEIMAGE = "registers/Images/setReferenceImage";

}