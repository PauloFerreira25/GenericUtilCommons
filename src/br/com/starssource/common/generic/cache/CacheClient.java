package br.com.starssource.common.generic.cache;

import java.util.LinkedHashMap;

public class CacheClient {
	// String = Nome do Item
	// CacheItem = Item a ser Cacheado
	private LinkedHashMap<String, CacheItem> clientCache;

	public LinkedHashMap<String, CacheItem> getClientCache() {
		return clientCache;
	}

	public Boolean setItem(String nome, Object object, Integer timeToLife) {
		CacheItem a = new CacheItem();
		a.setItem(object);
		a.setTimeToLife(timeToLife);
		if (clientCache == null) {
			clientCache = new LinkedHashMap<String, CacheItem>();
		}
		clientCache.put(nome, a);
		return true;

	}

	public Object getItem(String nome) {
		Object retorno = null;
		CacheItem saida = null;
		if (clientCache != null) {
			saida = clientCache.get(nome);
			if (saida != null) {
				retorno = saida.getItem();
			}
		}
		return retorno;
	}

	public void setClientCache(LinkedHashMap<String, CacheItem> clientCache) {
		this.clientCache = clientCache;
	}

}
