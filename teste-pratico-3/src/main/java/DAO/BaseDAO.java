package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import utils.Utils;


/**
 * @author rburgmac
 * Classe respons�vel por acessar diretamente a base de dados SIEBEL e realizar opera��es de persist�ncia de dados na mesma.
 */
public class BaseDAO extends DAO{

	private static Connection connect;
    private static Statement statement;
    private static ResultSet results;
    private static List<Map<String, String>> resultList;
	private static String[] collunmsDB            = {"IDMASSAS", "NAME_PRODUCT", "CUSTOMIZATION", "DISPLAY", "DISPLAY_RESOLUTION", "DISPLAY_SIZE",
			"MEMORY", "OPERATING_SYSTEM", "PROCESSOR", "TOUCHSCREEN", "WEIGHT", "COLOR"};
    private static  String SERVER_FULL      =  "127.0.0.1";
    private static final String PORT              =   "3306";
    private static final String DATABASE          =   "banco_teste_automacao";
    private static final String USERNAME          =   "root";
    private static final String PASSWORD          =   "root";
	
    public BaseDAO() throws SQLException, ClassNotFoundException {
        getConnection();
    }
    
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        connect = getConnection(SERVER_FULL, PORT, DATABASE, USERNAME, PASSWORD);
        return connect;
    }

    //retorna a consulta do banco em formato json
    public JSONObject getProduct() throws SQLException, ClassNotFoundException {
    	String sql = "SELECT * FROM banco_teste_automacao.massas;";
    	
    	statement = connect.createStatement();
    	results = statement.executeQuery(sql);
    	resultList = new ArrayList<>();
    	resultList = Utils.listResultDBGenerator(results, resultList,collunmsDB, 1);
    	return new JSONObject(resultList.get(0));
    }
    
    //realiza update da cor
    public boolean updateColor(String color) throws SQLException {
		String sql = "UPDATE banco_teste_automacao.massas\n"
				+ "SET COLOR='"+ color +"'\n"
				+ "WHERE IDMASSAS=2;";
		
		statement = connect.createStatement();
		int retorno = statement.executeUpdate(sql);
		if(retorno > 0)
			return true;
		else
			return false;
    }
 
}
    

 