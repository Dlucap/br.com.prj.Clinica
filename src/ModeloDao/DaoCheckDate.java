/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.util.Calendar;

/**
 *
 * @author Daniel Lucas
 */
public class DaoCheckDate {
    
    
    public Calendar checaFDS(Calendar data)
    {
        // se for domingo
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            data.add(Calendar.DATE, 1);
            System.out.println("Eh domingo, mudando data para +1 dias");
        }
        // se for sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        {
            data.add(Calendar.DATE, 2);
            System.out.println("Eh sabado, mudando data para +2 dias");
        }
        else
        {
            System.out.println("Eh dia de semana, mantem data");
        }
        return data;
    }


}
