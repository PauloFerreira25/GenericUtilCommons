package br.com.starssource.common.generic.cache;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

import br.com.starssource.common.utils.log.Logger;

public class ObjectCache implements Serializable {
	// TODO Melhorar esta classe que vai ser muito boa

	// String = Nome do Cliente
	// CacheClient = Itens do Cliente
	private String system = "GenericUtilCommons";
	private String subsystem = "ObjectCache";
	private static LinkedHashMap<String, CacheClient> globalCache;
	private Logger log = new Logger();
	private Boolean debugFlag = true;

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectCache() {
		this.globalCache = new LinkedHashMap<String, CacheClient>();
	}

	public Boolean setObjectCache(String cliente, String nameObjectCache,
			Object objectToCache, Integer timeToLife) {
		log.setLogger(system, subsystem, "setObjectCache");
		// log.debug("***************************************************");

		log.debug("Cliente: " + cliente + " - NameObjectCache: "
				+ nameObjectCache + " - ObjectToCache: "
				+ objectToCache.toString() + " - timeToLife: " + timeToLife);

//		log.debug("Coloca Objeto em Cache: " + this.toString() + " Map:"
//				+ globalCache.toString());
		CacheClient a = globalCache.get(cliente);
		if (a == null) {
			a = new CacheClient();
		}
		a.setItem(nameObjectCache, objectToCache, timeToLife);
		globalCache.put(cliente, a);
		// log.debug("***************************************************");
		printHash();
		return true;
	}

	public Object getObjectCache(String cliente, String nameObjectCache)
			throws CacheException {
		printHash();
		log.setLogger(system, subsystem, "getObjectCache");
		Object saida = null;
		// log.debug("Pega Objeto do Cache: " + this.toString());
		try {
			saida = globalCache.get(cliente).getItem(nameObjectCache);
			log.debug("Cliente: " + cliente + " - NameObjectCache: "
					+ nameObjectCache);
			if (saida == null) {
				throw new CacheException();
			}
		} catch (Exception e) {
			throw new CacheException();
		}
		// log.debug("Objeto = " + saida.toString());
		// log.debug("***************************************************");

		return saida;
	}

	public void printHash() {
		if (debugFlag) {
			if (globalCache != null) {
				log.debug("##############################");
				Iterator<Map.Entry<String, CacheClient>> it = globalCache
						.entrySet().iterator();
				while (it.hasNext()) {
					Map.Entry<String, CacheClient> entry = it.next();

					CacheClient a = entry.getValue();
					Iterator<Map.Entry<String, CacheItem>> it2 = a
							.getClientCache().entrySet().iterator();
					while (it2.hasNext()) {
						Map.Entry<String, CacheItem> entry2 = it2.next();
						CacheItem b = entry2.getValue();
						log.debug("Key = " + entry.getKey() + " - Key = "
								+ entry2.getKey() + " - Value = "
								+ b.getItem().toString());
					}

				}
			}
			log.debug("##############################");
		}
	}

	public Boolean invalidObjectCache(String Cliente, String NameObjectCache) {
		return null;
	}

}
