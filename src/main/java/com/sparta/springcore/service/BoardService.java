package com.sparta.springcore.service;

import com.sparta.springcore.domain.Board;
import com.sparta.springcore.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor

public class BoardService
{
    private final BoardRepository boardRepository;

    public List<Board> findAll()
    {
        return boardRepository.findAll();
        // 정렬 일단 제외
    }

    public Optional<Board> findOne(Long id)
    {
        return boardRepository.findById(id);
    }

    public Long write(Board board)
    {
        boardRepository.save(board);
        return board.getId();
    }

    public boolean remove(Long id, String requestPassword) throws IllegalArgumentException
    {
        Optional<Board> board = boardRepository.findById(id);
        if (board.isPresent() && samePassword(board.get().getPassword(), requestPassword))
        {
            boardRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean samePassword(String password1, String password2)
    {
        return password1.equals(password2);
    }
}
