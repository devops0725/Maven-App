package com.example;

import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.fasterxml.jackson.databind.ObjectMapper;

public class App {
    private static final Logger logger = LogManager.getLogger(App.class);
    public static void main(String[] args) {
        System.out.println("Hello, Maven with a vulnerable dependency!");
        // Example usage of the vulnerable dependency
        Bag bag = new HashBag();
        bag.add("apple", 3);
        bag.add("banana");
        System.out.println("Bag contains: " + bag);
        
        if (args.length > 0) {
            logger.error("User input: " + args[0]);
        }
        
        String maliciousJson = "{\"@class\":\"com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl\",\"_bytecodes\":[\"AA==\"],\"_name\":\"a\",\"_tfactory\":{},\"_outputProperties\":{}}";
        ObjectMapper mapper = new ObjectMapper();
        try {
            Object obj = mapper.readValue(maliciousJson, Object.class);
            System.out.println("Deserialized object: " + obj);
        } catch (Exception e) {
            System.out.println("Exception during deserialization: " + e.getMessage());
        }
    }
}
