/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import forum.User;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Cole
 */
public class XmlUser implements Xml{
    private String file;
    private List<User> userList;
    public XmlUser(){
        file = "c:\\webtemp\\user.xml";
        userList = new ArrayList<User>();
        read();
    }

    public List<User> getUserList() {
        return userList;
    }
    
    public void read(){
        try {
            userList = new ArrayList<User>();
            File fXmlFile = new File(file);
            System.out.println("Loading file \"" + file +"\"...\n");
   
            //set up to read in XML file
            DocumentBuilderFactory builderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = builderFactory.newDocumentBuilder();
            Document doc = builder.parse(fXmlFile);
            doc.getDocumentElement().normalize();
         
            //get the title
            //journalTitle = new String(doc.getDocumentElement().getNodeName());
         
            //set up node list of entries
            NodeList nPostList = doc.getElementsByTagName("user");
            //String content;
      
            //go through all the entries
            for (int i = 0 ; i < nPostList.getLength(); i++){
                
                Node nNode = nPostList.item(i);
                Element eElement = (Element) nNode;
                String username = eElement.getElementsByTagName("username").item(0).getTextContent();
                String password = eElement.getElementsByTagName("password").item(0).getTextContent();
                userList.add(new User(username, password)); 
            }
        }
        catch (IOException ioex) {
            System.out.println("Error in Opening XML file! shutting down program");
            return;
        }
        catch (Exception ex){
            System.out.println("Error in parsing XML file! shutting down program");
            return;
        }
    }
    public void addUser(User user){
        userList.add(user);
    }
    
    public void write(){
       try{
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
	DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
 
	// root elements
	Document doc = docBuilder.newDocument();
	Element rootElement = doc.createElement("forum");
	doc.appendChild(rootElement);
           
        // post elements
	for (int i = 0; i < userList.size(); i++){
            User userInsert = userList.get(i);
            
            Element user = doc.createElement("user");
            rootElement.appendChild(user);

            // username elements
            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(userInsert.getUsername()));
            user.appendChild(username);

            // text elements
            Element password = doc.createElement("password");
            password.appendChild(doc.createTextNode(userInsert.getPassword()));
            user.appendChild(password);
        }
        
         // write the content into xml file
	TransformerFactory transformerFactory = TransformerFactory.newInstance();
	Transformer transformer = transformerFactory.newTransformer();
	DOMSource source = new DOMSource(doc);
	StreamResult result = new StreamResult(new File(file));

        transformer.transform(source, result);
       }
       catch (Exception exception){
           
       }
    }
    
    
}
