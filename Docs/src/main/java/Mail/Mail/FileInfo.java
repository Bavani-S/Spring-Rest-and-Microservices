package Mail.Mail;

import java.time.LocalDateTime;

import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
//this will create a cache called docs - the contents of this class must be cached.
@CacheConfig(cacheNames = {"docs"})
public class FileInfo {
	String filename;
	LocalDateTime createDate;
	String type;
	//for cache a particular field only, without this all the fields will be cached.
	@Cacheable(value = "cachfilename",key = "#id")//key will be auto-generated during caching
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public LocalDateTime getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public FileInfo(String filename, LocalDateTime createDate, String type) {
		super();
		this.filename = filename;
		this.createDate = createDate;
		this.type = type;
	}
	
	
}
