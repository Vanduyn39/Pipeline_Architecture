package org.company.pipeline_architecture.services;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.company.pipeline_architecture.core.Note;
import org.springframework.beans.factory.annotation.Value;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseService {

    private static HikariConfig config = new HikariConfig();
    private static HikariDataSource dataSource;

    //change this to connect to MSSQL
    @Value("${spring.datasource.url}")
    private static String url;
    @Value("${spring.datasource.username}")
    private static String dbUsername;
    @Value("${spring.datasource.password}")
    private static String dbPassword;

    static {

        config.setJdbcUrl( url);
        config.setUsername(dbUsername);
        config.setPassword(dbPassword);

        config.addDataSourceProperty( "cachePrepStmts" , "true" );
        config.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        config.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        dataSource = new HikariDataSource( config );
    }


    public static List<Note> getAllNotes() {
        List<Note> notes = new ArrayList<>();
        String SQL_QUERY = "select * from Delivery";
        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ResultSet rs = pst.executeQuery();) {

            while ( rs.next() ) {
                Note note = new Note();
                note.setNote( rs.getString( "note" ) );
                notes.add( note );
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return notes;
    }

    public static boolean checkInventory(int productId, int neededQuantity) {

        String SQL_QUERY = "SELECT stockQuantity FROM dbo.Products p WHERE productId=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
             ) {
            pst.setInt(1, productId);
            ResultSet rs = pst.executeQuery();
            while ( rs.next() ) {
                int stockQuants = rs.getInt( "stockQuantity" );
                if ( neededQuantity > stockQuants  ) { return false; }

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;
    }

    public static boolean checkDeliveryStatus(int nodeId) {

        String SQL_QUERY = "SELECT isDelivery FROM dbo.Delivery d WHERE d.deliveryId=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement pst = con.prepareStatement(SQL_QUERY);
        ) {
            pst.setInt(1, nodeId);
            ResultSet rs = pst.executeQuery();
            while ( rs.next() ) {
                return rs.getBoolean( "isDelivery" );
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return true;

    }

}
