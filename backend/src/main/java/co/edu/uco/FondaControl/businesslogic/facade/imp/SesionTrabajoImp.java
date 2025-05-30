package co.edu.uco.FondaControl.businesslogic.facade.imp;

import org.springframework.stereotype.Service;

import java.util.List;

import co.edu.uco.FondaControl.businesslogic.businesslogic.SesionTrabajoBusinessLogic;
import co.edu.uco.FondaControl.businesslogic.businesslogic.assembler.SesionTrabajo.dto.SesionTrabajoDTOAssembler;
import co.edu.uco.FondaControl.businesslogic.facade.SesionTrabajoFacade;
import co.edu.uco.FondaControl.crosscutting.excepciones.FondaControlException;
import co.edu.uco.FondaControl.crosscutting.utilitarios.UtilObjeto;
import co.edu.uco.FondaControl.dto.SesionTrabajoDTO;

@Service
public final class SesionTrabajoImp implements SesionTrabajoFacade {

    private final SesionTrabajoBusinessLogic businessLogic;

    public SesionTrabajoImp(final SesionTrabajoBusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @Override
    public void iniciarSesionTrabajo(final SesionTrabajoDTO sesionTrabajo) throws FondaControlException {
        if (UtilObjeto.esNulo(sesionTrabajo)) {
            throw new IllegalArgumentException("La sesión de trabajo no puede ser nula.");
        }

        var domain = SesionTrabajoDTOAssembler.getInstancia().toDomain(sesionTrabajo);
        businessLogic.iniciarSesionTrabajo(domain);
    }

    @Override
    public void cerrarSesionTrabajo(final SesionTrabajoDTO sesionTrabajo) throws FondaControlException {
        if (UtilObjeto.esNulo(sesionTrabajo)) {
            throw new IllegalArgumentException("La sesión de trabajo no puede ser nula.");
        }

        var domain = SesionTrabajoDTOAssembler.getInstancia().toDomain(sesionTrabajo);
        businessLogic.cerrarSesionTrabajo(domain);
    }

    @Override
    public List<SesionTrabajoDTO> consultarSesionTrabajo(SesionTrabajoDTO filtro) throws FondaControlException {
        if (UtilObjeto.esNulo(filtro)) {
            filtro = new SesionTrabajoDTO();
        }

        var domainFilter = SesionTrabajoDTOAssembler.getInstancia().toDomain(filtro);
        var domainList = businessLogic.consultarSesionTrabajo(domainFilter);
        return SesionTrabajoDTOAssembler.getInstancia().toDtoList(domainList);
    }
}
