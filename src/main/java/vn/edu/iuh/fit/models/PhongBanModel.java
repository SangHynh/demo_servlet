package vn.edu.iuh.fit.models;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import vn.edu.iuh.fit.dtos.PhongBan;

import java.util.List;

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
            // Xử lý ngoại lệ (ghi log hoặc ném ra motch&)
            throw new RuntimeException("Error while adding phong ban: " + e.getMessage(), e);
        }
    }

    // Lấy danh sách phòng ban
    public List<PhongBan>  listPhongBan(){
        TypedQuery <PhongBan> q = entityManager.createQuery("select p from PhongBan p", PhongBan.class);
        return q.getResultList();
    }

    // Tìm theo Id
    public PhongBan listPhongBan(long id) {
        TypedQuery<PhongBan> q = entityManager.createQuery("select p from PhongBan p where p.maPhongBan=:id", PhongBan.class);
        q.setParameter("id", id);
        return q.getSingleResult();
    }

    // Update PhongBan by ID
    @Transactional
    public void updatePhongBan(long id, String newTenPhongBan) {
        try {
            PhongBan phongBan = entityManager.find(PhongBan.class, id);
            if (phongBan != null) {
                phongBan.setTenPhongBan(newTenPhongBan);
                entityManager.merge(phongBan); // Update the entity
            } else {
                throw new RuntimeException("PhongBan not found for ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while updating phong ban: " + e.getMessage(), e);
        }
    }

    // Delete PhongBan by ID
    @Transactional
    public void deletePhongBan(long id) {
        try {
            PhongBan phongBan = entityManager.find(PhongBan.class, id);
            if (phongBan != null) {
                entityManager.remove(phongBan); // Remove the entity
            } else {
                throw new RuntimeException("PhongBan not found for ID: " + id);
            }
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting phong ban: " + e.getMessage(), e);
        }
    }
}
