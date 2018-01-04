package com.nenuphar.nenufar.Services;

import com.nenuphar.nenufar.Models.Record;
import com.nenuphar.nenufar.Repositories.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecordService {

    @Autowired
    private RecordRepository recordRepository;

    public Record getRecord(Long id){ return recordRepository.findOne(id);}

    public Record getPostedRecord(Record record){ return record;}

    public Record createRecord(int nbrCourses, Date deadlines)
    {
        Record record = new Record(nbrCourses, deadlines);
        recordRepository.save(record);
        return record;
    }
}
