package com.mycompany.prueba.Logica;

import com.mycompany.prueba.Persistencia.ControladoraPersistencia;
import java.util.List;

public class ControladoraLogica {
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();

    public void guardar(String nombreMascota, String raza, String color, String observaciones, String nombreDuenio, String celDuenio, String alergico, String atencion, String direccion) {
        //creamos el dueño y asignamos sus valores
        Duenio duenio = new Duenio();
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(celDuenio);
        duenio.setDireccion(direccion);
        //creamos la mascota y asignamos sus valores
        Mascota mascota = new Mascota();
        mascota.setNombre(nombreMascota);
        mascota.setRaza(raza);
        mascota.setColor(color);
        mascota.setAlergico(alergico);
        mascota.setAtencion(atencion);
        mascota.setObservaciones(observaciones);
        mascota.setDuenio(duenio);
        
        controlPersis.guardar(duenio,mascota);
    }

    public List <Mascota> traerMascotas() {
        return controlPersis.traerMascotas();
    }

    public void borrarMascota(int num_cliente) {
        controlPersis.borrarMascota(num_cliente);
    }

    public void editarMascota(int num_cliente) {
        
    }

    public Mascota traerMascota(int num_cliente) {
        return controlPersis.traerMascota(num_cliente);
    }

    public void modificarMascota(Mascota masco, String nombreMascota, String raza, String color, 
            String observaciones, String nombreDuenio, String celDuenio, String alergico, 
            String atencion, String direccion) {
        masco.setNombre(nombreMascota);
        masco.setRaza(raza);
        masco.setColor(color);
        masco.setObservaciones(observaciones);
        masco.setAlergico(alergico);
        masco.setAtencion(atencion);
        
        
        //modifico mascota
        controlPersis.modificarMascota(masco);
        //seteo los valores del dueño
        Duenio duenio = this.buscarDuenio(masco.getDuenio().getId_duenio());
        duenio.setNombre(nombreDuenio);
        duenio.setCelular(celDuenio);
        duenio.setDireccion(direccion);
        
        //llamar al modificar dueño
        this.modificarDuenio(duenio);
    }

    private Duenio buscarDuenio(int id_duenio) {
        return controlPersis.traerDuenio(id_duenio);
    }

    private void modificarDuenio(Duenio duenio) {
        controlPersis.modificarDuenio(duenio);
    }
}
