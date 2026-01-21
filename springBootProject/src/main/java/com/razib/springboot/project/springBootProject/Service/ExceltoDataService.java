package com.razib.springboot.project.springBootProject.Service;

import com.razib.springboot.project.springBootProject.Interface.IExeltoDataService;
import com.razib.springboot.project.springBootProject.model.BulkStudent;
import com.sun.rowset.internal.Row;
import javafx.scene.control.Cell;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class ExceltoDataService implements IExeltoDataService {
    @Value("${app.upload.file:${user.home}}")
    public String EXCEL_FILE_PATH;

    Workbook workbook;


    @Override
    public List<BulkStudent> getExcelDataAsList() {

        List<String> list = new ArrayList<>();

        DataFormatter dataFormatter = new DataFormatter();

        try {
            workbook = WorkbookFactory.create(new File(EXCEL_FILE_PATH));
        } catch (EncryptedDocumentException | IOException e) {
            e.printStackTrace();
        }

        Sheet sheet = workbook.getSheetAt(0);
        int noOfColumns = sheet.getRow(0).getLastCellNum();

        // Using for-each loop to iterate over the rows and columns
        for (org.apache.poi.ss.usermodel.Row row : sheet) {
            for (org.apache.poi.ss.usermodel.Cell cell : row) {
                String cellValue = dataFormatter.formatCellValue(cell);
                list.add(cellValue);
            }
        }
        List<BulkStudent> bulkStudentList = createList(list, noOfColumns);

        // Closing the workbook
        try {
            workbook.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return null;
    }
    private List<BulkStudent> createList(List<String> excelData, int noOfColumns) {

        ArrayList<BulkStudent> bulkStudents = new ArrayList<>();

        int i = noOfColumns;

        do {
            BulkStudent bulkStudent = new BulkStudent();

            bulkStudent.setId(excelData.get(i));
            bulkStudent.setStudentName(excelData.get(i+1));
//            bulkStudent.setRank(Integer.parseInt(excelData.get(i+2)));

            bulkStudents.add(bulkStudent);
            i = i + (noOfColumns);

        } while (i < excelData.size());

        return bulkStudents;
    }

    @Override
    public int saveExcelData(List<BulkStudent> BulkStudents) {
//        questions = questionDao.saveAll(questions);
//        return questions.size();
//
        return 0;
    }
}
