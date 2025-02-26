package com.ucav.gestionProtocoloService.wsclient.becas.handler;

import java.util.Set;

import javax.annotation.PostConstruct;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPHeader;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class WSUsernameTokenHandler implements SOAPHandler<SOAPMessageContext> {
	
    private String username;
	
    private String password;
	
	@Autowired
	private Environment environment;
	
	@PostConstruct
    public void init() {
		username = environment.getProperty("becaswsclient.username");
		password = environment.getProperty("becaswsclient.password");
    }

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (isOutbound) {
			try {
				SOAPMessage soapMessage = context.getMessage();
				SOAPHeader soapHeader = soapMessage.getSOAPHeader();
				if (soapHeader == null) {
					soapHeader = soapMessage.getSOAPPart().getEnvelope().addHeader();
				}

				// Crear el espacio de nombres WS-Security
				String wsseNamespace = "http://docs.oasis-open.org/wss/2004/01/oasis-200401-wss-wssecurity-secext-1.0.xsd";
				String wssePrefix = "wsse";

				// Agregar el UsernameToken
				QName securityQName = new QName(wsseNamespace, "Security", wssePrefix);
				QName usernameTokenQName = new QName(wsseNamespace, "UsernameToken", wssePrefix);
				QName usernameQName = new QName(wsseNamespace, "Username", wssePrefix);
				QName passwordQName = new QName(wsseNamespace, "Password", wssePrefix);

				soapHeader.addChildElement(securityQName).addChildElement(usernameTokenQName)
						.addChildElement(usernameQName).addTextNode(username).getParentElement()
						.addChildElement(passwordQName).addTextNode(password);

				soapMessage.saveChanges();
			} catch (SOAPException e) {
				e.printStackTrace();
			}
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		return true;
	}

	@Override
	public void close(MessageContext context) {
	}

	@Override
	public Set<QName> getHeaders() {
		return null;
	}
}