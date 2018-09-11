package leet.a;

import java.util.HashMap;
import java.util.Map;

public class Q535_EncodeAndDecodeTinyURL {
    Map<Integer, String> dictMap = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        dictMap.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        return dictMap.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }
}
