package converter.jobs.listener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobExecutionListener;

public class SampleJobListener implements JobExecutionListener{
	
	Date startTime,endTime;
	
	/*		테스트 DB		*/
	@Resource(name="db1SqlSessionFactory")
	private SqlSessionFactory db1SqlSessionFactory;

	
	@Override
	public void beforeJob(JobExecution jobExecution) {
		startTime = jobExecution.getStartTime();
		System.out.println("***** jobStart  : " + formatTime(startTime));
	}
	
	@Override
	public void afterJob(JobExecution jobExecution) {
		
    	endTime = jobExecution.getEndTime(); 
    	SqlSession session = db1SqlSessionFactory.openSession();
    	System.out.println("***** jobEnd : "+formatTime(endTime) + "  /  " + endTime.compareTo(startTime) +  " 소요 " );
    	session.update("updatexxxxx");	
	}

	public String formatTime(Date time) {
		SimpleDateFormat sdf = new SimpleDateFormat();
		sdf.applyPattern("hh:mm:ss");
		return sdf.format(time);
	} // end function formatTime()

}
