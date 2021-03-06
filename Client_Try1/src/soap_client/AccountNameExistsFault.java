
package soap_client;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.9-b130926.1035
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "AccountNameExistsException", targetNamespace = "http://service/")
public class AccountNameExistsFault
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private AccountNameExistsException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public AccountNameExistsFault(String message, AccountNameExistsException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public AccountNameExistsFault(String message, AccountNameExistsException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: soap_client.AccountNameExistsException
     */
    public AccountNameExistsException getFaultInfo() {
        return faultInfo;
    }

}
