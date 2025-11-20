package Clinica.ApiConsultorio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Servicio {

    @Autowired
    private Repositorio repo;

    public Consultorio grabar(Consultorio con) {
        return repo.save(con);
    }

    public Consultorio buscar(Long id) {
        return repo.findById(id).orElse(null);
    }

    public List<Consultorio> listar() {
        return repo.findAll();
    }

    public Consultorio actualizar(Long id, Consultorio con) {
        return repo.findById(id).map(existing -> {
            existing.setDes(con.getDes());
            existing.setEst(con.getEst());
            return repo.save(existing);
        }).orElse(null);
    }

    public void eliminar(Long id) {
        repo.deleteById(id);
    }
}
