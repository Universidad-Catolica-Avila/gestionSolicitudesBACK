package com.ucav.gestionSolicitudesBACK.wsclient.becas.handler;

import java.io.ByteArrayOutputStream;
import java.util.Set;

import javax.xml.namespace.QName;
import javax.xml.soap.SOAPMessage;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LoggingSOAPHandler implements SOAPHandler<SOAPMessageContext> {
	
	private static final Logger logger = LoggerFactory.getLogger(LoggingSOAPHandler.class);

	@Override
	public boolean handleMessage(SOAPMessageContext context) {
		Boolean isOutbound = (Boolean) context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY);

		if (isOutbound) {
			logger.debug("Outbound SOAP message:");
		} else {
			logger.debug("Inbound SOAP message:");
		}

		try {
			SOAPMessage soapMessage = context.getMessage();
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			soapMessage.writeTo(out);
			logger.error(new String(out.toByteArray()));
		} catch (Exception e) {
			e.printStackTrace();
		}
		return true;
	}

	@Override
	public boolean handleFault(SOAPMessageContext context) {
		logger.debug("SOAP Fault encountered:");
		handleMessage(context);
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
