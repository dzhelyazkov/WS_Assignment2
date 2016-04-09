
package soap_client;

import java.net.MalformedURLException;
import java.net.URL;
import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import javax.xml.ws.WebEndpoint;
import javax.xml.ws.WebServiceClient;
import javax.xml.ws.WebServiceException;
import javax.xml.ws.WebServiceFeature;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebServiceClient(name = "AccountServiceService", targetNamespace = "http://service/", wsdlLocation = "http://localhost:8080/WS_Ass_try3_war_exploded/AccountServiceService?wsdl")
public class AccountServiceService
    extends Service
{

    private final static URL ACCOUNTSERVICESERVICE_WSDL_LOCATION;
    private final static WebServiceException ACCOUNTSERVICESERVICE_EXCEPTION;
    private final static QName ACCOUNTSERVICESERVICE_QNAME = new QName("http://service/", "AccountServiceService");

    static {
        URL url = null;
        WebServiceException e = null;
        try {
            url = new URL("http://localhost:8080/WS_Ass_try3_war_exploded/AccountServiceService?wsdl");
        } catch (MalformedURLException ex) {
            e = new WebServiceException(ex);
        }
        ACCOUNTSERVICESERVICE_WSDL_LOCATION = url;
        ACCOUNTSERVICESERVICE_EXCEPTION = e;
    }

    public AccountServiceService() {
        super(__getWsdlLocation(), ACCOUNTSERVICESERVICE_QNAME);
    }

    public AccountServiceService(WebServiceFeature... features) {
        super(__getWsdlLocation(), ACCOUNTSERVICESERVICE_QNAME, features);
    }

    public AccountServiceService(URL wsdlLocation) {
        super(wsdlLocation, ACCOUNTSERVICESERVICE_QNAME);
    }

    public AccountServiceService(URL wsdlLocation, WebServiceFeature... features) {
        super(wsdlLocation, ACCOUNTSERVICESERVICE_QNAME, features);
    }

    public AccountServiceService(URL wsdlLocation, QName serviceName) {
        super(wsdlLocation, serviceName);
    }

    public AccountServiceService(URL wsdlLocation, QName serviceName, WebServiceFeature... features) {
        super(wsdlLocation, serviceName, features);
    }

    /**
     * 
     * @return
     *     returns AccountService
     */
    @WebEndpoint(name = "AccountServicePort")
    public AccountService getAccountServicePort() {
        return super.getPort(new QName("http://service/", "AccountServicePort"), AccountService.class);
    }

    /**
     * 
     * @param features
     *     A list of {@link javax.xml.ws.WebServiceFeature} to configure on the proxy.  Supported features not in the <code>features</code> parameter will have their default values.
     * @return
     *     returns AccountService
     */
    @WebEndpoint(name = "AccountServicePort")
    public AccountService getAccountServicePort(WebServiceFeature... features) {
        return super.getPort(new QName("http://service/", "AccountServicePort"), AccountService.class, features);
    }

    private static URL __getWsdlLocation() {
        if (ACCOUNTSERVICESERVICE_EXCEPTION!= null) {
            throw ACCOUNTSERVICESERVICE_EXCEPTION;
        }
        return ACCOUNTSERVICESERVICE_WSDL_LOCATION;
    }

}
