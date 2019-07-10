/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.elearning.outiles;

import java.io.IOException;
import java.security.MessageDigest;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

public class Util {

    public static String motdepasse() {
        System.out.println((char) 65);
        String s = "";
        for (int i = 0; i <= 7; i++) {
            s = s + (char) (33 + (Math.random() * (125 - 33)));
        }
        return s;
    }

    public static String sha256(String base) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(base.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public static void sendMail(String msg, String objet, String destination) {
        final String username = "sd.sonelgaz@gmail.com";
        final String password = "123456789admin";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true"); //securité TLS pour les comptes gmail
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587 ");
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("sd.sonelgaz@gmail.com"));
            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(destination));
            message.setSubject(objet);
            message.setContent(msg, "text/html; charset=utf-8");
            Transport.send(message);
            System.out.println("Done");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }

    public static String getsession(String sessionName) {
        ExternalContext fs = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) fs.getSession(false);
        return (String) session.getAttribute(sessionName);
    }

    public static void setsession(String sessionName, String sessionValue) {
        FacesContext fs = FacesContext.getCurrentInstance();
        HttpSession session = (HttpSession) fs.getExternalContext().getSession(true);
        session.setAttribute(sessionName, sessionValue);
    }

    public static void destroysession(String type) {
        ExternalContext fs = FacesContext.getCurrentInstance().getExternalContext();
        HttpSession session = (HttpSession) fs.getSession(false);
        session.removeAttribute(type);
    }

    public static void redirectTo(String page) throws IOException {
        FacesContext fs = FacesContext.getCurrentInstance();
        fs.getExternalContext().redirect(page);

    }

    public static String base_url() {
        ExternalContext fs = FacesContext.getCurrentInstance().getExternalContext();
        return fs.getRequestContextPath();
    }

    public static boolean verification_mail(String email) {
        String p
                = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(email);
        return m.find();
    }

    public static boolean isNumber(String email) {
        String p
                = "^[0-9]+$";
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(email);
        return m.find();
    }

    public static String motdepasse_complexe(String mdp) {
        String p1
                = "^(.)*[0-9]+(.)*$";
        String p2
                = "^(.)*[a-z]+(.)*$";
        String p3
                = "^(.)*[A-Z]+(.)*$";
        Pattern pattern1 = Pattern.compile(p1);
        Pattern pattern2 = Pattern.compile(p2);
        Pattern pattern3 = Pattern.compile(p3);
        Matcher m1 = pattern1.matcher(mdp);
        Matcher m2 = pattern2.matcher(mdp);
        Matcher m3 = pattern3.matcher(mdp);
        if (m1.find()) {
            if (m2.find()) {
                if (m3.find()) {
                    return "ok";
                } else {
                    return "mot de passe doit contient ou moins une lettre en majiscule";
                }

            } else {
                return "mot de passe doit contient ou moins une lettre en miniscule";
            }

        } else {
            return "Le mot de passe doit contenir au moins un chiffre";
        }

    }

    public static boolean validernomprenom(String text) {
        String p
                = "^[A-Za-z\\s]*$";
        Pattern pattern = Pattern.compile(p);
        Matcher m = pattern.matcher(text);
        return m.find();
    }

    public static String getFilename(Part part) {
        for (String cd : part.getHeader("content-disposition").split(";")) {
            if (cd.trim().startsWith("filename")) {
                return cd.substring(cd.indexOf('=') + 1).trim().replace("\"", "");
            }
        }
        return null;
    }
    //   ^[a-zA-Z]*$
}

/*

event <p:ajax /> :

blur
change
click
dblclick
focus
keydown
keypress
keyup
mousedown
mousemove  
mouseout
mouseover
mouseup
select



 */
