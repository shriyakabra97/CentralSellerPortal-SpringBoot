/* Autor Anmol Tuteja
creating an interface which extends JPA respository
jpa has inbuild methods to access db
*/
package com.acms.CentralSellerPortal.Repositories;

import com.acms.CentralSellerPortal.Entities.Seller;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellerRepository extends JpaRepository<Seller, Long> {
}
