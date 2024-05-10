package com.mycompany.prueba.Persistencia;

import com.mycompany.prueba.Logica.Duenio;
import com.mycompany.prueba.Logica.Mascota;
import com.mycompany.prueba.Persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ControladoraPersistencia {
    DuenioJpaController controlDuenio = new DuenioJpaController();
    MascotaJpaController controlMascota = new MascotaJpaController();

    public void guardar(Duenio duenio, Mascota mascota) {
        //crear en la BD el dueño
        controlDuenio.create(duenio);
        //crear en la Bd la mascota
        controlMascota.create(mascota);
    }

    public List<Mascota> traerMascotas() {
        return controlMascota.findMascotaEntities();
    }

    public void borrarMascota(int num_cliente) {
        try {
            controlMascota.destroy(num_cliente);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public Mascota traerMascota(int num_cliente) {
        return controlMascota.findMascota(num_cliente);
        
    }

    public void modificarMascota(Mascota masco) {
        try {
            controlMascota.edit(masco);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Duenio traerDuenio(int id_duenio) {
        return controlDuenio.findDuenio(id_duenio);
    }

    public void modificarDuenio(Duenio duenio) {
        try {
            controlDuenio.edit(duenio);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
