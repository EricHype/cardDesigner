package com.ericheitmuller.util;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ericheitmuller on 11/8/17.
 */
public class FileUtil {
    public static Document readAllXmlFileText(String xmlPath) {

        try {
            File fXmlFile = new File(xmlPath);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(fXmlFile);
            return doc;
        } catch(SAXException sax){
            System.out.println(sax.getMessage());
        } catch (ParserConfigurationException config){
            System.out.println(config.getMessage());
        } catch(FileNotFoundException fileNotFound){
            System.out.println("TestFile not found");
        } catch(IOException ex){
            System.out.println("Exception reading line: " + ex.getMessage());
        }

        return null;
    }
}
