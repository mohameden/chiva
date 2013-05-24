package clinique.mapping;

public class User extends Entity<User> {
	private static final long serialVersionUID = -3254624837294225658L;
	private int userId;
	private String login;
	private String password;
	private String statut;
	private String operateur;

	private Profil profil;

	public String getLogin() {
		return login;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public String getOperateur() {
		return operateur;
	}

	public void setOperateur(String operateur) {
		this.operateur = operateur;
	}

	public Profil getProfil() {
		return profil;
	}

	public void setProfil(Profil profil) {
		this.profil = profil;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (login == null ? 0 : login.hashCode());
		result = prime * result
				+ (operateur == null ? 0 : operateur.hashCode());
		result = prime * result + (password == null ? 0 : password.hashCode());
		result = prime * result + (profil == null ? 0 : profil.hashCode());
		result = prime * result + (statut == null ? 0 : statut.hashCode());
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		User other = (User) obj;
		if (login == null) {
			if (other.login != null) {
				return false;
			}
		} else if (!login.equals(other.login)) {
			return false;
		}
		if (operateur == null) {
			if (other.operateur != null) {
				return false;
			}
		} else if (!operateur.equals(other.operateur)) {
			return false;
		}
		if (password == null) {
			if (other.password != null) {
				return false;
			}
		} else if (!password.equals(other.password)) {
			return false;
		}
		if (profil == null) {
			if (other.profil != null) {
				return false;
			}
		} else if (!profil.equals(other.profil)) {
			return false;
		}
		if (statut == null) {
			if (other.statut != null) {
				return false;
			}
		} else if (!statut.equals(other.statut)) {
			return false;
		}
		if (userId != other.userId) {
			return false;
		}
		return true;
	}

	@Override
	protected User createEntity() {
		return new User();
	}

	@Override
	public void updateWith(User entity) {
		userId = entity.getUserId();
		login = entity.getLogin();
		password = entity.getPassword();
		statut = entity.getStatut();
		operateur = entity.getOperateur();
		EntityCopier<Profil> aCopier = new EntityCopier<Profil>();
		profil = aCopier.copy(entity.getProfil());
	}

};
