/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package PacoteTeste.visao;


public enum EnumStatus {
    
    Aberto(0), Em Atendimento(1), Finalizado(2), Cancelado(3);

     private final int codigo;

    Cor(int codigo) { this.codigo = codigo; }

    int codigo() { return codigo; }

    public static Cor porCodigo(int codigo) {
        for (Cor cor: Cor.values()) {
            if (codigo == cor.codigo()) return cor;
            System.out.println(cor);
        }
        throw new IllegalArgumentException("codigo invalido");
    }
    
    
    
}
*/