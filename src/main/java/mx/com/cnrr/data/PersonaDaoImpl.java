package mx.com.cnrr.data;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import mx.com.cnrr.domain.Persona;

/**
 * @author ClaudioNicolas
 */
@Stateless
public class PersonaDaoImpl implements PersonaDao {
    
    @PersistenceContext(unitName = "PersonaPU")
    EntityManager em;
    
    @Override
    public List<Persona> encontrarTodasPersonas() {
        return em.createNamedQuery("Persona.encontrarTodasPersonas").getResultList();
    }
    
    @Override
    public Persona encontrarPersona(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }
    
    @Override
    public void insertarPersona(Persona persona) {
        em.persist(persona);
        em.flush();
    }
    
    @Override
    public void actualizarPersona(Persona persona) {
        em.merge(persona);
    }
    
    @Override
    public void eliminarPersona(Persona persona) {
        em.remove(em.merge(persona));
    }
    
}
