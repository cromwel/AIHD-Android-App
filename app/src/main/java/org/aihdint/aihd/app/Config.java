package org.aihdint.aihd.app;

/**
 * Developed by Rodney on 19/01/2018.
 */
public class Config {
    // File upload url (replace the ip with your server address)
    //public static final String FILE_UPLOAD_URL = "http://45.79.130.91:5050/file_upload.php";
    public static final String FILE_UPLOAD_URL = "http://45.79.145.240/file_upload.php";
    public static  final  String LOGIN_URL = "http://45.79.145.240:8080/ems/ws/rest/v1/session";
    public static  final  String PATIENT_REGISTER_URL = "http://45.79.145.240/api/patient/register";
    public static  final  String LOCATIONS_URL = "http://45.79.145.240/api/locations";

    // Directory name to store captured images and videos
    public static final String IMAGE_DIRECTORY_NAME = "AIHD";
}
