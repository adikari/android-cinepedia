package au.com.subash.cinepedia.util;

public class TmdImage {

  private static final String IMAGE_URL = "https://image.tmdb.org/t/p/w";

  public static String getImageUrl(String imageUrl, int width) {
    return IMAGE_URL + Integer.toString(width) + imageUrl;
  }
}
