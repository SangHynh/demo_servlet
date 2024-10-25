package vn.edu.iuh.fit.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import vn.edu.iuh.fit.dtos.PhongBan;

import java.util.List;
import java.util.Optional;

public class PhongBanModel {
    @PersistenceContext(unitName = "demo")
    private EntityManager entityManager;

    @Transactional
    public void addPhongBan(String tenPhongBan) {
        try {
            PhongBan phongBan = new PhongBan();
            phongBan.setTenPhongBan(tenPhongBan);
            entityManager.persist(phongBan);
        } catch (Exception e) {
            throw new RuntimeException("Error while adding phong ban: " + e.getMessage(), e);
        }
    }

    public List<PhongBan> listPhongBan() {
        TypedQuery<PhongBan> q = entityManager.createQuery("SELECT p FROM PhongBan p", PhongBan.class);
        return q.getResultList();
    }

    public PhongBan findPhongBan(long id) {
        TypedQuery<PhongBan> q = entityManager.createQuery("SELECT p FROM PhongBan p WHERE p.id = :id", PhongBan.class);
        q.setParameter("id", id);
        return q.getResultStream().findFirst().orElse(null); // Trả về null nếu không tìm thấy
    }

    @Transactional
    public void updatePhongBan(long id, String newTenPhongBan) {
        try {
            PhongBan phongBan = entityManager.find(PhongBan.class, id);
            if (phongBan != null) {
                phongBan.setTenPhongBan(newTenPhongBan);
                entityManager.merge(phongBan);
            } else {
                throw new RuntimeException("PhongBan not found for ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while updating phong ban: " + e.getMessage(), e);
        }
    }

    @Transactional
    public void deletePhongBan(long id) {
        try {
            PhongBan phongBan = entityManager.find(PhongBan.class, id);
            if (phongBan != null) {
                entityManager.remove(phongBan);
            } else {
                throw new RuntimeException("PhongBan not found for ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting phong ban: " + e.getMessage(), e);
        }
    }
}
