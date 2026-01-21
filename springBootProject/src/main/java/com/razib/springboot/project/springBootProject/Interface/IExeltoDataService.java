package com.razib.springboot.project.springBootProject.Interface;

import com.razib.springboot.project.springBootProject.model.BulkStudent;

import java.util.List;

public interface IExeltoDataService {
    List<BulkStudent> getExcelDataAsList();

    int saveExcelData(List<BulkStudent> questions);
}
