package com.lsis.sjleea.sjleea_app;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class MusicBean {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void addMusic(Music music)
    {
        entityManager.persist(music);
    }

    public Music find(long id) {
        return entityManager.find(Music.class, id);
    }

    public List<Music> getMusics()
    {
        CriteriaQuery<Music> cq = entityManager.getCriteriaBuilder().createQuery(Music.class);
        cq.select(cq.from(Music.class));

        return entityManager.createQuery(cq).getResultList();
    }

    @Transactional
    public void deleteMusic(Music music)
    {
        entityManager.remove(music);
    }

    @Transactional
    public void updateMusic(Music music)
    {
        entityManager.merge(music);
    }
}
