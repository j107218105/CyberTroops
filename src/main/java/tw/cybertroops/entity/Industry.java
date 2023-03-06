package tw.cybertroops.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * 行業別
 *
 * @author author P-C Lin (a.k.a 高科技黑手)
 */
@Entity
@NamedQueries({
	@NamedQuery(name = "Industry.findAll", query = "SELECT i FROM Industry i"),
	@NamedQuery(name = "Industry.findById", query = "SELECT i FROM Industry i WHERE i.id = :id"),
	@NamedQuery(name = "Industry.findByName", query = "SELECT i FROM Industry i WHERE i.name = :name"),
	@NamedQuery(name = "Industry.findBySequential", query = "SELECT i FROM Industry i WHERE i.sequential = :sequential")
})
@Table(catalog = "\"d2llo9qfp1nudb\"", schema = "\"public\"", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"\"name\""}),
	@UniqueConstraint(columnNames = {"\"sequential\""})
})
public class Industry implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"id\"")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Short id;

	@Basic(optional = false)
	@NotNull
	@Column(nullable = false, name = "\"name\"")
	private String name;

	@Basic(optional = false)
	@Column(nullable = false, name = "\"sequential\"")
	@NotNull
	private short sequential;

	/**
	 * 預設建構子
	 */
	public Industry() {
	}

	/**
	 * @param id 主鍵
	 */
	private Industry(Short id) {
		this.id = id;
	}

	/**
	 * @param name 名稱
	 * @param sequential 順序
	 */
	public Industry(String name, short sequential) {
		this.name = name;
		this.sequential = sequential;
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
		if (!(object instanceof Industry)) {
			return false;
		}
		Industry other = (Industry) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "tw.cybertroops.entity.Industry[ id=" + id + " ]";
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

	/**
	 * @return 順序
	 */
	public short getSequential() {
		return sequential;
	}

	/**
	 * @param sequential 順序
	 */
	public void setSequential(short sequential) {
		this.sequential = sequential;
	}
}
