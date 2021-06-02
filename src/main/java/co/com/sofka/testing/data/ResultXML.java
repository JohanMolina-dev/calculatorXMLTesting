package co.com.sofka.testing.data;

import org.json.JSONObject;

public class ResultXML {
    public ResultXML() {
    }

    public String resultXml(JSONObject xmlJSONObj) {
        return xmlJSONObj.getJSONObject("soap:Envelope")
                .getJSONObject("soap:Body")
                .getJSONObject("AddResponse")
                .get("AddResult").toString();
    }
}
