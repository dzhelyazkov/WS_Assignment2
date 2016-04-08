
package soap_client;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the soap_client package. 
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

    private final static QName _LoginResponse_QNAME = new QName("http://service/", "loginResponse");
    private final static QName _AccountNameExistsException_QNAME = new QName("http://service/", "AccountNameExistsException");
    private final static QName _Delete_QNAME = new QName("http://service/", "delete");
    private final static QName _Login_QNAME = new QName("http://service/", "login");
    private final static QName _Save_QNAME = new QName("http://service/", "save");
    private final static QName _RegisterResponse_QNAME = new QName("http://service/", "registerResponse");
    private final static QName _DeleteResponse_QNAME = new QName("http://service/", "deleteResponse");
    private final static QName _AccountVerificationException_QNAME = new QName("http://service/", "AccountVerificationException");
    private final static QName _AccountDoesNotExistException_QNAME = new QName("http://service/", "AccountDoesNotExistException");
    private final static QName _InvalidAccountParameterException_QNAME = new QName("http://service/", "InvalidAccountParameterException");
    private final static QName _Register_QNAME = new QName("http://service/", "register");
    private final static QName _Account_QNAME = new QName("http://service/", "account");
    private final static QName _SaveResponse_QNAME = new QName("http://service/", "saveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: soap_client
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
     * Create an instance of {@link LoginResponse }
     * 
     */
    public LoginResponse createLoginResponse() {
        return new LoginResponse();
    }

    /**
     * Create an instance of {@link Save }
     * 
     */
    public Save createSave() {
        return new Save();
    }

    /**
     * Create an instance of {@link Login }
     * 
     */
    public Login createLogin() {
        return new Login();
    }

    /**
     * Create an instance of {@link Delete }
     * 
     */
    public Delete createDelete() {
        return new Delete();
    }

    /**
     * Create an instance of {@link AccountDoesNotExistException }
     * 
     */
    public AccountDoesNotExistException createAccountDoesNotExistException() {
        return new AccountDoesNotExistException();
    }

    /**
     * Create an instance of {@link AccountVerificationException }
     * 
     */
    public AccountVerificationException createAccountVerificationException() {
        return new AccountVerificationException();
    }

    /**
     * Create an instance of {@link DeleteResponse }
     * 
     */
    public DeleteResponse createDeleteResponse() {
        return new DeleteResponse();
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
     * Create an instance of {@link SaveResponse }
     * 
     */
    public SaveResponse createSaveResponse() {
        return new SaveResponse();
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
     * Create an instance of {@link JAXBElement }{@code <}{@link LoginResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "loginResponse")
    public JAXBElement<LoginResponse> createLoginResponse(LoginResponse value) {
        return new JAXBElement<LoginResponse>(_LoginResponse_QNAME, LoginResponse.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link Delete }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "delete")
    public JAXBElement<Delete> createDelete(Delete value) {
        return new JAXBElement<Delete>(_Delete_QNAME, Delete.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Login }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "login")
    public JAXBElement<Login> createLogin(Login value) {
        return new JAXBElement<Login>(_Login_QNAME, Login.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Save }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "save")
    public JAXBElement<Save> createSave(Save value) {
        return new JAXBElement<Save>(_Save_QNAME, Save.class, null, value);
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
     * Create an instance of {@link JAXBElement }{@code <}{@link DeleteResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "deleteResponse")
    public JAXBElement<DeleteResponse> createDeleteResponse(DeleteResponse value) {
        return new JAXBElement<DeleteResponse>(_DeleteResponse_QNAME, DeleteResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountVerificationException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "AccountVerificationException")
    public JAXBElement<AccountVerificationException> createAccountVerificationException(AccountVerificationException value) {
        return new JAXBElement<AccountVerificationException>(_AccountVerificationException_QNAME, AccountVerificationException.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link AccountDoesNotExistException }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "AccountDoesNotExistException")
    public JAXBElement<AccountDoesNotExistException> createAccountDoesNotExistException(AccountDoesNotExistException value) {
        return new JAXBElement<AccountDoesNotExistException>(_AccountDoesNotExistException_QNAME, AccountDoesNotExistException.class, null, value);
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

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://service/", name = "saveResponse")
    public JAXBElement<SaveResponse> createSaveResponse(SaveResponse value) {
        return new JAXBElement<SaveResponse>(_SaveResponse_QNAME, SaveResponse.class, null, value);
    }

}
