package com.chunkiechunks.domain;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import io.quarkus.hibernate.orm.panache.PanacheQuery;
import io.quarkus.panache.common.Page;
import io.quarkus.panache.common.Sort;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * A user.
 */
@Entity
@Table(name = "sub_families")
public class SubFamily extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String subFamilyId;

    @Size(max = 60)
    @Column(length = 60)
    private String ppp;

    @Size(max = 500)
    @Column(length = 500)
    private String recommendation;

    @Size(max = 50)
    @Column(length = 50)
    private String target;

    @Size(max = 100)
    @Column(length = 100)
    private String odd;

    @Size(max = 50)
    @Column(length = 50)
    private String cycleDeVie;

    @Column(nullable = false)
    private Long familyId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSubFamilyId() {
        return subFamilyId;
    }

    public void setSubFamilyId(String subFamilyId) {
        this.subFamilyId = subFamilyId;
    }

    public String getPpp() {
        return ppp;
    }

    public void setPpp(String ppp) {
        this.ppp = ppp;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getOdd() {
        return odd;
    }

    public void setOdd(String odd) {
        this.odd = odd;
    }

    public String getCycleDeVie() {
        return cycleDeVie;
    }

    public void setCycleDeVie(String cycleDeVie) {
        this.cycleDeVie = cycleDeVie;
    }

    public Long getFamilyId() {
        return familyId;
    }

    public void setFamilyId(Long familyId) {
        this.familyId = familyId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SubFamily)) {
            return false;
        }
        return id != null && id.equals(((SubFamily) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public static PanacheQuery<SubFamily> findAllPaginatedSubFamiliesByFamilyId(Sort sort, Page page, Long familyId) {
        return find("familyId = ?1", sort, familyId).page(page);
    }
}
