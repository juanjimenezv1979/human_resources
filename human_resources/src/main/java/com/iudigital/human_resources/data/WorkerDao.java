
package com.iudigital.human_resources.data;

import com.iudigital.human_resources.domain.Worker;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.iudigital.human_resources.util.ConnectionUtil;

/**
 * @Juan Camilo Jimenez V esta clase tiene como funcion conectar a la base da
 * datos y realizar las operaciones CRUD, esta es toda la logica de acceso a
 * datos.
 *
 */
public class WorkerDao {

    private static final String GET_WORKER = "select * from  worker";

    private static final String CREATE_WORKER = "INSERT into worker (identification_number, names, surnames, sex, adress, phone, birthdate) "
            + "VALUES (?,?,?,?,?,?,?)";
    private static final String GET_WORKER_BY_ID = "select * from worker where id = ? ";

    private static final String UPDATE_WORKER = "update worker set identification_number = ?, names = ?, surnames = ?, sex = ?, adress = ?, "
            + "phone = ?, birthdate = ? where id = ?";
    private static final String DELETE_WORKER = "delete from worker where id = ?";

    public List<Worker> getWorkers() throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Worker> workers = new ArrayList<>();

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_WORKER);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Worker worker = new Worker();
                worker.setId(resultSet.getInt("id"));
                worker.setIdentification_number(resultSet.getString("Numero de Identificacion"));
                worker.setNames(resultSet.getString("Nombres"));
                worker.setSurnames(resultSet.getString("Apellidos"));
                worker.setSex(resultSet.getString("Sexo"));
                worker.setAdress(resultSet.getString("Direccion Residencial"));
                worker.setPhone(resultSet.getString("Numero Telefonico"));
                worker.setBirthdate(resultSet.getDate("Fecha de Nacimiento"));
                workers.add(worker);
            }
            return workers;
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
    }
    public void create(Worker worker) throws SQLException{
        
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(CREATE_WORKER);
            preparedStatement.setString(1, worker.getIdentification_number());
            preparedStatement.setString(2, worker.getNames());
            preparedStatement.setString(3, worker.getSurnames());
            preparedStatement.setString(4, worker.getSex());
            preparedStatement.setString(5, worker.getAdress());
            preparedStatement.setString(6, worker.getPhone());
            preparedStatement.setDate(7, worker.getBirthdate());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

    public Worker getWorker(int id) throws SQLException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Worker worker = null;

        try {
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(GET_WORKER_BY_ID);
            preparedStatement.setInt(1, id);
            resultSet = preparedStatement.executeQuery();
      
        if (resultSet.next()) {
            worker = new Worker();
            worker.setId(resultSet.getInt("id"));
            worker.setIdentification_number(resultSet.getString("Numero de Identificacion"));
            worker.setNames(resultSet.getString("Nombres"));
            worker.setSurnames(resultSet.getString("Apellidos"));
            worker.setSex(resultSet.getString("Sexo"));
            worker.setAdress(resultSet.getString("Direccion Residencial"));
            worker.setPhone(resultSet.getString("Telefono"));
            worker.setBirthdate(resultSet.getDate("Fecha de Nacimiento"));

        }
        return worker;
        
    } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        } 
}

public void updateworker(int id, Worker worker) throws SQLException {
            Connection connection = null;
            PreparedStatement preparedStatement = null;
            
        try{
            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareCall(UPDATE_WORKER);

            preparedStatement.setString(1, worker.getIdentification_number());
            preparedStatement.setString(2, worker.getNames());
            preparedStatement.setString(3, worker.getSurnames());
            preparedStatement.setString(4, worker.getSex());
            preparedStatement.setString(5, worker.getAdress());
            preparedStatement.setString(6, worker.getPhone());
            preparedStatement.setDate(7, worker.getBirthdate());
            preparedStatement.setInt(8,worker.getId());
            preparedStatement.executeUpdate();
            } finally {
              if (connection != null) {
                connection.close();
            }
               if (preparedStatement != null) {
                    preparedStatement.close();
            }  
            }       
        }

public void deleteworker (int id) throws SQLException{

            Connection connection = null;
            PreparedStatement preparedStatement = null;

        try{

            connection = ConnectionUtil.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_WORKER);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            } finally {
              if (connection != null) {
                connection.close();
            }
               if (preparedStatement != null) {
                    preparedStatement.close();
            }  
            }      

    }
}
