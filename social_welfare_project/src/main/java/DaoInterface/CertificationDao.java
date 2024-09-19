/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.Certification;

/**
 *
 * @author Maninder Singh
 */
public interface CertificationDao {
    void addCertification(Certification certification);
    void updateCertification(Certification certification);
    void deleteCertification(Integer certificationId);
    Certification getCertificationById(Integer certificationId);
    List<Certification> getAllCertifications();
}
