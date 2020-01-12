/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PacoteTeste.visao;

import ModeloDao.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Daniel Lucas
 */
public class DaoCheckDate {
    
    
    public String checaFDS(String dataString) throws ParseException
    {
       //SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Calendar data = Calendar.getInstance();
      
        // se for domingo
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        {
            return "Domingo";
        }
        // se for sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        {
            return "Sábado";
        }
        return "";
    }

    public boolean EhFimDeSemana(Calendar data) {
         // se for domingo
        if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
            return true;
        } // se for sábado
        else if (data.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
            return true;
        } else {
          return false;
        }
    }
 }
