package tw.cybertroops.entity;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.*;

/**
 * 網兵
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
@Entity
//@NamedQueries({
//	@NamedQuery(name = "Soldier.findAll", query = "SELECT s FROM Soldier s"),
//	@NamedQuery(name = "Soldier.findById", query = "SELECT s FROM Soldier s WHERE s.id = :id"),
//	@NamedQuery(name = "Soldier.findByName", query = "SELECT s FROM Soldier s WHERE s.name = :name"),
//	@NamedQuery(name = "Soldier.findByEmail", query = "SELECT s FROM Soldier s WHERE s.email = :email"),
//	@NamedQuery(name = "Soldier.findByBirth", query = "SELECT s FROM Soldier s WHERE s.birth = :birth"),
//	@NamedQuery(name = "Soldier.findByGender", query = "SELECT s FROM Soldier s WHERE s.gender = :gender"),
//	@NamedQuery(name = "Soldier.findByForbidden", query = "SELECT s FROM Soldier s WHERE s.forbidden = :forbidden"),
//	@NamedQuery(name = "Soldier.findByCellular", query = "SELECT s FROM Soldier s WHERE s.cellular = :cellular"),
//	@NamedQuery(name = "Soldier.findByFinancialAccountHolder", query = "SELECT s FROM Soldier s WHERE s.financialAccountHolder = :financialAccountHolder"),
//	@NamedQuery(name = "Soldier.findByFinancialAccountNumber", query = "SELECT s FROM Soldier s WHERE s.financialAccountNumber = :financialAccountNumber")
//})
@Table(catalog = "\"d2llo9qfp1nudb\"", schema = "\"public\"", uniqueConstraints = {
	@UniqueConstraint(columnNames = {"\"email\""}),
	@UniqueConstraint(columnNames = {"\"cellular\""}),
	@UniqueConstraint(columnNames = {"\"financialInstitution\"", "\"financialAccountNumber\""})
})
public class Soldier implements java.io.Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 主鍵
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(nullable = false,name="\"id\"")
	private Integer id;

	/**
	 * 全名
	 */
	@Basic(optional = false)
	@Column(nullable = false, name="\"name\"")
	@NotNull
	private String name;

	/**
	 * 電子郵件信箱
	 */
	@Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")
	@Basic(optional = false)
	@Column(nullable = false, name="\"email\"")
	@NotNull
	private String email;

	/**
	 * 電子郵件信箱已認證
	 */
	@Basic(optional = false)
	@Column(nullable = false,name="\"emailVerified\"")
	@NotNull
	private boolean emailVerified;

	/**
	 * 密碼
	 */
	@Basic(optional = false)
	@Column(nullable = false, name="\"password\"")
	@NotNull
	private String password;

	/**
	 * 生日
	 */
	@Basic(optional = false)
	@Column(nullable = false,name="\"birth\"")
	@NotNull
	@Temporal(TemporalType.DATE)
	private Date birth;

	/**
	 * 性別
	 */
	@Basic(optional = false)
	@Column(nullable = false,name="\"gender\"")
	@NotNull
	private boolean gender;

	/**
	 * 被禁止
	 */
	@Basic(optional = false)
	@Column(nullable = false,name="\"forbidden\"")
	@NotNull
	private boolean forbidden;

	/**
	 * 手機
	 */
	@Column(name="\"cellular\"")
	private String cellular;

	/**
	 * 行政區
	 */
	@JoinColumn(name = "\"district\"", referencedColumnName = "\"id\"")
	@ManyToOne
	private District district;

	/**
	 * 金融機構
	 */
	@JoinColumn(name = "\"financialInstitution\"", referencedColumnName = "\"id\"")
	@ManyToOne
	private FinancialInstitution financialInstitution;

	/**
	 * 金融帳戶戶名
	 */
	@Column(name="\"financialAccountHolder\"")
	private String financialAccountHolder;

	/**
	 * 金融帳戶號碼
	 */
	@Column(name="\"financialAccountNumber\"")
	private String financialAccountNumber;

	/**
	 * 職業
	 */
	@JoinColumn(name = "\"industry\"", referencedColumnName = "\"id\"")
	@ManyToOne
	private Industry industry;

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Soldier)) {
			return false;
		}
		Soldier other = (Soldier) object;
		return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
	}

	@Override
	public String toString() {
		return "tw.cybertroops.entity.Soldier[ id=" + id + " ]";
	}

	/**
	 * 預設建構子
	 */
	public Soldier() {
	}

	/**
	 * @param id 主鍵
	 */
	private Soldier(Integer id) {
		this.id = id;
	}

	/**
	 * @param birth 生日
	 * @param gender 性別
	 * @param name 全名
	 * @param email 電子郵件信箱
	 * @param forbidden 被禁止
	 */
	public Soldier(Date birth, boolean gender, String name, String email, boolean forbidden) {
		this.birth = birth;
		this.gender = gender;
		this.name = name;
		this.email = email;
		this.forbidden = forbidden;
	}

	/**
	 * @return 主鍵
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * @param id 主鍵
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return 全名
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name 全名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return 電子郵件信箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email 電子郵件信箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return 電子郵件信箱已認證
	 */
	public boolean isEmailVerified() {
		return emailVerified;
	}

	/**
	 * @param emailVerified 電子郵件信箱已認證
	 */
	public void setEmailVerified(boolean emailVerified) {
		this.emailVerified = emailVerified;
	}

	/**
	 * @return 密碼
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password 密碼
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return 生日
	 */
	public Date getBirth() {
		return birth;
	}

	/**
	 * @param birth 生日
	 */
	public void setBirth(Date birth) {
		this.birth = birth;
	}

	/**
	 * @return 性別
	 */
	public boolean getGender() {
		return gender;
	}

	/**
	 * @param gender 性別
	 */
	public void setGender(boolean gender) {
		this.gender = gender;
	}

	/**
	 * @return 被禁止
	 */
	public boolean getForbidden() {
		return forbidden;
	}

	/**
	 * @param forbidden 被禁止
	 */
	public void setForbidden(boolean forbidden) {
		this.forbidden = forbidden;
	}

	/**
	 * @return 手機
	 */
	public String getCellular() {
		return cellular;
	}

	/**
	 * @param cellular 手機
	 */
	public void setCellular(String cellular) {
		this.cellular = cellular;
	}

	/**
	 * @return 行政區
	 */
	public District getDistrict() {
		return district;
	}

	/**
	 * @param district 行政區
	 */
	public void setDistrict(District district) {
		this.district = district;
	}

	/**
	 * @return 金融機構
	 */
	public FinancialInstitution getFinancialInstitution() {
		return financialInstitution;
	}

	/**
	 * @param financialInstitution 金融機構
	 */
	public void setFinancialInstitution(FinancialInstitution financialInstitution) {
		this.financialInstitution = financialInstitution;
	}

	/**
	 * @return 金融帳戶戶名
	 */
	public String getFinancialAccountHolder() {
		return financialAccountHolder;
	}

	/**
	 * @param financialAccountHolder 金融帳戶戶名
	 */
	public void setFinancialAccountHolder(String financialAccountHolder) {
		this.financialAccountHolder = financialAccountHolder;
	}

	/**
	 * @return 金融帳戶號碼
	 */
	public String getFinancialAccountNumber() {
		return financialAccountNumber;
	}

	/**
	 * @param financialAccountNumber 金融帳戶號碼
	 */
	public void setFinancialAccountNumber(String financialAccountNumber) {
		this.financialAccountNumber = financialAccountNumber;
	}

	/**
	 * @return 職業
	 */
	public Industry getIndustry() {
		return industry;
	}

	/**
	 * @param industry 職業
	 */
	public void setIndustry(Industry industry) {
		this.industry = industry;
	}
}
