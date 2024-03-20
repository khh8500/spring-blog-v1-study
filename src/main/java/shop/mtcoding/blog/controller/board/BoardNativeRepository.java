package shop.mtcoding.blog.controller.board;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class BoardNativeRepository {

    private final EntityManager em;

}
