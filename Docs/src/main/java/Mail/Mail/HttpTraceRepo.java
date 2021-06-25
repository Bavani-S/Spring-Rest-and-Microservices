package Mail.Mail;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;
@Repository
public class HttpTraceRepo implements HttpTraceRepository {
//Atomic reference - LinkedHashSet
//Element reference
//State reference or pushback reference
//Pullback reference
	
	//AtomicReference<HttLpTrace> ref=new  AtomicReference<>();
	ArrayList<HttpTrace> traceList=new ArrayList();
	@Override
	public List<HttpTrace> findAll() {
		//List<HttpTrace> traceList= Collections.singletonList(ref.get());
		System.out.println("Retreived trace");
		return traceList;
	}

	@Override
	public void add(HttpTrace trace) {
		traceList.add(trace);
		System.out.println("Trace added");
	}

} 
