package com.nosql.mongo.repository;

import com.nosql.mongo.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepo
        extends MongoRepository<Book, Integer> {
}
