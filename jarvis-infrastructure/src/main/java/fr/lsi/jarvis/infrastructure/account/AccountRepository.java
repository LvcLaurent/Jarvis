package fr.lsi.jarvis.infrastructure.account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.lsi.jarvis.domain.account.IAccountRepository;
import fr.lsi.jarvis.domain.account.model.Account;
import fr.lsi.jarvis.domain.exception.JarvisException;
import fr.lsi.jarvis.infrastructure.account.entity.AccountEntity;
import fr.lsi.jarvis.infrastructure.account.mapper.IAccountMapper;
import fr.lsi.jarvis.infrastructure.generic.AbstractJpaRepository;

@Repository
public class AccountRepository extends AbstractJpaRepository<AccountEntity> implements IAccountRepository {

	@Autowired
	IAccountMapper mapper;

	@Override
	protected Class<AccountEntity> getEntityClass() {
		return AccountEntity.class;
	}

	@Override
	@Transactional
	public Account save(final Account entity) throws JarvisException {
		final AccountEntity location = this.save(this.mapper.accountToEntity(entity));
		return this.mapper.entityToAccount(location);
	}

	@Override
	@Transactional
	public Account findByLogin(final String login) throws JarvisException {
		final CriteriaBuilder cb = this.em.getCriteriaBuilder();
		final CriteriaQuery<AccountEntity> cq = cb.createQuery(AccountEntity.class);

		final Root<AccountEntity> account = cq.from(AccountEntity.class);
		final Predicate accountLoginEqual = cb.equal(account.get("login"), login);
		cq.where(accountLoginEqual);

		final TypedQuery<AccountEntity> query = this.em.createQuery(cq);

		if (!query.getResultList().isEmpty()) {
			final AccountEntity tmp = query.getResultList().get(0);
			return this.mapper.entityToAccount(tmp);
		}
		return null;
	}

	@Override
	@Transactional
	public List<Account> findAllEntity() throws JarvisException {
		final List<AccountEntity> array = this.findAll();
		final List<Account> arrayResult = new ArrayList<>();

		for (final AccountEntity account : array) {
			arrayResult.add(this.mapper.entityToAccount(account));
		}

		return arrayResult;
	}

	@Override
	@Transactional
	public void delete(final Account account) throws JarvisException {
		this.delete(this.mapper.accountToEntity(account));

	}

	@Override
	@Transactional
	public List<Account> findAllEntityInactif() throws JarvisException {
		final CriteriaBuilder cb = this.em.getCriteriaBuilder();
		final CriteriaQuery<AccountEntity> cq = cb.createQuery(AccountEntity.class);

		final Root<AccountEntity> account = cq.from(AccountEntity.class);
		final Predicate accountInactifEqual = cb.equal(account.get("actif"), Boolean.FALSE);
		cq.where(accountInactifEqual);

		final TypedQuery<AccountEntity> query = this.em.createQuery(cq);

		final List<AccountEntity> list = query.getResultList();
		final List<Account> resultList = new ArrayList<>();

		if (!list.isEmpty()) {
			for (final AccountEntity accountEntity : list) {
				resultList.add(this.mapper.entityToAccount(accountEntity));
			}
			return resultList;
		}
		return resultList;
	}

	@Override
	@Transactional
	public Account getMail(final String mail) throws JarvisException {
		final CriteriaBuilder cb = this.em.getCriteriaBuilder();
		final CriteriaQuery<AccountEntity> cq = cb.createQuery(AccountEntity.class);

		final Root<AccountEntity> account = cq.from(AccountEntity.class);
		final Predicate accountMailEqual = cb.equal(account.get("mail"), mail);
		cq.where(accountMailEqual);

		final TypedQuery<AccountEntity> query = this.em.createQuery(cq);

		if (!query.getResultList().isEmpty()) {
			final AccountEntity tmp = query.getResultList().get(0);
			return this.mapper.entityToAccount(tmp);
		}
		return null;
	}

	@Override
	@Transactional
	public Account getTel(final String tel) throws JarvisException {
		final CriteriaBuilder cb = this.em.getCriteriaBuilder();
		final CriteriaQuery<AccountEntity> cq = cb.createQuery(AccountEntity.class);

		final Root<AccountEntity> account = cq.from(AccountEntity.class);
		final Predicate accountPhoneNumberEqual = cb.equal(account.get("phoneNumber"), tel);
		cq.where(accountPhoneNumberEqual);

		final TypedQuery<AccountEntity> query = this.em.createQuery(cq);

		if (!query.getResultList().isEmpty()) {
			final AccountEntity tmp = query.getResultList().get(0);
			return this.mapper.entityToAccount(tmp);
		}
		return null;
	}

}
