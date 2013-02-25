package clases;

import java.sql.*;

/**
 *
 * @author Mike
 */
public class ClsDatabase {
    /* DATOS PARA LA CONEXION */

    private static String bd = "bd_prueba2";
    private static String login = "root";
    private static String password = "admin";
    private static String host = "localhost";
    private static String url = "jdbc:mysql://" + host + "/" + bd;
    private Connection conn = null;
//___________________________________________________________________________________ Soy una barra separadora :)

    public ClsDatabase() {
        try {
            //obtenemos el driver de para mysql
            Class.forName("com.mysql.jdbc.Driver");
            //obtenemos la conexión
            conn = DriverManager.getConnection(url, login, password);
            if (conn != null) {
                System.out.println("OK base de datos " + bd + " listo");
            }
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
//___________________________________________________________________________________ Soy una barra separadora :)

    public Connection getConnection() {
        return this.conn;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    /* METODO PARA REALIZAR UNA CONSULTA A LA BASE DE DATOS
     * INPUT:
     *      table => nombre de la tabla donde se realizara la consulta, puede utilizarse tambien INNER JOIN
     *      fields => String con los nombres de los campos a devolver Ej.: campo1,campo2campo_n
     *      where => condicion para la consulta
     * OUTPUT: un object[][] con los datos resultantes, sino retorna NULL
     */
    /*
     * @author - MK
     * @version 1.0
     * @param - table => nombre de la tabla donde se realizara la consulta, puede utilizarse tambien INNER JOIN
     fields => String con los nombres de los campos a devolver Ej.: campo1,campo2,campo_n
     where => condicion para la consulta
     * @return - un object[][] con los datos resultantes, sino retorna NULL
     * @exception - Devuelve un SQLException si falla la conexion...
     */

    public Object[][] select(String table, String fields, String where) {
        //Permitira obtener la cantidada de registros de la consulta,
        //para poder determinar el array de objetos a devolver...
        int registros = 0;
        //Obtenemos los fields separados en los elementos de un array, por el split
        String colname[] = fields.split(",");

        //Implementacion para preveer el ingreso de campos personalizados, al SELECT
        //Ej: campo1 as Name,campo1 as Age,...
        for (int i = 0; i < colname.length; i++) {
            //Si contiene el " as ", quiere decir que tiene asignado al campo un
            //nombre personalizado para la consulta, y extraemos ese nombre...
            if (colname[i].toLowerCase().contains(" as ")) {
                colname[i] = colname[i].substring(colname[i].toLowerCase().indexOf(" as ") + 4, colname[i].length());
            }
        }

        //Consultas SQL
        String q = "SELECT " + fields + " FROM " + table;//Se encuentra la verdadera consulta
        String q2 = "SELECT count(*) as total FROM " + table;//Nos permite saber cuantos rows trae la consulta
        //Si la variable where no esta vacio, lo concadenamos a "q", para la consulta
        if (where != null) {
            q += " WHERE " + where;
            q2 += " WHERE " + where;
        }
        System.out.println("sql->q: "+q);
        //obtenemos la cantidad de registros existentes en la tabla
        try {
            PreparedStatement pstm = conn.prepareStatement(q2);
            System.out.println("sql->q2: "+q2);
            ResultSet res = pstm.executeQuery();
            res.next();
            registros = res.getInt("total");
            res.close();
        } catch (SQLException e) {
            System.out.println(e);
            System.out.println("...............................................................................");
            e.printStackTrace();
        }
        System.out.println("registros: "+registros);
        System.out.println("columnas: "+fields.split(",").length);

        if (registros>0) {
            //Se crea una matriz con tantas filas y columnas que necesite
            Object[][] data = new String[registros][fields.split(",").length];
            //Realizamos la consulta sql y llenamos los datos en la matriz "Object"
            try {
                PreparedStatement pstm = conn.prepareStatement(q);
                ResultSet res = pstm.executeQuery();
                int i = 0;
                while (res.next()) {
                    for (int j = 0; j <= fields.split(",").length - 1; j++) {
                        data[i][j] = res.getString(colname[j].trim());
                    }
                    i++;
                }
                res.close();
            } catch (SQLException e) {
                System.err.println("Error en [Paquete: MODEL - NombreComponete: DATABASE.java(CLASS) - Funcion: Object[][] select()]...");
                System.err.println(e);
            }
            return data;
        }
        return null;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    /* METODO PARA INSERTAR UN REGISTRO EN LA BASE DE DATOS
     * INPUT:
     table => Nombre de la tabla
     fields => String con los nombres de los campos donde insertar Ej.: campo1,campo2campo_n
     values => String con los datos de los campos a insertar Ej.: valor1, valor2, valor_n
     */
    /*
     * @author - MK
     * @version 1.0
     * @param - table => Nombre de la tabla
     fields => String con los nombres de los campos donde insertar Ej.: campo1,campo2campo_n
     values => String con los datos de los campos a insertar Ej.: valor1, valor2, valor_n
     * @return - boolean -> true: Si se inserto correctamente
     *                   -> false: Si no se pudo realizar el insert
     * @exception - Devuelve un SQLException...
     */
//___________________________________________________________________________________ Soy una barra separadora :)

    public boolean insert(String table, String fields, String values) {
        boolean res = false;
        //Se arma la consulta
        String q = " INSERT INTO " + table + " ( " + fields + " ) VALUES ( " + values + " ) ";
        //Se ejecuta la consulta
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;
        } catch (SQLException e) {
            System.err.println("Error en [Paquete: MODEL - NombreComponete: DATABASE.java(CLASS) - Funcion: boolean insert()]...");
            System.err.println(e);
        }
        return res;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    /* METODO PARA ACTUALIZAR UN REGISTRO EN LA BASE DE DATOS
     * INPUT:
     table = Nombre de la tabla
     fields = String con los nombres de los campos donde actualizar Ej.: campo1=nuevoValor1,campo2campo_n=nuevoValor
     where = String con los datos de los campos a insertar Ej.: valor1, valor2, valor_n
     */
    /*
     * @author - MK
     * @version 1.0
     * @param - table => Nombre de la tabla
     fields => String con los nombres de los campos donde actualizar
     Ej.: campo1=nuevoValor1,campo2campo_n=nuevoValor
     where => String con el campo primarykey a actualizar Ej.: some_column_primarykey=some_value_to_update
     * @return - boolean -> true: Si se actualizo correctamente
     *                   -> false: Si no se pudo realizar el update
     * @exception - Devuelve un SQLException...
     */
//___________________________________________________________________________________ Soy una barra separadora :)

    public boolean update(String table, String fields, String where) {
        boolean res = false;
        //Se arma la consulta para el UPDATE
        String q = " UPDATE " + table + " SET " + fields + " WHERE " + where;
        //Se ejecuta la consulta
        try {
            PreparedStatement pstm = conn.prepareStatement(q);
            pstm.execute();
            pstm.close();
            res = true;
        } catch (SQLException e) {
            System.err.println("Error en [Paquete: MODEL - NombreComponete: DATABASE.java(CLASS) - Funcion: boolean insert()]...");
            System.err.println(e);
        }
        return res;
    }
//___________________________________________________________________________________ Soy una barra separadora :)

    public void desconectar() {
        conn = null;
        System.out.println("La conexion a la  base de datos " + bd + " a terminado. PROBLEM?");
    }
//___________________________________________________________________________________ Soy una barra separadora :)
    /*
     * Asignamos los valores para la configuracion respectiva
     */

    public void setUser(String user) {
        this.login = user;//Se cambia el USUARIO
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setDataBase(String dataBase) {
        this.bd = dataBase;
    }

    public void setHost(String host) {
        this.host = host;
    }
//___________________________________________________________________________________ Soy una barra separadora :)

    public String getUser() {//Retorna el valor del Usuario
        return this.login;
    }

    public String getPassword() {//Retorna el Password
        return this.password;
    }

    public String getDataBase() {//Retorna la base de datos
        return this.bd;
    }

    public String getHost() {//Retorna el host: puede ser Localhost, o direccion IP
        return this.host;
    }
//___________________________________________________________________________________ Soy una barra separadora :)
}
