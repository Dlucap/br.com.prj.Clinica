/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao.Avulso;

/**
 *
 * @author Daniel Lucas
 */
public class combina {
    
public static Cor combina(Cor cor1, Cor cor2) {
    int combinado = cor1.codigo() | cor2.codigo();
    return Cor.porCodigo(combinado);
}
    public static void main(String[] args) {
       Cor cor = combina(Cor.VERMELHO, Cor.AZUL);
    assert cor == Cor.ROXO;
    }
    
    
}
