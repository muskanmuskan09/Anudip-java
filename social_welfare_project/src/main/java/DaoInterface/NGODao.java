/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DaoInterface;

import java.util.List;
import models.NGO;

/**
 *
 * @author Maninder Singh
 */
public interface NGODao {
        void addNGO(NGO ngo);
    void updateNGO(NGO ngo);
    void deleteNGO(Integer ngoId);
    NGO getNGOById(Integer ngoId);
    List<NGO> getAllNGOs();
    
}
