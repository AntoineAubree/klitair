/**
 * 
 */
package fr.diginamic.klitair.dto;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import fr.diginamic.klitair.entity.IndicatorHistory;

/**
 * @author StephanieMC
 *
 */
public class IndicatorHistoryDto {

////////////////////////////////TOWN ///////////////////////////////////////

	/** Town's name */
	@Size(min = 1, max = 200)
	@NotNull
	private String townName;

	/** Town's postCode */
	@Size(min = 5, max = 5)
	@NotNull
	private String TownPostCode;

	/** Town's population */
	@Min(0)
	private int population;
	
///////////////////////////// INDICATORS //////////////////////////////////////

	
	 private List <IndicatorHistory> IndicatorHistory;
	 
	 
/////////////////////////// DATE ////////////////////////////////////////////
	
	private LocalDateTime researchDate;
	
	public IndicatorHistoryDto() {
		
	}

	/**
	 * @param townName
	 * @param townPostCode
	 * @param population
	 * @param indicatorHistory
	 * @param researchDate
	 */
	public IndicatorHistoryDto(@Size(min = 1, max = 200) @NotNull String townName,
			@Size(min = 5, max = 5) @NotNull String townPostCode, @Min(0) int population,
			List<fr.diginamic.klitair.entity.IndicatorHistory> indicatorHistory, LocalDateTime researchDate) {
		super();
		this.townName = townName;
		TownPostCode = townPostCode;
		this.population = population;
		IndicatorHistory = indicatorHistory;
		this.researchDate = researchDate;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("IndicatorHistoryDto [townName=");
		builder.append(townName);
		builder.append(", TownPostCode=");
		builder.append(TownPostCode);
		builder.append(", population=");
		builder.append(population);
		builder.append(", IndicatorHistory=");
		builder.append(IndicatorHistory);
		builder.append(", researchDate=");
		builder.append(researchDate);
		builder.append("]");
		return builder.toString();
	}

	/**
	 * @return the townName
	 */
	public String getTownName() {
		return townName;
	}

	/**
	 * @param townName the townName to set
	 */
	public void setTownName(String townName) {
		this.townName = townName;
	}

	/**
	 * @return the townPostCode
	 */
	public String getTownPostCode() {
		return TownPostCode;
	}

	/**
	 * @param townPostCode the townPostCode to set
	 */
	public void setTownPostCode(String townPostCode) {
		TownPostCode = townPostCode;
	}

	/**
	 * @return the population
	 */
	public int getPopulation() {
		return population;
	}

	/**
	 * @param population the population to set
	 */
	public void setPopulation(int population) {
		this.population = population;
	}

	/**
	 * @return the indicatorHistory
	 */
	public List<IndicatorHistory> getIndicatorHistory() {
		return IndicatorHistory;
	}

	/**
	 * @param indicatorHistory the indicatorHistory to set
	 */
	public void setIndicatorHistory(List<IndicatorHistory> indicatorHistory) {
		IndicatorHistory = indicatorHistory;
	}

	/**
	 * @return the researchDate
	 */
	public LocalDateTime getResearchDate() {
		return researchDate;
	}

	/**
	 * @param researchDate the researchDate to set
	 */
	public void setResearchDate(LocalDateTime researchDate) {
		this.researchDate = researchDate;
	}

	

}
