/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xml;

import forum.Post;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
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
public class XmlPost implements Xml{
    private String file;
    private LinkedList<Post> postList;
    public XmlPost(){
        file = "c:\\webtemp\\data.xml";
        postList = new LinkedList<Post>();
        read();
    }
    
    public List<Post> getPostList() {
        return postList;
    }
    
    public void read(){
        try {
            postList = new LinkedList<Post>();
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
            NodeList nPostList = doc.getElementsByTagName("post");
            //String content;
      
            //go through all the entries
            for (int i = 0 ; i < nPostList.getLength(); i++){
                
                Node nNode = nPostList.item(i);
                Element eElement = (Element) nNode;
                String username = eElement.getElementsByTagName("username").item(0).getTextContent();
                String text = eElement.getElementsByTagName("text").item(0).getTextContent();
                String date = eElement.getElementsByTagName("date").item(0).getTextContent();
                postList.add(new Post(username, text, date)); 
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
    public void addPost(Post post){
        postList.addFirst(post);
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
	for (int i = 0; i < postList.size(); i++){
            Post postInsert = postList.get(i);
            
            Element post = doc.createElement("post");
            rootElement.appendChild(post);

            // username elements
            Element username = doc.createElement("username");
            username.appendChild(doc.createTextNode(postInsert.getUsername()));
            post.appendChild(username);

            // text elements
            Element text = doc.createElement("text");
            text.appendChild(doc.createTextNode(postInsert.getText()));
            post.appendChild(text);
            
            // date elements
            Element date = doc.createElement("date");
            date.appendChild(doc.createTextNode(postInsert.getDate()));
            post.appendChild(date);
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
