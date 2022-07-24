/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ao.co.proevolution.baccarat.util;

/**
 * z
 *
 * @author
 */
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class BDConexao {

    private Connection connection;
    private Statement statement;

//            
    public BDConexao() {
        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.createStatement();

        } catch (Exception e) {
//            JOptionPane.showMessageDialog(null,"Informações indisponiveis");
            System.out.println("Erro BDConexão: " + e);
        }
    }

    public static BDConexao getBDConetion() {
        return new BDConexao();
    }

    public static Connection conectar()//throws Exception
    {
        Connection mtdoConectar = null;
        try {
            Class.forName(ConfigDBUtil.JDBC_DRIVER);
            mtdoConectar = DriverManager.getConnection(ConfigDBUtil.JDBC_URL, ConfigDBUtil.USER_NAME, ConfigDBUtil.PASS_WORD);
        } catch (ClassNotFoundException cnf) {
          
//            showMessage("Driver de Conexao nao Encontrado:" + cnf.getMessage());
        } catch (SQLException sqlex) {
        
//            showMessage("Erro ao Estabelecer a Conexao:" + sqlex.getMessage());
        }
        return mtdoConectar;
    }

    protected void finalized() {
        close();
    }

    public ResultSet executeQuery(String query) {
        ResultSet resultSet = null;
        try {

            resultSet = statement.executeQuery(query);

            return resultSet;
        } catch (Exception ex) {
            ex.printStackTrace();
//            showMessage( query );
        }

        return resultSet;
    }

    public boolean executeUpdate(String query) {

        try {
            statement.executeUpdate(query);
        } catch (Exception ex) {
            ex.printStackTrace();


            return false;
        }
        return true;
    }

    public void close() {
        try {
            statement.close();
            connection.close();
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();

        }
    }
//
//----------------- metodos auxiliares da classe -------------------------------
//    devolve o proximo numero de uma determinada tabela

    public static int getNextNumber(String tabela) {
        String sql = "SELECT MAX(Codigo) AS MAX FROM " + tabela;

        ResultSet rs = new BDConexao().executeQuery(sql);
        int next = 0;

        try {
            if (rs.next()) {
                next = rs.getInt("MAX");
            }
        } catch (SQLException ex) {
            return next + 1;
        }

        return next + 1;
    }

    //devolve um vector de items duma determinada tabela
    public static Vector getItems(String tabela, int numeroDoCampo) {
        String sql = "SELECT * FROM " + tabela + " order by " + numeroDoCampo;

        ResultSet rs = new BDConexao().executeQuery(sql);
        Vector items = new Vector();

        try {
            while (rs.next()) {
                items.add(rs.getString(numeroDoCampo));
            }
        } catch (SQLException ex) {
            return items;
        }

        return items;
    }

    //devolve um vector de items duma determinada tabela
    public Vector getPrevilegiosUser(int codigoUtilizador) {
        Vector vect = getCodigoPrevilegiosUser(codigoUtilizador);

        for (int i = 0; i < vect.size(); ++i) {
            vect.add(BDConexao.getDesignacao("tipos_permissoes", Integer.parseInt(String.valueOf(vect.elementAt(i)))));
        }

        return vect;
    }

    public Vector getCodigoPrevilegiosUser(int codigoUtilizador) {
        String sql = "SELECT CodigoTipoPermissao FROM utilizadores_permissoes where CodigoUtilizador = " + codigoUtilizador;

        ResultSet rs = new BDConexao().executeQuery(sql);
        Vector items = new Vector();

        try {
            while (rs.next()) {
                items.add(rs.getInt("CodigoTipoPermissao"));
            }
        } catch (SQLException ex) {
            return items;
        }

        return items;
    }

    public static void showMessage(String msg, String titulo, int type) {
        JOptionPane.showMessageDialog(null, msg, titulo, type);
    }

    public static void showMessage(String msg) {
        JOptionPane.showMessageDialog(null, msg);
    }

    //devolve o codigo de uma determinada tabela
    public int getCodigo(String tabela, String descricao) {
        String sql = "SELECT Codigo FROM " + tabela + " WHERE(Designacao = '" + descricao.trim() + "')";

        ResultSet rs = executeQuery(sql);

        try {
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException ex) {
            return 0;
        }

        return 0;
    }

    public static int getLastEntrega() {
        String sql = "select Max(\"idEntrega\") as last from entregas";
        ResultSet rs = new BDConexao().executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getInt("last");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    //devolve a designacao de uma determinada tabela
    public static String getDesignacao(String tabela, int codigo) {
        String sql = "SELECT Designacao FROM " + tabela + " WHERE(Codigo = " + codigo + ")";

        ResultSet rs = new BDConexao().executeQuery(sql);

        try {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            return "";
        }

        return "";
    }

    public static String getNomeCompleto(String userName) {
        String sql = "select \"nomeCompleto\" from usuarios where \"username\" = '" + userName + "'";
        ResultSet rs = new BDConexao().executeQuery(sql);

        try {
            if (rs.next()) {
                return rs.getString(1);
            }
        } catch (SQLException ex) {
            return "";
        }

        return "";
    }

    //verifica se 1 determinado item existe na tabela
    public static boolean existe(String tabela, String item, String nomeCampo) {
        String sql = "SELECT Id FROM " + tabela + " WHERE(" + nomeCampo + " = '" + item + "')";

        ResultSet rs = new BDConexao().executeQuery(sql);

        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public static boolean existe2(String tabela, int item, String nomeCampo) {
        String sql = "SELECT Id FROM " + tabela + " WHERE(" + nomeCampo + " = " + item + ")";

        ResultSet rs = new BDConexao().executeQuery(sql);

        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    //verifica se a pass eh igual a de administrador
//    public static boolean passwordAdminValido(String user, String passProcurada) {
//        BDConexao conexao = new BDConexao();
//
//        String sql = "SELECT Id FROM utilizadores WHERE(Password = md5('" + passProcurada + "') AND CodigoStatus = 1 And CodigoTipoUtilizador = 1)";
//
//        ResultSet rs = conexao.executeQuery(sql);
//        System.out.println(sql);
//        try {
//            if (rs.next()) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            return false;
//        }
//        return false;
//    }
//
//    public static boolean userExistente(String username, String password) {
//        BDConexao conexao = new BDConexao();
//        String sql = "select Id from utilizadores where(Username = '" + username.trim() + "' And CodigoStatus = 1 And Password = md5('" + password.trim() + "'))";
//        ResultSet rs = conexao.executeQuery(sql);
//
//        try {
//            if (rs.next()) {
//                return true;
//            }
//        } catch (SQLException ex) {
//            return false;
//        }
//        return false;
//    }
//
//    //devolve o codigo de uma determinada tabela
//
//    public static int getCodigoByName(String tabela, String campoProcurado, String descricao) {
//        String sql = "SELECT Id FROM " + tabela + " WHERE(" + campoProcurado + " = '" + descricao.trim() + "')";
//
//        ResultSet rs = new BDConexao().executeQuery(sql);
//
//        try {
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            return 0;
//        }
//
//        return 0;
//    }
//
//    //usado para obter o codigo de uma tabela onde o campo = 1 determinado codigo q eh FK
//    public static int getCodigoByCodigo(String tabela, String campoProcurado, int codigo) {
//        String sql = "SELECT Id FROM " + tabela + " WHERE(" + campoProcurado + " = " + codigo + ")";
//
//        ResultSet rs = new BDConexao().executeQuery(sql);
//
//        try {
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            return 0;
//        }
//
//        return 0;
//    }
//
//    //usado para obter o codigo de uma tabela onde o campo = 1 determinado codigo q eh FK
//    public static int getCodigoByCodigo2(String tabela, String campoActual, String campoProcurado, int codigo) {
//        String sql = "SELECT " + campoActual + " FROM " + tabela + " WHERE(" + campoProcurado + " = " + codigo + ")";
//
//        ResultSet rs = new BDConexao().executeQuery(sql);
//
//        try {
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            return 0;
//        }
//        return 0;
//    }
//
//    //usado para obter o codigo de uma tabela onde o campo = 1 determinado codigo q eh FK
//    public static int getCodigoByDesignacao2(String tabela, String campoActual, String campoProcurado, String designacao) {
//        String sql = "SELECT " + campoActual + " FROM " + tabela + " WHERE(" + campoProcurado + " = '" + designacao + "')";
//
//        ResultSet rs = new BDConexao().executeQuery(sql);
//
//        try {
//            if (rs.next()) {
//                return rs.getInt(1);
//            }
//        } catch (SQLException ex) {
//            return 0;
//        }
//
//        return 0;
//    }
//
//    //usado para obter o codigo de uma tabela onde o campo = 1 determinado codigo q eh FK
//    public static String getDesignacaoByCodigo(String tabela, String campoActual, String campoProcurado, int codigo) {
//        String sql = "SELECT " + campoActual + " FROM " + tabela + " WHERE(" + campoProcurado + " = " + codigo + ")";
//
//        ResultSet rs = new BDConexao().executeQuery(sql);
//
//        try {
//            if (rs.next()) {
//                return rs.getString(1);
//            }
//        } catch (SQLException ex) {
//            return "";
//        }
//
//        return "";
//    }
//
    public Vector getItemsWhereByCodigo(String tabela, String campo, String campoProcurado, int campoEscolhido) {
        String sql = "SELECT " + campo + " FROM " + tabela + " WHERE(" + campoProcurado + " = " + campoEscolhido + ") order by " + campo;

        ResultSet rs = executeQuery(sql);

        Vector vector = new Vector();

        try {
            while (rs.next()) {
                vector.add(rs.getString(campo));
            }
        } catch (SQLException ex) {
            //ex.printStackTrace();
            return vector;
        }

        return vector;
    }

    public Vector getItemsWhereByDesignacao(String tabela, String campo, String campoProcurado, String campoEscolhido) {
        String sql = "SELECT " + campo + " FROM " + tabela + " WHERE(campoProcurado = '" + campoEscolhido + "' ) order by " + campo;

        ResultSet rs = executeQuery(sql);

        Vector vector = new Vector();

        try {
            while (rs.next()) {
                vector.add(rs.getString(campo));
            }
        } catch (SQLException ex) {
            return vector;
        }

        return vector;
    }

    public static int getExistenciaProduto(int codProduto) {
        String sql = "select Existencia from produtos where Codigo = " + codProduto;
        ResultSet rs = new BDConexao().executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getInt("Existencia");
            }
        } catch (SQLException ex) {
            return 0;
        }
        return 0;
    }

    public static int getSaldoFornecedor(int codFornecedor) {
        String sql = "select Saldo from fornecedores where Codigo = " + codFornecedor;
        ResultSet rs = new BDConexao().executeQuery(sql);
        try {
            if (rs.next()) {
                return rs.getInt("Saldo");
            }
        } catch (SQLException ex) {
            return 0;
        }
        return 0;
    }

    public static boolean actualizarSaldoFornecedor(int codFornecedor, float entrada) {
        float saldoAntigo = getSaldoFornecedor(codFornecedor);
        float saldoActual = saldoAntigo + entrada;

        String sql = "update fornecedores set Saldo = " + saldoActual + " where Codigo = " + codFornecedor;
        if (new BDConexao().executeUpdate(sql)) {
            return true;
        }
        return false;
    }

    public static boolean actualizarExistenciaProduto(int codProduto, float entrada) {
        float existenciaAntiga = getExistenciaProduto(codProduto);
        float existenciaActual = existenciaAntiga + entrada;

        String sql = "update produtos set Existencia = " + existenciaActual + " where Codigo = " + codProduto;
        if (new BDConexao().executeUpdate(sql)) {
            return true;
        }
        return false;
    }

    public Vector getElementosLike(String tabela, String campo, String prefixo) {
        String sql = "SELECT " + campo + " FROM " + tabela + " WHERE(" + campo + " LIKE '" + prefixo + "%' ) order by " + campo;

        ResultSet rs = executeQuery(sql);

        Vector vector = new Vector();

        try {
            while (rs.next()) {
                vector.add(rs.getString(campo));
            }
        } catch (SQLException ex) {
            return vector;
        }

        return vector;
    }

    public Vector getElementos(String tabela, String campo) {
        String sql = "SELECT " + campo + " FROM " + tabela + " Order By " + campo;

        ResultSet rs = executeQuery(sql);

        Vector vector = new Vector();

        try {
            while (rs.next()) {
                vector.add(rs.getString(campo).trim());
            }
        } catch (SQLException ex) {
            return vector;
        }

        return vector;
    }

    public static boolean itemJaExistente(String item, String tabela, String campo) {
        String sql = "SELECT Codigo FROM " + tabela + " WHERE(" + campo + " = '" + item.trim().toUpperCase() + "')";

        ResultSet rs = new BDConexao().executeQuery(sql);

        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public static boolean itemJaExistente2(int item, String tabela, String campo) {
        String sql = "SELECT Codigo FROM " + tabela + " WHERE(" + campo + " = " + item + ")";

        ResultSet rs = new BDConexao().executeQuery(sql);

        try {
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            return false;
        }
        return false;
    }

    public float getSaldoDoDia(String data, int codigoUtilizador) {
        String sql = "SELECT SUM(TotalPreco) as total FROM factura  WHERE(Date(DataFactura) = '" + data + "' And CodigoUtilizador = " + codigoUtilizador + ")";

        ResultSet rs = executeQuery(sql);

        try {
            if (rs.next()) {
                return rs.getFloat("total");
            }
        } catch (SQLException ex) {
            return 0;
        }
        return 0;
    }
}
