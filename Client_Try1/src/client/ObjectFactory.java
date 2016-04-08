
package client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the client package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _RegisterResponse_QNAME = new QName("http://service/", "registerResponse");
    private final static QName _AccountNameExistsException_QNAME = new QName("http://service/", "AccountNameExistsException");
    private final static QName _InvalidAccountParameterException_QNAME = new QName("http://service/", "InvalidAccountParameterException");
    private final static QName _Register_QNAME = new QName("http://service/", "register");
    private final static QName _Account_QNAME = new QName("http://service/", "account");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: client
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link AccountNameExistsException }
     * 
     */
    public AccountNameExistsException createAccountNameExistsException() {
        return new AccountNameExistsException();
    }

    /**
     * Create an instance of {@link RegisterResponse }
     * 
     */
    public RegisterResponse createRegisterResponse() {
        return new RegisterResponse();
    }

    /**
     * Create an instance of {@link Account }
     * 
     */
    public Account createAccount() {
        return new Account();
    }

    /**
     * Create an instance of {@link InvalidAccountParameterException }
     * 
     */
    public InvalidAccountParameterException createInvalidAccountParameterException() {
        return new InvalidAccountParameterException();
    }

    /**
     * Create an instance of {@link Register }
     * 
     */
    public Register createRegister() {
        return new Register();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RegisterResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "registerResponse")
    public JAXBElement<RegisterResponse> createRegisterResponse(RegisterResponse value) {
        return new JAXBElement<RegisterResponse>(_RegisterResponse_QNAME, RegisterResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountNameExistsException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "AccountNameExistsException")
    public JAXBElement<AccountNameExistsException> createAccountNameExistsException(AccountNameExistsException value) {
        return new JAXBElement<AccountNameExistsException>(_AccountNameExistsException_QNAME, AccountNameExistsException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link InvalidAccountParameterException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "InvalidAccountParameterException")
    public JAXBElement<InvalidAccountParameterException> createInvalidAccountParameterException(InvalidAccountParameterException value) {
        return new JAXBElement<InvalidAccountParameterException>(_InvalidAccountParameterException_QNAME, InvalidAccountParameterException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Register }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "register")
    public JAXBElement<Register> createRegister(Register value) {
        return new JAXBElement<Register>(_Register_QNAME, Register.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Account }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "account")
    public JAXBElement<Account> createAccount(Account value) {
        return new JAXBElement<Account>(_Account_QNAME, Account.class, null, value);
    }

}
