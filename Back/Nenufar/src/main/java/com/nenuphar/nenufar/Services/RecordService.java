package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Record;
import com.nenuphar.nenufar.Repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public Record getRecord(Long id)
    {
        Record temp = recordRepository.findOne(id);
        return infiniteLoopFix(temp);
    }

    public Record getPostedRecord(Record record){ return record;}

    public Record createRecord(int nbrCourses, Date deadlines)
    {
        Record record = new Record(nbrCourses, deadlines);
        recordRepository.save(record);
        return record;
    }

    private Record infiniteLoopFix(Record temp)
    {
        Record record = new Record();
        record.setId(temp.getId());
        record.setDeadlines(temp.getDeadlines());
        record.setNbrCourses(temp.getNbrCourses());
        //record.setUsers(temp.getUsers());
        record.setCourse(temp.getCourseID().getId());
        return record;
    }

    private List<Record> infiniteListProcess(List<Record> records)
    {
        for(int i=0; i<records.size(); i++)
        {
            Record temp = records.get(i);
            Record record = infiniteLoopFix(temp);
            records.set(i, record);
        }
        return records;
    }
}
