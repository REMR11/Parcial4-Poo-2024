package com.parcialpoo.ufg.MR100823.services.Costumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.parcialpoo.ufg.MR100823.models.Costumer;
import com.parcialpoo.ufg.MR100823.repository.CostumerRepository;

/**
 * Servicio para manejar las operaciones de la entidad Costumer.
 *
 * @author remr1
 *  */
public class CostumerService implements ICostumerService {

    /**
     * Inyección de dependencia de la interfaz CostumerRepository.
     */
    @Autowired
    private CostumerRepository costumerRepository;

    /**
     * Verifica si un usuario y contraseña son iguales a los registros en la base de datos.
     *
     * @param pUsername el nombre de usuario a verificar.
     * @param pPassword la contraseña a verificar.
     * @return true si el usuario y contraseña son válidos, false en caso contrario.
     */
    public boolean login(String pUsername, String pPassword) {
        try {
            Costumer costumer = costumerRepository.findByUserName(pUsername);
            if (costumer != null && costumer.getPassword().equals(pPassword)) {
                return true;
            }
            return false;
        } catch (Exception e) {
            System.out.println("Error al verificar credenciales: " + e.getMessage());
            return false;
        }
    }

    /**
     * Obtiene una lista con todas las entidades Costumer almacenadas en la base de datos.
     *
     * @return una lista con todas las entidades Costumer.
     */
    @Override
    public List<Costumer> showAll() {
        try {
            return costumerRepository.findAll();
        } catch (Exception e) {
            System.out.println("Error al obtener lista de costumers: " + e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene una entidad Costumer específica por su ID.
     *
     * @param pCostumer_Id el ID de la entidad Costumer a obtener.
     * @return la entidad Costumer correspondiente al ID dado, o null si no se encuentra.
     */
    @Override
    public Costumer FindById(Integer pCostumer_Id) {
        try {
            Costumer costumer = costumerRepository.findById(pCostumer_Id).orElse(null);
            return costumer;
        } catch (Exception e) {
            System.out.println("Error al obtener costumer por ID: " + e.getMessage());
            return null;
        }
    }

    /**
     * Guarda una entidad Costumer en la base de datos.
     *
     * @param pCoscutmer la entidad Costumer a guardar.
     */
    @Override
    public void saveCostumer(Costumer pCoscutmer) {
        try {
            costumerRepository.save(pCoscutmer);
        } catch (Exception e) {
            System.out.println("Error al guardar costumer: " + e.getMessage());
        }
    }

    /**
     * Elimina una entidad Costumer de la base de datos.
     *
     * @param pCostumer la entidad Costumer a eliminar.
     */
    @Override
    public void deleteCostumer(Costumer pCostumer) {
        try {
            costumerRepository.delete(pCostumer);
        } catch (Exception e) {
            System.out.println("Error al eliminar costumer: " + e.getMessage());
        }
    }

}