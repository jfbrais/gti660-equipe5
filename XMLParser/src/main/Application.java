package main;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import xml.*;

public class Application {

        /**
         * @param args
         */
        public static void main(String[] args) {
        	try {
				Class.forName("oracle.jdbc.driver.OracleDriver");

				String url = "jdbc:oracle:thin:@//oracle-11.logti.etsmtl.ca:1521/GTI660";

				Connection conn = DriverManager.getConnection(url,"equipe5","fuPUiLay");

				conn.setAutoCommit(false);
				Statement stmt = conn.createStatement();
				ResultSet rset = stmt.executeQuery("SELECT * FROM CLIENTS");
				while (rset.next()) {
				     System.out.println (rset.getString(1));
				}
				stmt.close();
				System.out.println ("Ok.");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}

//        	try {
//                SAXParserFactory fabrique = SAXParserFactory.newInstance();
//                SAXParser parseur = fabrique.newSAXParser();
//
//                File fichier = new File("etc/clients.xml");
//                DefaultHandler gestionnaire = (DefaultHandler) new ClientHandler();
//                parseur.parse(fichier, gestionnaire);
//            } catch (ParserConfigurationException e) {
//                    e.printStackTrace();
//            } catch (SAXException e) {
//                    e.printStackTrace();
//            } catch (IOException e) {
//                    e.printStackTrace();
//            }
        }
}