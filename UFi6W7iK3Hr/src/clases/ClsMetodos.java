package clases;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author MK 
 */
public class ClsMetodos {

//___________________________________________________________________________________ Soy una barra separadora :)
    /**
     * @function getExtraerFechaJDateChooser
     * @param dateChooserString
     * @param b
     * @return String
     */
    public String getExtraer_FechaJDateChooser(String dateChooserString, boolean b) {
        String fec = null, año, mes, dia;
//        Date feDate;
//        fecha_nac=fechas(dcFechaNacimiento.getText(), true);
//        dcFechaNacimiento.getText()
//        es el combo datechoser
//        para almacenarlo a la base de datos
        System.out.println("--->getExtraerFechaJDateChooser()::: " + dateChooserString);
        if (b == true) {
            if (dateChooserString.length() == 7) {
                año = dateChooserString.substring(5, 7);
                mes = dateChooserString.substring(2, 4);
                dia = "0" + dateChooserString.substring(0, 1);
                fec = año + "/" + mes + "/" + dia;
            } else {
                año = dateChooserString.substring(6, 8);
                mes = dateChooserString.substring(3, 5);
                dia = dateChooserString.substring(0, 2);
                fec = año + "/" + mes + "/" + dia;
            }

        } else {
            dia = dateChooserString.substring(8, 10);
            mes = dateChooserString.substring(5, 7);
            año = dateChooserString.substring(2, 4);
            fec = dia + "/" + mes + "/" + año;
        }
        System.out.println("Return getExtraerFechaJDateChooser()::: " + dateChooserString);
        return fec;
    }

    /**
     * @function getExtraerDayOfMonth
     * @param fechaAsignadaString Se le pasa una fecha en formato String
     * @return int, devuelve un int del dia en ese mes
     * @version 1.0
     * @author MK
     */
    public int getExtraer_DayOfMonth(String fechaAsignadaString) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(fechaAsignadaString.substring(0, 4)),
                Integer.parseInt(fechaAsignadaString.substring(5, 7)) - 1,
                Integer.parseInt(fechaAsignadaString.substring(8, 10)));
//            System.out.println("year:"+fechaAsignadaString.substring(0, 4));
//            System.out.println("month:"+(Integer.parseInt(fechaAsignadaString.substring(5, 7))-1));
//            System.out.println("day:"+fechaAsignadaString.substring(8, 10));
//            System.out.println("ano mk : "+calendar.getInstance());
        return calendar.get(Calendar.DAY_OF_WEEK);
    }

    /**
     *
     * @param calendarFecha
     * @return String
     */
    public String getFormat_Fecha(Calendar calendarFecha) {
        String fechaAsignadaString = "";
        String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Calendar calendar = calendarFecha;
        fechaAsignadaString = sdf.format(calendar.getTime());
        return fechaAsignadaString;
    }

    /**
     *
     * @param calendarFecha
     * @param formatString
     * @return String
     */
    public String getFormat_Fecha(Calendar calendarFecha, String formatString) {
        String fechaAsignadaString = "";
        String DATE_FORMAT = formatString;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        Calendar calendar = calendarFecha;
        fechaAsignadaString = sdf.format(calendar.getTime());
        return fechaAsignadaString;
    }

    /**
     *
     * @param calendarFechaString
     * @return String
     */
    public String getFormat_Fecha(String calendarFechaString) {
        String fechaAsignadaString = "";
        String DATE_FORMAT = "yyyy-MM-dd";
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(calendarFechaString.substring(0, 4)),
                Integer.parseInt(calendarFechaString.substring(5, 7)) - 1,
                Integer.parseInt(calendarFechaString.substring(8, 10)));

        fechaAsignadaString = sdf.format(calendar.getTime());
        return fechaAsignadaString;
    }
    /**
     *
     * @param calendarFechaString
     * @param formatString
     * @return String
     */
    public String getFormat_Fecha(String calendarFechaString, String formatString) {
        String fechaAsignadaString = "a";
        String DATE_FORMAT = formatString;
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);

        Calendar calendar = Calendar.getInstance();
        calendar.set(Integer.parseInt(calendarFechaString.substring(0, 4)),
                Integer.parseInt(calendarFechaString.substring(5, 7)) - 1,
                Integer.parseInt(calendarFechaString.substring(8, 10)));

        fechaAsignadaString = sdf.format(calendar.getTime());
        return fechaAsignadaString;
    }
    //___________________________________________________________________________________ Soy una barra separadora :)
    /**
     * Metodo que permite cerrar todo el Sistema
     */
    public void _cerrarSistema() {
        System.exit(0);//cerramos todo        
    }
    //___________________________________________________________________________________ Soy una barra separadora :)
}
