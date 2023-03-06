package tw.cybertroops.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * 行政區
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "District.findAll", query = "SELECT d FROM District d"),
	@NamedQuery(name = "District.findById", query = "SELECT d FROM District d WHERE d.id = :id"),
	@NamedQuery(name = "District.findByName", query = "SELECT d FROM District d WHERE d.name = :name")
})
@Table(catalog = "\"d2llo9qfp1nudb\"", schema = "\"public\"", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"\"name\""})
})
public class District implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"id\"")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Short id;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"name\"", length = 2147483647)
	@NotNull
	@Size(min = 1, max = 2147483647)
	private String name;

	/**
	 * 預設建構子
	 */
	public District() {
	}

	/**
	 * @param id 主鍵
	 */
	private District(Short id) {
		this.id = id;
	}

	/**
	 * @param name 名稱
	 */
	public District(String name) {
		this.name = name;
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
		if (!(object instanceof District)) {
			return false;
		}
		District other = (District) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "tw.cybertroops.entity.District[ id=" + id + " ]";
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
	 * @return 名稱
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 名稱
	 */
	public void setName(String name) {
		this.name = name;
	}
}
