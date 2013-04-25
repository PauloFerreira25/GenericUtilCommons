package br.com.starssource.common.generic.cache;

import java.util.HashMap;
import java.util.Map;

public class CacheClient {
	// String = Nome do Item
	// CacheItem = Item a ser Cacheado
	private Map<String, CacheItem> clientCache;

	public Map<String, CacheItem> getClientCache() {
		return clientCache;
	}
	
	public Boolean setItem(String nome, Object object, Integer timeToLife){
		CacheItem a = new CacheItem();
		a.setItem(object);
		a.setTimeToLife(timeToLife);
		if (clientCache == null){
			clientCache = new HashMap<String, CacheItem>();
		}
		clientCache.put(nome, a);
		return true;
		
	}
	public Object getItem(String nome){
		Object saida = null;
		if (clientCache != null){
			saida = clientCache.get(nome);
		}
		return saida;
	}

	public void setClientCache(Map<String, CacheItem> clientCache) {
		this.clientCache = clientCache;
	}
	
}
