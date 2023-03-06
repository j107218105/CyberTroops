package tw.cybertroops.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * 金融機構
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "FinancialInstitution.findAll", query = "SELECT f FROM FinancialInstitution f"),
	@NamedQuery(name = "FinancialInstitution.findById", query = "SELECT f FROM FinancialInstitution f WHERE f.id = :id"),
	@NamedQuery(name = "FinancialInstitution.findByCode", query = "SELECT f FROM FinancialInstitution f WHERE f.code = :code"),
	@NamedQuery(name = "FinancialInstitution.findByName", query = "SELECT f FROM FinancialInstitution f WHERE f.name = :name"),
	@NamedQuery(name = "FinancialInstitution.findByShown", query = "SELECT f FROM FinancialInstitution f WHERE f.shown = :shown")
})
@Table(catalog = "\"d2llo9qfp1nudb\"", schema = "\"public\"", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"\"name\""})
})
public class FinancialInstitution implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"id\"")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Short id;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"code\"")
	@NotNull
	private String code;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"name\"")
	@NotNull
	private String name;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"shown\"")
	@NotNull
	private boolean shown;

	/**
	 * 預設建構子
	 */
	public FinancialInstitution() {
	}

	/**
	 * @param id 主鍵
	 */
	private FinancialInstitution(Short id) {
		this.id = id;
	}

	/**
	 * @param code 代碼
	 * @param name 金融機構名稱
	 * @param shown 顯示與否
	 */
	public FinancialInstitution(String code, String name, boolean shown) {
		this.code = code;
		this.name = name;
		this.shown = shown;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof FinancialInstitution)) {
			return false;
		}
		FinancialInstitution other = (FinancialInstitution) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "tw.cybertroops.entity.FinancialInstitution[ id=" + id + " ]";
	}

	/**
	 * @return 主鍵
	 */
	public Short getId() {
		return id;
	}

	/**
	 * @param id 主鍵
	 */
	public void setId(Short id) {
		this.id = id;
	}

	/**
	 * @return 代碼
	 */
	public String getCode() {
		return code;
	}

	/**
	 * @param code 代碼
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * @return 金融機構名稱
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 金融機構名稱
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 顯示與否
	 */
	public boolean isShown() {
		return shown;
	}

	/**
	 * @param shown 顯示與否
	 */
	public void setShown(boolean shown) {
		this.shown = shown;
	}
}
