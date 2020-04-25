package helpers;

import java.util.HashMap;
import java.util.Map;

public class Headers {
    public Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put("accept", "*/*");
        headers.put("accept-language", "ru,uk;q=0.9,en-GB;q=0.8,en;q=0.7");
        headers.put("sec-fetch-dest", "empty");
        headers.put("sec-fetch-mode", "cors");
        headers.put("sec-fetch-site", "same-site");
        return headers;
    }
}
