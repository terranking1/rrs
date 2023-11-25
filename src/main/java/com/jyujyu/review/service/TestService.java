package com.jyujyu.review.service;

import com.jyujyu.review.model.TestEntity;
import com.jyujyu.review.repository.TestRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TestService {

    private final TestRepository testRepository;

    @Transactional
    public void create(String name, Integer age) {
        TestEntity testEntity = TestEntity.builder()
                .name(name)
                .age(age)
                .build();

        testRepository.save(testEntity);
    }

    @Transactional
    public void update(Long id, String name, Integer age) {
        TestEntity testEntity = testRepository.findById(id).orElseThrow();
        testEntity.changeNameAndAge(name, age);
        testRepository.save(testEntity);
    }

    @Transactional
    public void delete(Long id) {
        TestEntity testEntity = testRepository.findById(id).orElseThrow();
        testRepository.delete(testEntity);
    }

    public List<TestEntity> findAllByNameByJPA(String name) {
        return testRepository.findAllByName(name);

    }

    public List<TestEntity> findAllByNameByQuerydsl(String name) {
        return testRepository.findAllByNameByQuerydsl(name);
    }

}
