package br.com.starssource.common.generic.cache;

public class CacheItem {

	private Object item;
	private Integer timeToLife;

	public Object getItem() {
		return item;
	}

	public void setItem(Object item) {
		this.item = item;
	}

	public Integer getTimeToLife() {
		return timeToLife;
	}

	public void setTimeToLife(Integer timeToLife) {
		this.timeToLife = timeToLife;
	}

}
