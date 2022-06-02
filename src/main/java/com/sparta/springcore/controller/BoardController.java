package com.sparta.springcore.controller;

import com.sparta.springcore.service.BoardService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequiredArgsConstructor
public class BoardController
{
    private final BoardService boardService;

    @GetMapping("/boards")
    public ResponseEntity<Result> viewAll()
    {
        List<BoardDetailListResponseDTO> responses = boardService.findAll()
                .stream()
                .map(b ->
                        BoardDetailListResponseDTO.builder() // bulider를 사용하여 원하는 값 삽입
                                .id(b.getId())
                                .title(b.getTitle())
                                .createdAt(b.getCreatedAt())
                                .build() // build 메서드로 스트림을 리턴
                ).collect(Collectors.toList()); // 스트림을 리스트 형식으로 만든다.
        return ResponseEntity.ok(new Result(responses)); // ok로 응답받는다.
    }

    @AllArgsConstructor
    @Data
    static class Result {
        private List<BoardDetailListResponseDTO> data;
    }

    @Data
    @Builder
    static class BoardDetailListResponseDTO {
        private final Long id;
        private final String title;
        private final String author;
        private final LocalDateTime createdAt;
    }
}
