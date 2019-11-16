package br.com.les.thewallcrud.util;

import java.util.Properties;

import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import br.com.les.thewallcrud.dominio.Usuario;

public class JavaMail {
	public Resultado enviaEmail(Resultado resultado) {
		Usuario usuario = (Usuario) resultado.getEntidade();
		String destinatario = usuario.getNome();
		Properties props = new Properties();
		
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.socketFactory.port", "465");
		props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.port", "465");

		Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication("suporte.thewall@gmail.com", "TheWall123");
			}
		});

		session.setDebug(true);

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("suporte.thewall@gmail.com"));

			Address[] toUser = InternetAddress.parse(destinatario);

			message.setRecipients(Message.RecipientType.TO, toUser);
			message.setSubject("Redefinição de Senha - The Wall");
			message.setText("Recebemos uma solicitação para alteração de senha da sua conta."
					+ " Clique no link abaixo para redefinir sua senha. Caso não tenha solicitado, "
					+ "ignore este e-mail.\nhttp://bit.ly/2QqSrUW");
			Transport.send(message);

		} catch (MessagingException e) {
			resultado.setErro("Erro ao enviar e-mail, refaça a opração");
		}
		resultado.setSucesso("Enviamos um link para redefinição de senha, verifique sua caixa de entrada. Verifique também sua caixa de spam.");
		return resultado;
	}
}
