package clases;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.table.*;

/**
 *
 * @author miguel mosquera tahua
 */
public class ClsMetodos {

    private ClsDatabase bd = new ClsDatabase();

    /**
     *
     * @author sergio
     */
    public void tablaLimpia(javax.swing.table.DefaultTableModel md) {
        while (md.getRowCount() > 0) {
            md.removeRow(0);
        }
    }

    public void tablaLongitudColumnas(javax.swing.JTable table, int longitudes[]) {
        int ancho = 0;
        TableColumnModel mc = table.getColumnModel();
        TableColumn columnaTabla;
        for (int i = 0; i < table.getColumnCount(); i++) {
            columnaTabla = mc.getColumn(i);
            ancho = longitudes[i];
            columnaTabla.setPreferredWidth(ancho);
        }
    }

    public void tablaLlenaSimple(javax.swing.JTable jtable1, Object mat[]) {
        DefaultTableModel mdt = (DefaultTableModel) jtable1.getModel();
        tablaLimpia(mdt);
        //mdt.addRow(mat);
        //mdt.
    }

    public boolean tablaLlenaSql(javax.swing.JTable jtable1, String sql, int n) {
        DefaultTableModel mdt = (DefaultTableModel) jtable1.getModel();

        tablaLimpia(mdt);
        boolean va = true;
        try {

            bd.getConnection();

            PreparedStatement pstm = bd.conn.prepareStatement(sql);

            ResultSet res = pstm.executeQuery();
//            pstm.get
//            res.get

            while (res.next()) {
                Object mat[] = new Object[n];
                for (int i = 0; i < n; i++) {
                    mat[i] = res.getString(i + 1);
                }
                mdt.addRow(mat);
            }

            res.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println(sql);
        return va;
    }

    public void comboboxLlenar(JComboBox cb, DefaultComboBoxModel mlb, String sql) {
        mlb.removeAllElements();
        cb.removeAllItems();
        try {
            bd.getConnection();
            PreparedStatement pstm = bd.conn.prepareStatement(sql);
            ResultSet res = pstm.executeQuery();
            while (res.next()) {
                mlb.addElement(res.getString(1));
                cb.addItem(res.getString(2));
            }
            res.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        cb.setSelectedIndex(-1);
        cb.setPopupVisible(false);

    }


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
