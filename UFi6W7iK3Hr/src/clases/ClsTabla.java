package clases;

import com.lowagie.text.Font;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author MK
 */
public class ClsTabla {

    /**
     * @autor MK
     * @version 1.0
     * @fecha 17/02/2013
     * @function _modeloTable
     * @param modelTable Es DefaultTableModel
     * @param headerTable String[], el cual contiene los nombres de las columnas
     * a llevar, Ej: "Nro","Cod.Alt.", "Apellidos y Nombres", "Hora Entrada",
     * "Hora Salida", "Fecha Registro"
     * @param classTypes Class[], el cual se le asigna valores como:
     * java.lang.Object.class,java.lang.Boolean.class estas son asignadas a cada
     * columna, etc... Ej:
     * java.lang.Object.class,java.lang.Object.class,java.lang.Boolean.class,etc...
     */
    public void _modeloTabla(DefaultTableModel modelTable, String[] headerTable, final Class[] classTypes) {
        modelTable = new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                headerTable //                new String[]{
                //                    //"Nro",
                //                    "Nro","Cod.Alt.", "Apellidos y Nombres", "Hora Entrada", "Hora Salida", "Fecha Registro", "Numero de Registros",
                //                    "Lugar de Marcación", "codAsignacion", "Nombre Estado", "Abreviatura"
                //                }
                ) {
            Class[] types = classTypes;
//            Class[] types = new Class[]{
//                java.lang.Object.class,java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class,
//                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
//            };
            @Override
            public Class getColumnClass(int columnIndex) {
                return types[columnIndex];
            }
        };
    }

    /**
     * @author MK
     * @version 1.0
     * @fecha 17/02/2013
     * @param tblTable Es el JTable
     * @param anchoIntColumn Es un array Int[], el cual se asignara el ancho
     * para cada columna
     */
    public void _longitudColumnasJTable(JTable tblTable, int[] anchoIntColumn) {
        if (tblTable.getColumnCount() == anchoIntColumn.length) {
            int ancho = 0;
            TableColumnModel modelColumnTable = tblTable.getColumnModel();
            TableColumn columnaTabla;
            for (int i = 0; i < tblTable.getColumnCount(); i++) {
                columnaTabla = modelColumnTable.getColumn(i);
                ancho = anchoIntColumn[i];
                columnaTabla.setPreferredWidth(ancho);
            }
        } else {
            System.err.println("___________________Error al cargar las Longitudes a JTable___________________");
            System.err.println("Error al cargar las LONGITUDES DE JTABLE -> " + tblTable.getName());
            System.err.println("------->Numero de Columnas de JTable: " + tblTable.getColumnCount());
            System.err.println("------->Numero de anchoIntColumn[] ingresadas: " + anchoIntColumn.length);
            System.err.println("_____________________________________________________________________________");
        }
    }
    //___________________________________________________________________________________ Soy una barra separadora :)

    /**
     * @function LimpiarTabla
     * @param modelTabla Es el modelo de Tabla que se removera sus filas
     */
    public void LimpiarTabla(DefaultTableModel modelTabla) {
        while (modelTabla.getRowCount() > 0) {
            modelTabla.removeRow(0);
        }
    }

    /**
     * @function setFontTamaño_LetraJTable
     * @param tblJTable
     */
    public void setFontTamano_LetraJTable(JTable tblJTable) {
        tblJTable.setFont(new java.awt.Font("Verdana", 0, 12));
        JTableHeader th;
        th = tblJTable.getTableHeader();
        th.setFont(new java.awt.Font("Verdana", Font.BOLDITALIC, 12));
    }

    /**
     * @function setFontTamaño_LetraJTable
     * @param tblJTable
     * @param nameFuenteString
     * @param tamañoI
     */
    public void setFontTamano_LetraJTable(JTable tblJTable, String nameFuenteString, int tamanoI) {
        tblJTable.setFont(new java.awt.Font(nameFuenteString, 0, tamanoI));
        JTableHeader th;
        th = tblJTable.getTableHeader();
        th.setFont(new java.awt.Font(nameFuenteString, Font.BOLDITALIC, tamanoI));
    }
}
