
package Clinica.ApiConsultorio;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultorio")
public class Control {
    
    @Autowired
    private Servicio serv;
    
    @PostMapping("/grabar")
    public Consultorio grabar(@RequestBody Consultorio con) {
        return serv.grabar(con);
    }

    @GetMapping("/buscar/{id}")
    public Consultorio buscar(@PathVariable Long id) {
        return serv.buscar(id);
    }

    @GetMapping("/listar")
    public List<Consultorio> listar() {
        return serv.listar();
    }

    @PutMapping("/actualizar/{id}")
    public Consultorio actualizar(@PathVariable Long id, @RequestBody Consultorio con) {
        return serv.actualizar(id, con);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable Long id) {
        serv.eliminar(id);
    }
}
