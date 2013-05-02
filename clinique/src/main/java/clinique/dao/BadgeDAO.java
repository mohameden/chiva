package clinique.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import clinique.mapping.Badge;

@Repository
public class BadgeDAO extends CliniqueHibernateDaoSupport<Badge> {

	private static Logger log = Logger.getLogger(BadgeDAO.class);

	public Badge getBadge(String badgeId) {
		log.debug("********** Debut getBadge BadgeDAO **********");
		try {
			Badge badge = null;
			Session session = getSession();
			badge = (Badge) session.get(Badge.class, badgeId);
			return badge;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin getBadge BadgeDAO **********");
		}
	}

	public void saveBadge(Badge badge) {
		log.debug("********** Debut saveBadge BadgeDAO **********");
		try {
			Session session = getSession();
			badge.setStatut(STATUT_SUPPRIME);
			session.save(badge);

		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin saveBadge BadgeDAO **********");
		}
	}

	public void updateBadge(Badge badge) {
		log.debug("********** Debut updateBadge BadgeDAO **********");
		try {
			Session session = getSession();
			session.update(badge);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin updateBadge BadgeDAO **********");
		}
	}

	public void deleteBadge(Badge badge) {
		log.debug("********** Debut deleteBadge BadgeDAO **********");
		try {
			Session session = getSession();
			badge.setStatut(STATUT_SUPPRIME);
			session.update(badge);
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
		} finally {
			log.debug("********** Fin deleteBadge BadgeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Badge> listBadges() {
		log.debug("********** Debut listBadges BadgeDAO **********");
		try {
			List<Badge> badges = null;
			Session session = getSession();
			String strQuery = "select distinct badge ";
			strQuery += "from Badge badge";
			strQuery += "where badge.statut = " + STATUT_VALIDE;
			strQuery += " order by badge.badgeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			badges = query.list();
			return badges;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listBadges BadgeDAO **********");
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Badge> listBadgesSupprimees() {
		log.debug("********** Debut listBadgesSupprimees BadgeDAO **********");
		try {
			List<Badge> badgesSupprimees = null;
			Session session = getSession();
			String strQuery = "select distinct badge ";
			strQuery += "from Badge badge";
			strQuery += "where badge.statut = " + STATUT_SUPPRIME;
			strQuery += " order by badge.badgeId asc";
			org.hibernate.Query query = session.createQuery(strQuery);
			badgesSupprimees = query.list();
			return badgesSupprimees;
		} catch (Exception e) {
			e.printStackTrace();
			log.fatal(e.getMessage());
			return null;
		} finally {
			log.debug("********** Fin listBadgesSupprimees BadgeDAO **********");
		}
	}

	@Override
	protected Class<?> getEntityClass() {
		return Badge.class;
	}

}
