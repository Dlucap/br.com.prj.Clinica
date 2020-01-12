/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao.Avulso;
import java.io.IOException;
import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.CharacterData;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class XmlTeste {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
      String xmlRetorno =    
                "<?xml version='1.0' encoding='UTF-8'?>"
                        +"<sroxml>"
                        +"   <versao>1.0</versao>"
                        +"   <qtd>50</qtd>"
                        +"   <TipoPesquisa>Lista de Objetos</TipoPesquisa>"
                        +"   <TipoResultado>Último evento</TipoResultado>"
                        +"   <objeto>"
                        +"      <numero>JG280660495BR</numero>"
                        +"      <evento>"
                        +"         <tipo>BDE</tipo>"
                        +"         <status>01</status>"
                        +"         <data>27/08/2013</data>"
                        +"         <hora>18:49</hora>"
                        +"         <descricao>Entregue</descricao>"
                        +"         <recebedor />"
                        +"         <documento />"
                        +"         <comentario />"
                        +"         <local>CDD RIBEIRA</local>"
                        +"         <codigo>59012970</codigo>"
                        +"         <cidade>NATAL</cidade>"
                        +"         <uf>RN</uf>"
                        +"         <sto>60402008</sto>"
                        +"      </evento>"
                        +"   </objeto>"
                        +"</sroxml>";

        // System.out.println(xmlRetorno);
        DocumentBuilder db;
        try {
            db = DocumentBuilderFactory.newInstance().newDocumentBuilder();
            InputSource is = new InputSource();
            is.setCharacterStream(new StringReader(xmlRetorno));
            Document doc = db.parse(is);
            NodeList nodes = doc.getElementsByTagName("objeto");


            for (int i = 0; i < nodes.getLength(); i++) {
                Element element = (Element) nodes.item(i);

                NodeList data = element.getElementsByTagName("data");
                System.out.println(data.item(0).getTextContent());
                data = element.getElementsByTagName("hora");
                 System.out.println(data.item(0).getTextContent());
            }

        } catch (ParserConfigurationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SAXException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println("Finish");

    }

//    public static String getCharacterDataFromElement(Element e) {
//        Node child = e.getFirstChild();
//        if (child instanceof CharacterData) {
//            CharacterData cd = (CharacterData) child;
//            return cd.getData();
//        }
//        return "";
//    }
    
}
