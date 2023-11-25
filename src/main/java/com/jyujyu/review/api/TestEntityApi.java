package com.jyujyu.review.api;

import com.jyujyu.review.service.TestService;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class TestEntityApi {
    private final TestService testService;

    @PostMapping("/test/entity/create")
    public void createTestEntity(
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.create(request.getName(), request.getAge());
    }

    @DeleteMapping("/test/entity/{id}")
    public void deleteTestEntity(
            @PathVariable("id") Long id
    ) {
        testService.delete(id);
    }

    @PutMapping("/test/entity/{id}")
    public void putTestEntity(
            @PathVariable Long id,
            @RequestBody CreateTestEntityRequest request
    ) {
        testService.update(id, request.getName(), request.getAge());
    }

    @Getter
    public static class CreateTestEntityRequest {

        private String name;
        private Integer age;

        public CreateTestEntityRequest() {
        }

        @Builder
        public CreateTestEntityRequest(String name, Integer age) {
            this.name = name;
            this.age = age;
        }
    }
}
