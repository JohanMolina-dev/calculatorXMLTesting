package co.com.sofka.testing.data;

import java.util.HashMap;

public class HeadersXML {
    public HeadersXML() {
    }

    public HashMap<String, Object> placeHeader(String path) {
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("Content-Type", "text/xml;charset=UTF-8");
        headers.put("SOAPAction", path);
        return headers;
    }
}
