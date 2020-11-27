package fr.lsi.jarvis.infrastructure.generic;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Session;

/**
 * Classe abstraite pour les repo
 *
 * @author Laurent SION
 *
 * @param <T> Entity Hibernate
 */
public abstract class AbstractJpaRepository<T extends EntityIO> {

	protected Class<T> entityClass;

	@PersistenceContext
	protected EntityManager em;

	@PostConstruct
	public void init() {
		this.entityClass = this.getEntityClass();
	}

	protected abstract Class<T> getEntityClass();

	protected Session getSession() {
		return this.em.unwrap(Session.class);
	}

	@Transactional
	public T save(final T entity) {
		if (this.isNew(entity)) {
			this.em.persist(entity);
			return entity;
		} else if (!this.em.contains(entity)) {
			return this.em.merge(entity);
		}

		return entity;
	}

	@Transactional
	public T findOne(final String id) {
		return this.em.find(this.entityClass, id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Transactional
	public List<T> findAll() {
		return this.getSession().createCriteria(this.entityClass).list();
	}

	@Transactional
	public void delete(final T entity) {
		if (!this.getSession().contains(entity)) {
			this.em.remove(this.getSession().merge(entity));
		} else {
			this.em.remove(entity);
		}

	}

	@Transactional
	public boolean isNew(final T entity) {
		if (this.findOne(entity.getUuid()) != null) {
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}

}
