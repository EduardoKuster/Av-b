/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.sqlite;

/**
 *
 * @author friend
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import modelo.Compania;

public class CompaniaDAO {

    Connection con;
    Statement st;
    ResultSet result;

    public static final String URL = "jdbc:sqlite://home/aluno/Downloads/dw2ed-main/bd/java/sqlite/companies.db";

    public void conectarSQLite() {

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection(URL);
            st = con.createStatement();
        } catch (Exception ex) {
            System.out.print("Erro no SQL: " + ex.getMessage());
        }
    }

    public ArrayList<Compania> retornarCompania(int offset) {
        ArrayList<Compania> companias = new ArrayList<Compania>();
        conectarSQLite();
        try {
            result = st.executeQuery("select * from compania LIMIT 10 OFFSET "+ offset);

            while (result.next()) {

                Compania compania = new Compania();
                compania.setId(result.getString(1));
                compania.setNome(result.getString(2));
                compania.setDominio(result.getString(3));
                compania.setAno(result.getString(4));
                compania.setIndustria(result.getString(5));
                compania.setTamanho(result.getString(6));
                compania.setLocalizacao(result.getString(7));
                compania.setPais(result.getString(8));
                compania.setLinkedin(result.getString(9));
                compania.setEmpregados_atual(Integer.valueOf(result.getString(10)));
                compania.setEmpregados_total(Integer.valueOf(result.getString(11)));

                companias.add(compania);
            }
        } catch (SQLException ex) {
            System.out.print("Erro no SQL: " + ex.getMessage());
        }
        return companias;
    }
    
    public boolean incluirCompania(Compania nova) {
         conectarSQLite();
        try {
            st.executeQuery("insert into Compania values("+"'"+nova.getId()+",'"+nova.getNome()+",'"+nova.getDominio()+",'"+nova.getAno()+",'"+nova.getIndustria()+",'"+nova.getTamanho()+",'"+nova.getLocalizacao()+",'"+nova.getPais()+",'"+nova.getLinkedin()+",'"+nova.getEmpregados_atual()+",'"+nova.getEmpregados_total()+"')");

            return true;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }
    
    public boolean removerCompania(String id) {
        try {
           st.executeQuery("delete from Compania where id = "+id);
            return true;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }
    
    public Compania buscarCompania(String id) {
        try {
            st.executeQuery("select from Compania where id = "+id);
            return null;
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return null;
        }
    }
   
    public boolean AtualizarCompania(Compania novosDados) {
        try {
           st.executeQuery("update Compania set nome = '"+ novosDados.getNome() +"' nome = '"+ novosDados.getDominio() +"' nome = '"+ novosDados.getAno() +"' nome = '"+ novosDados.getIndustria() +"' nome = '"+ novosDados.getTamanho() +"' nome = '"+ novosDados.getLocalizacao() +"' where id = "+novosDados.getId());
            return true;            
        } catch (Exception e) {
            System.out.println("depuração: " + e.getMessage());
            return false;
        }
    }
}
