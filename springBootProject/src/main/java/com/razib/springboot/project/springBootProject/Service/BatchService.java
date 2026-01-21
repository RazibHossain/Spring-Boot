package com.razib.springboot.project.springBootProject.Service;

import com.razib.springboot.project.springBootProject.Dao.BatchDao;
import com.razib.springboot.project.springBootProject.model.Batch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BatchService {

    @Autowired
    BatchDao batchDao;

    public void saveBatch(Batch batch){
        //add validation
        batchDao.save(batch);

    }
    public List<Batch> getBatch(){
       return batchDao.findAll();
    }
    public Batch findBatchById(Integer batchId){
       return batchDao.findById(batchId).orElseThrow(() -> new UsernameNotFoundException("User Name not found"));
    }
    public void updateBathById(Batch newbatch){
        Batch batch = batchDao.findById(newbatch.getId()).orElseThrow(()->new UsernameNotFoundException("Batch Not found"));
        batch.setDuration(batch.getDuration());
        batch.setStartDate(newbatch.getStartDate());
        batch.setEndDate(newbatch.getEndDate());
        batch.setStudentCapacity(newbatch.getStudentCapacity());
        batch.setTotalStudent(newbatch.getTotalStudent());
        batch.setArchived(newbatch.isArchived());
        batchDao.save(batch);
    }
    public void deleteById(Integer batchId){
        batchDao.deleteById(batchId);
    }
}
