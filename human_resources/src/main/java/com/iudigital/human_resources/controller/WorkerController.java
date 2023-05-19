
package com.iudigital.human_resources.controller;
/**
 * Juan Camilo Jimenez Este archivo me va a servir como puente entre el
 * workerDao y el Main
 */
import com.iudigital.human_resources.data.WorkerDao;
import com.iudigital.human_resources.domain.Worker;
import java.sql.SQLException;
import java.util.List;

public class WorkerController {

    private WorkerDao workerDao;

    public WorkerController() {
        workerDao = new WorkerDao();
    }

    public List<Worker> getWorkers() throws SQLException {
        return workerDao.getWorkers();
    }

    public void createWorker(Worker worker) throws SQLException {
        workerDao.create(worker);
    }

    public Worker getWorker(int id) throws SQLException {
        return workerDao.getWorker(id);
    }

    public void updateWorker(int id, Worker worker) throws SQLException {
        workerDao.updateworker(id, worker);
    }

    public void deleteWorker(int id) throws SQLException {
        workerDao.deleteworker(id);
    }
}
