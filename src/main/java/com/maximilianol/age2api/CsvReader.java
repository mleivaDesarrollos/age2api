/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maximilianol.age2api;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import java.io.File;
import java.util.Collections;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author zaktorius
 */
@Slf4j
public class CsvReader {
    public static <T> List<T> loadObjectList(Class<T> type, String fileName) {
    try {
        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withHeader();
        CsvMapper mapper = new CsvMapper();
        File file = new ClassPathResource(fileName).getFile();
        MappingIterator<T> readValues = 
          mapper.reader(type).with(bootstrapSchema).readValues(file);
        return readValues.readAll();
    } catch (Exception e) {
        log.error("Error occurred while loading object list from file " + fileName, e);
        return Collections.emptyList();
    }
}
    public static List<String[]> loadManyToManyRelationship(String fileName) {
    try {
        CsvMapper mapper = new CsvMapper();
        CsvSchema bootstrapSchema = CsvSchema.emptySchema().withSkipFirstDataRow(true);
        mapper.enable(CsvParser.Feature.WRAP_AS_ARRAY);
        File file = new ClassPathResource(fileName).getFile();
        MappingIterator<String[]> readValues = 
          mapper.reader(String[].class).with(bootstrapSchema).readValues(file);
        return readValues.readAll();
    } catch (Exception e) {
        log.error(
          "Error occurred while loading many to many relationship from file = " + fileName, e);
        return Collections.emptyList();
    }
}
}
