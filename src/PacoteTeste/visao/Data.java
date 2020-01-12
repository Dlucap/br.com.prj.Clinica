/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author Daniel Lucas
 */
public class Data {

    DaoCheckDate date = new DaoCheckDate();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Calendar data = Calendar.getInstance();
            //data.set(2015, Calendar.JULY, 5); // ou neste neste formato ao invés de usar o simpleFormat abaixo
            SimpleDateFormat simpleFormat = new SimpleDateFormat("dd/MM/yyyy");

            data.setTime(simpleFormat.parse("05/08/2018"));

            System.out.println("Data antes: " + simpleFormat.format(data.getTime()));
            data = checaFDS(data);
            System.out.println("Data apos: " + simpleFormat.format(data.getTime()));
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    /**
     * Verifica se data á sábado ou domingo e acrescenta dias conforme
     * necessário p/ retornar dia de semana.
     *
     * @param data Um objeto Calendar
     * @return Calendar
     */
    public static Calendar checaFDS(Calendar data) {
        // se for domingo
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            data.add(Calendar.DATE, 1);
            System.out.println("Eh domingo, mudando data para +1 dias");
        } // se for sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            data.add(Calendar.DATE, 2);
            System.out.println("Eh sabado, mudando data para +2 dias");
        } else {
            System.out.println("Eh dia de semana, mantem data");
        }
        return data;
    }

}
