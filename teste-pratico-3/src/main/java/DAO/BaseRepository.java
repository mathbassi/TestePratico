package DAO;


import java.sql.SQLException;
import java.util.logging.Logger;

import org.json.JSONObject;

/**
 * @author rburgmac
 * Classe responsável por usar a classe SiebelDAO e aplicar regras de negócio em cima de inputs e outpus
 */
public class BaseRepository {

    public final static Logger log = Logger.getLogger(String.valueOf(BaseRepository.class));
    private BaseDAO baseDAO;

    public BaseRepository() throws SQLException, ClassNotFoundException {
        baseDAO = new BaseDAO();
    }

    
    public JSONObject getProduct() throws SQLException, ClassNotFoundException {
        return  baseDAO.getProduct();
    }


}
