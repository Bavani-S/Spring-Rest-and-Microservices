package Mail.Mail;

import java.time.LocalDateTime;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/docs")//context root path
public class DocsOperation {

	ArrayList<FileInfo> fileList=new ArrayList<>();
	@RequestMapping(value="/upload",method=RequestMethod.POST)
	public String uploadFile(@RequestBody String fileName,@RequestBody String type) {
		FileInfo info=new FileInfo(fileName,LocalDateTime.now(),type);
		fileList.add(info);
		return "File uploaded";
		
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String listFiles() {
		String files="";
		for(FileInfo f: fileList)
		{
			files+="<br>"+f.getFilename();
		}
		return files;
		
	}
}
/*
 * ------CMD commands---------
curl -d "filename=demo.txt&type=text" -X POST http://localhost:8084/docs/upload"
curl -d "filename=items.txt&type=text" -X POST http://localhost:8084/docs/upload"
curl -d "filename=data.txt&type=text" -X POST http://localhost:8084/docs/upload"
curl -X GET http://localhost:8084/docs/list
---JSON format---
curl -d '{"filename" : "news.txt","type":"text"}' -X POST http://localhost:8084/docs/upload
curl -d '{"filename" : "image.jpg","type":"jpg"}' -X POST http://localhost:8084/docs/upload
curl -X GET http://localhost:8084/docs/list
*/