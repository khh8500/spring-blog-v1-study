package shop.mtcoding.blog.controller.board;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class BoardNativeRepository {

    private final EntityManager em;

    @Transactional
    public void deleteById(int id) {
        Query query = em.createNativeQuery("delete from board_tb where id=?", Board.class);
        query.setParameter(1, id);

        query.executeUpdate();
    }

    public Board findById(int id) {
        Query query = em.createNativeQuery("select * from board_tb where id =?", Board.class);
        query.setParameter(1, id);
        return (Board) query.getSingleResult();
    }

    public List<Board> findAll() {
        Query query = em.createNativeQuery("select * from board_tb order by id desc", Board.class);
        return query.getResultList();
    }
}
