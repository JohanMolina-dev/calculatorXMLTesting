package co.com.sofka.testing.data;

public class BodyXML {
    public BodyXML() {
    }

    public String bodyXML(int pParam1, int pParam2){
        return  "<soapenv:Envelope xmlns:soapenv=" +
                "\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:tem=\"http://tempuri.org/\"> " +
                "<soapenv:Header/> <soapenv:Body> " +
                "<tem:Add> <tem:intA>" + pParam1 + "</tem:intA> " +
                "<tem:intB>" + pParam2 + "</tem:intB> </tem:Add> " +
                "</soapenv:Body> </soapenv:Envelope>";
    }
}
