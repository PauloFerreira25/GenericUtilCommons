package br.com.starssource.common.generic.cache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import br.com.starssource.common.utils.log.Logger;

public class ObjectCache implements Serializable {
	// TODO Melhorar esta classe que vai ser muito boa

	// String = Nome do Cliente
	// CacheClient = Itens do Cliente
	private String system = "GenericUtilCommons";
	private String subsystem = "ObjectCache";
	private Map<String, CacheClient> globalCache;
	private Logger log = new Logger();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Boolean setObjectCache(String Cliente, String NameObjectCache,
			Object ObjectToCache, Integer timeToLife) {
		log.setLogger(system, subsystem, "setObjectCache");
		log.debug("Coloca Objeto em Cache");
		if (globalCache == null){
			globalCache = new HashMap<String, CacheClient>();
		}
		CacheClient a = new CacheClient();
		a.setItem(NameObjectCache, ObjectToCache, timeToLife);
		globalCache.put(Cliente, a);
		return true; 
	}

	public Object getObjectCache(String Cliente, String NameObjectCache) {
		log.setLogger(system, subsystem, "getObjectCache");
		log.debug("Pega Objeto do Cache");
		Object saida = null;
		CacheClient saida1;
		if (globalCache != null){
			saida1 = (CacheClient)globalCache.get(Cliente);
			saida = saida1.getItem(NameObjectCache);
		}
		return saida;
	}

	public Boolean invalidObjectCache(String Cliente, String NameObjectCache) {
		return null;
	}

}
