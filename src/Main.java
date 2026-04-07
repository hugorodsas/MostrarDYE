import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url="jdbc:oracle:thin:@localhost:1521:xe";
        String user="RIBERA";
        String password="ribera";

        try (Connection conn = DriverManager.getConnection(url,user,password);
             Statement statement = conn.createStatement()){
            String sql="SELECT empleado3.nombre as empleado_nombre, empleado3.salario, departamento3.nombre as departamento_nombre "+
                    "FROM empleado3 " +
                    "INNER JOIN departamento3 ON empleado3.departamento_id=departamento3.id "+
                    "WHERE departamento3.nombre='Recursos Humanos' " +
                    "ORDER BY departamento3.nombre";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                String empleado=resultSet.getString("empleado_nombre");
                double salario=resultSet.getDouble("salario");
                String departamento=resultSet.getString("departamento_nombre");
                System.out.println(empleado+","+salario+","+departamento);
            }
        }catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
