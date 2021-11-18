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
@Table(name = "practices")
public class Practice extends PanacheEntityBase implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min = 1, max = 50)
    @Column(length = 50, unique = true, nullable = false)
    private String practiceId;

    @Size
    @Column(nullable = false)
    private Long subFamilyId;

    @Size(max = 10)
    @Column(length = 10)
    private String planet;

    @Size(max = 10)
    @Column(length = 10)
    private String people;

    @Size(max = 10)
    @Column(length = 10)
    private String prosperity;

    @Size(max = 50)
    @Column(length = 50)
    private String keyword;

    @Size(max = 500)
    @Column(length = 500)
    private String precisionOfRecommendations;

    @Size(max = 500)
    @Column(length = 500)
    private String criteria;

    @Size(max = 1000)
    @Column(length = 1000)
    private String justification;

    @Size(max = 500)
    @Column(name = "test_1_1_1", length = 500)
    private String test111;

    @Size(max = 500)
    @Column(name = "test_1_1_2", length = 500)
    private String test112;

    @Size(max = 500)
    @Column(name = "test_x", length = 500)
    private String testX;

    @Size(max = 500)
    @Column(length = 500)
    private String correspondence;

    @Size(max = 500)
    @Column(length = 500)
    private String correspondenceLink;

    @Size(max = 500)
    @Column(length = 500)
    private String target;

    @Enumerated(EnumType.STRING)
    @Column
    private FormalType formalType;

    @Size(max = 10)
    @Column(length = 10)
    private String difficulty;

    @Size(max = 100)
    @Column(length = 100)
    private String miscComments;

    @Size(max = 100)
    @Column(length = 100)
    private String odds;

    @Column
    private Boolean isUnmissable;

    @Size(max = 50)
    @Column(length = 50)
    private String cycleDeVie;

    @Size(max = 100)
    @Column(length = 100)
    private String tags;

    @Size(max = 200)
    @Column(length = 200)
    private String actors;

    @Size(max = 50)
    @Column(length = 50)
    private String indicators;

    @Size(max = 100)
    @Column(length = 100)
    private String xIndicator;

    @Size(max = 100)
    @Column(length = 100)
    private String yIndicator;

    @Size(max = 50)
    @Column(length = 50)
    private String priority;

    @Size(max = 50)
    @Column(length = 50)
    private String recurrence;

    @Size(max = 500)
    @Column(length = 500)
    private String useCase;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPracticeId() {
        return practiceId;
    }

    public void setPracticeId(String practiceId) {
        this.practiceId = practiceId;
    }

    public Long getSubFamilyId() {
        return subFamilyId;
    }

    public void setSubFamilyId(Long subFamilyId) {
        this.subFamilyId = subFamilyId;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public String getPeople() {
        return people;
    }

    public void setPeople(String people) {
        this.people = people;
    }

    public String getProsperity() {
        return prosperity;
    }

    public void setProsperity(String prosperity) {
        this.prosperity = prosperity;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getPrecisionOfRecommendations() {
        return precisionOfRecommendations;
    }

    public void setPrecisionOfRecommendations(String precisionOfRecommendations) {
        this.precisionOfRecommendations = precisionOfRecommendations;
    }

    public String getCriteria() {
        return criteria;
    }

    public void setCriteria(String criteria) {
        this.criteria = criteria;
    }

    public String getTest111() {
        return test111;
    }

    public void setTest111(String test111) {
        this.test111 = test111;
    }

    public String getTest112() {
        return test112;
    }

    public void setTest112(String test112) {
        this.test112 = test112;
    }

    public String getTestX() {
        return testX;
    }

    public void setTestX(String testX) {
        this.testX = testX;
    }

    public String getCorrespondence() {
        return correspondence;
    }

    public void setCorrespondence(String correspondence) {
        this.correspondence = correspondence;
    }

    public String getCorrespondenceLink() {
        return correspondenceLink;
    }

    public void setCorrespondenceLink(String correspondenceLink) {
        this.correspondenceLink = correspondenceLink;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public FormalType getFormalType() {
        return formalType;
    }

    public void setFormalType(FormalType formalType) {
        this.formalType = formalType;
    }

    public String getOdds() {
        return odds;
    }

    public void setOdds(String odds) {
        this.odds = odds;
    }

    public Boolean getUnmissable() {
        return isUnmissable;
    }

    public void setUnmissable(Boolean unmissable) {
        isUnmissable = unmissable;
    }

    public String getCycleDeVie() {
        return cycleDeVie;
    }

    public void setCycleDeVie(String cycleDeVie) {
        this.cycleDeVie = cycleDeVie;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getIndicators() {
        return indicators;
    }

    public void setIndicators(String indicators) {
        this.indicators = indicators;
    }

    public String getxIndicator() {
        return xIndicator;
    }

    public void setxIndicator(String xIndicator) {
        this.xIndicator = xIndicator;
    }

    public String getyIndicator() {
        return yIndicator;
    }

    public void setyIndicator(String yIndicator) {
        this.yIndicator = yIndicator;
    }

    public String getRecurrence() {
        return recurrence;
    }

    public void setRecurrence(String recurrence) {
        this.recurrence = recurrence;
    }

    public String getUseCase() {
        return useCase;
    }

    public void setUseCase(String useCase) {
        this.useCase = useCase;
    }

    public String getJustification() {
        return justification;
    }

    public void setJustification(String justification) {
        this.justification = justification;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public String getMiscComments() {
        return miscComments;
    }

    public void setMiscComments(String miscComments) {
        this.miscComments = miscComments;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Practice)) {
            return false;
        }
        return id != null && id.equals(((Practice) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    public static PanacheQuery<Practice> findAllPaginatedPracticesBySubFamilyId(Sort sort, Page page, Long subFamilyId) {
        return find("subFamilyId = ?1", sort, subFamilyId).page(page);
    }

    public enum FormalType {
        RECO("Recommendation"),
        CONSEIL("Advice");

        private final String name;

        FormalType(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }

}
