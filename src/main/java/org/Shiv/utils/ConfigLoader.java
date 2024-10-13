package org.Shiv.utils;
import io.github.cdimascio.dotenv.Dotenv;

 public class ConfigLoader {

        // Load the .env file
     private static final Dotenv dotenv = Dotenv.load();
     // Method to fetch the API URL from .env
        public static String getApiUrl() {
            return dotenv.get("GEMINIAI_API_URL");
        }

        // Method to fetch the API key from .env
        public static String getApiKey() {
            return dotenv.get("GEMINIAI_API_KEY");
        }

        // Method to fetch the model from .env
        public static String getModel() {
            return dotenv.get("GEMINI_MODEL");
        }
     public static String getImageApiKey() {
         return dotenv.get("IMAGE_API_KEY");
     }
     public static String getImageApiURL() {
         return dotenv.get("IMAGE_API_URL");
     }
     public static String getVideoApiURL() {
         return dotenv.get("VIDEO_API_URL");
     }
 }
