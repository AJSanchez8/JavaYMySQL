package com.example.ejemplobuenobbdd;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AppController {
    @FXML
    private TextField entrada;

    @FXML
    private Text salida;

    @FXML

    private TextArea contenido;

    @FXML
    protected void onInsertButtonClick() throws SQLException {

        String valor = entrada.getText();
        if (!valor.equals("")){
            String sql = """
                    INSERT INTO prueba (texto) VALUES (?)
                    """;
            PreparedStatement pstmt = AppIndex.conexion.prepareStatement(sql);
            pstmt.setString(1,valor);
            int n = pstmt.executeUpdate();
            if (n>0){
                System.out.println("Registro insertado con exito");
                salida.setText("Registo insertado con exito");
                Statement stm = AppIndex.conexion.createStatement();
                String sql2 = """
                        SELECT * FROM prueba
                        """;
                ResultSet rs = stm.executeQuery(sql2);
                String temp="";
                while (rs.next()){
                    temp += rs.getInt(1)+" "+rs.getString(2)+"\n" ;
                }
                contenido.setText(temp);
            }
        }else {
            salida.setText(" ERROR CAMPO VACÍO ");
            System.out.println(" ERROR CAMPO VACÍO ");
        }

    }
}