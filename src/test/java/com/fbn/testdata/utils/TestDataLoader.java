package com.fbn.testdata.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class TestDataLoader {
    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static <T> T get(String fileName, String nodeName, Class<T> clazz){
        try{
            InputStream is = TestDataLoader.class
                    .getClassLoader()
                    .getResourceAsStream("testdata/" + fileName);

            if(is==null){
                throw new RuntimeException("Test data file not found: testdata/" + fileName);
            }

            JsonNode rootNode = objectMapper.readTree(is);
            JsonNode dataNode = rootNode.get(nodeName);

            if(dataNode == null){
                throw new RuntimeException("Node not found: " + nodeName);
            }

            return objectMapper.treeToValue(dataNode, clazz);
        }catch (Exception e){
            throw new RuntimeException("Failed to load test data", e);
        }
    }
}
