package tw.cybertroops.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tw.cybertroops.entity.Soldier;

/**
 * 網兵
 *
 * @author P-C Lin (a.k.a 高科技黑手)
 */
public interface SoldierRepository extends JpaRepository<Soldier, Integer> {
	
	//public long countByGoogleId(@Param(value = "googleId") String googleId);
}
