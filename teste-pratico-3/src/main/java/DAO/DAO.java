package DAO;

import java.sql.*;
import java.util.logging.Logger;

/**
 * @author rburgmac
 * Classe responsável pela conexão e persistência diretamente na base de dados
 */
public abstract class DAO {

    public final static Logger log = Logger.getLogger(String.valueOf(DAO.class));
    private static final String DRIVER_NAME = "com.mysql.jdbc.Driver";

    private static Connection connect;
    private static Statement statement;
    private static ResultSet results;



    public static Connection getConnection(String SERVER, String PORT, String DATABASE, String USERNAME, String PASSWORD) throws ClassNotFoundException, SQLException {
        Class.forName(DRIVER_NAME);
        connect = DriverManager.getConnection("jdbc:mysql://" + SERVER + ":" + PORT + "/" + DATABASE, USERNAME, PASSWORD);
        return connect;
    }

    /**
     * Método que visa consultar o atributo CITY_CODE, posteriormente usado pelo contexto da rede Vivo 2 com tecnologia de acesso GPON
     * @param STATE_CITY
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public String getCNLAcronym(String STATE_CITY) throws SQLException, ClassNotFoundException {
        String sql = "select CITY_CODE from (Select CITY_CODE, COUNT(CITY_CODE) AS CT FROM CD_"+STATE_CITY+".VWO_COVERAGE_AREA GROUP by CITY_CODE ORDER BY CT DESC) where ROWNUM = 1";
        //String sql = "SELECT CITY_CODE FROM (SELECT CITY_CODE, COUNT(CITY_CODE)AS CT FROM CD_SP_CAMPINAS.VWO_COVERAGE_AREA GROUP BY CITY_CODE ORDER BY CT DESC) WHERE ROWNUM = 1";
        statement = connect.createStatement();
        results = statement.executeQuery(sql);
        results.next();
        return results.getString("CITY_CODE");
    }



}
