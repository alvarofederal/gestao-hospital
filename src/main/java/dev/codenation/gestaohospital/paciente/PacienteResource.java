package dev.codenation.gestaohospital.paciente;

import org.springframework.hateoas.ResourceSupport;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

public class PacienteResource extends ResourceSupport {
    Paciente paciente;

    public PacienteResource(Paciente paciente) {
        this.paciente = paciente;
        add(linkTo(PacienteController.class).slash(paciente.getCPF()).withRel("Paciente"));
    }

    public Paciente getPaciente() {
        return paciente;
    }
}
