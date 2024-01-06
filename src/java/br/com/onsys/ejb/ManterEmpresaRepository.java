package br.com.onsys.ejb;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.bb.amb.jpa.persistenciadao.BBTSGenericDAO;
import br.com.onsys.constants.ManterEmpresaConstant;
import br.com.onsys.util.ManterEmpresaClassUtil;

@Dependent
public class ManterEmpresaRepository<T extends Serializable> extends BBTSGenericDAO<T> implements Serializable {

	private static final long serialVersionUID = 1L;


	@Produces
	@RequestScoped
	public EntityManagerFactory createEntityManagerFactory() {
		return Persistence.createEntityManagerFactory(ManterEmpresaConstant.PERSISTENCE_UNIT_MANTER_EMPRESA);
	}
	
	@Produces
	@Default
	@RequestScoped
	public EntityManager createEntityManager() {
		return this.createEntityManagerFactory().createEntityManager();
	}
	
	public void dispose(@Disposes @Default EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		super.setEntityManager(createEntityManager());
		try {
			super.setClazzForName(
					(Class<T>) Class.forName(ManterEmpresaClassUtil.getCanonicalNamePorTipoGenericsSadc(this.getClass(),
							ManterEmpresaConstant.PACKAGE_SCAN_MODEL_EMPRESA)));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
