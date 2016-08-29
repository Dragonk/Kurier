package pl.greywarden.komponenty.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DatabaseUtility {

    private DatabaseUtility() {
        
    }

    private static DatabaseUtility instance;

    public static DatabaseUtility getInstance() {
        return instance == null ? instance = new DatabaseUtility() : instance;
    }
    
    public LinkedList<ArrayList> fetchResult(ResultSet set) throws SQLException{
        LinkedList<ArrayList> result = new LinkedList<>();
        int columnCount = set.getMetaData().getColumnCount();
        while(set.next()){
            ArrayList<Object> row = new ArrayList<>();
            for(int i=1; i <= columnCount; i++){
                row.add(set.getObject(i));
            }
            result.add(row);
        }
        return result;
    }

}
