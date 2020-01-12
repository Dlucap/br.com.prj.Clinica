
package ModeloDao;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
/**
 *
 * @author Daniel Lucas
 */
public class DaoAliasNew {
    
    
    public DaoAliasNew(){
                try {
            //objetos para construir e fazer a leitura do documento
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            //abre e faz o parser de um documento xml de acordo com o nome passado no parametro
            Document doc = builder.parse("Alias.xml");
            
            //cria uma lista de pessoas. Busca no documento todas as tag pessoa
            NodeList listaDeAlias = doc.getElementsByTagName("BdAlias");
            
            //pego o tamanho da lista de pessoas
            int tamanhoLista = listaDeAlias.getLength();
            
            //varredura na lista de pessoas
            for (int i = 0; i < tamanhoLista; i++) {
                
                //pego cada item (pessoa) como um nó (node)
                Node noPessoa = listaDeAlias.item(i);
                
                //verifica se o noPessoa é do tipo element (e não do tipo texto etc)
                if(noPessoa.getNodeType() == Node.ELEMENT_NODE){
                    
                    //caso seja um element, converto o no Pessoa em Element pessoa
                    Element elementoAlias = (Element) noPessoa;
                    
                    //já posso pegar o atributo do element
                    String id = elementoAlias.getAttribute("id");
                    
                    //imprimindo o id
                    System.out.println("ID = " + id);      
                    
                    //recupero os nos filhos do elemento pessoa (nome, idade e peso)
                    NodeList listaDeFilhosDoAlias = elementoAlias.getChildNodes();
                    
                    //pego o tamanho da lista de filhos do elemento pessoa
                    int tamanhoListaFilhos = listaDeFilhosDoAlias.getLength();
                            
                    //varredura na lista de filhos do elemento pessoa
                    for (int j = 0; j < tamanhoListaFilhos; j++) {
                        
                        //crio um no com o cada tag filho dentro do no pessoa (tag nome, idade e peso)
                        Node noFilho = listaDeFilhosDoAlias.item(j);
                        
                        //verifico se são tipo element
                        if(noFilho.getNodeType() == Node.ELEMENT_NODE){
                            
                            //converto o no filho em element filho
                            Element elementoFilho = (Element) noFilho;
                            
                            //verifico em qual filho estamos pela tag
                            switch(elementoFilho.getTagName()){
                                case "nomeAlias":
                                    //imprimo o nome
                                    System.out.println("nomeAlias=" + elementoFilho.getTextContent());
                                    break;
                                    
                                case "servidor":
                                    //imprimo a idade
                                    System.out.println("servidor=" + elementoFilho.getTextContent());
                                    break;
                                    
                                case "banco":
                                    //imprimo o peso
                                    System.out.println("banco=" + elementoFilho.getTextContent());
                                    break;
                                case "porta":
                                    //imprimo o peso
                                    System.out.println("porta=" + elementoFilho.getTextContent());
                                    break;
                            }
                        }
                    }
                }
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(DaoAliasNew.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
