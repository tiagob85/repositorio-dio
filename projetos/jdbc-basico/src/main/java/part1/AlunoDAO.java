package part1;
import com.mysql.cj.x.protobuf.MysqlxPrepare;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class AlunoDAO {

    public List<Aluno> list(){
        List<Aluno> alunos = new ArrayList<>();


        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement prst = conn.prepareStatement("Select * from alunos");

            ResultSet rs = prst.executeQuery();

            while (rs.next()){
                Aluno aluno = new Aluno(
                        rs.getInt("id"),
                        rs.getString("nome"),
                        rs.getInt("idade"),
                        rs.getString("estado"));

                alunos.add(aluno);

            }

        }catch (Exception ex){

        }

        return alunos;
    }

    public Aluno getById(int id){
        Aluno aluno = new Aluno();

        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement prst = conn.prepareStatement("Select * from alunos");
            String sql = "select * from aluno where id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setIdade(rs.getInt("Idade"));
                aluno.setEstado(rs.getString("estado"));

            }

        }catch (Exception ex){

        }

        return aluno;
    }

    public void create(Aluno aluno){
        try (Connection conn = ConnectionFactory.getConnection()) {
            PreparedStatement prst = conn.prepareStatement("Select * from alunos");
            String sql = "insert into aluno(nome, idade, estado) values(?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(1, aluno.getIdade());
            stmt.setString(1, aluno.getEstado());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Inserção bem sucedida ! Foi adicionado "+ rowsAffected+ " linha.");

        }catch (SQLException ex){
            System.out.println("Falha na inserção do registro.");
            ex.printStackTrace();
        }
    }

    public void delete(int id){
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "delete from aluno where id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Registro apagado com sucesso ! Foi removida "+ rowsAffected+ " linha.");

        }catch (SQLException ex){
            System.out.println("Falha ao apagar o registro.");
            ex.printStackTrace();
        }
    }

    public void update(Aluno aluno){
        try (Connection conn = ConnectionFactory.getConnection()) {

            String sql = "update aluno set nome=?, idade=?, estado=? where id = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, aluno.getNome());
            stmt.setInt(2, aluno.getIdade());
            stmt.setString(3, aluno.getEstado());
            stmt.setInt(4, aluno.getId());

            int rowsAffected = stmt.executeUpdate();

            System.out.println("Registro alterado com sucesso ! Foi atualizado "+ rowsAffected+ " linha.");

        }catch (SQLException ex){
            System.out.println("Falha ao atualizar o registro.");
            ex.printStackTrace();
        }
    }

}
